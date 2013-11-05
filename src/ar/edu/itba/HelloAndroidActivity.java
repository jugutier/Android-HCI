package ar.edu.itba;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import ar.edu.itba.model.GetAllStates;
import ar.edu.itba.services.FetchJSONDataTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HelloAndroidActivity extends Activity {
	

    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after 
     * previously being shut down then this Bundle contains the data it most 
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("TEST");
      //testGSON(); El primer intento "cableado"
      //  testGSON2();El segundo intento request desde el thread de UI
        testAsyncJSON();
        
      
        
        /*UTIL
         *Ejemplo de uso de shared preferences  
      	SharedPreferences sp = getPreferences(MODE_PRIVATE);
      	SharedPreferences.Editor editor = sp.edit();
     
      	editor.putString("PASSWORD_VALUE", "123456");
      	editor.commit();//IMPORTANTE! 
      
      
       	Asi se levantan del otro lado 
     	String s= sp.getString("PASSWORD_VALUE","-1");*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(ar.edu.itba.R.menu.main, menu);
        return true;
    }
    public void onProductClick(View view){
    	Intent intent = new Intent(this,ProductActivity.class);
    	intent.putExtra(ProductActivity.EXTRA_MESSAGE, "prueba");
    	startActivity(intent);
    	
    }
    private void testAsyncJSON(){
    	FetchJSONDataTask task = new FetchJSONDataTask();
    	task.execute( new String[] { "http://eiffel.itba.edu.ar/hci/service3/Common.groovy?method=GetAllStates" } );
    }
    private String test = "{ \"meta\": {\"uuid\": \"22920a89-d641-4598-be7f-0e1dd42cefec\",\"time\": \"18.825ms\"},\"states\": [  {\"stateId\": \"C\",\"name\": \"Ciudad Autonoma de Buenos Aires\" },  {\"stateId\": \"B\", \"name\": \"Buenos Aires\"     }    ]}";    
    
    /**
     * Testeo desde el string "cableado" con la respuesta del API
     */
    @SuppressWarnings("unused")
    private void testGSON(){
    	Gson gson = new GsonBuilder().create();
        GetAllStates states = gson.fromJson(test, GetAllStates.class);
        System.out.println(states);
        System.out.println(states.getStates().get(0).getName());
    }
    /**
     * Testeo haciendo la peticion web desde el Thread de UI
     * ... Android no lo permite.
     */
    @SuppressWarnings("unused")
    private void testGSON2(){
    	Gson gson = new GsonBuilder().create();
    	BufferedReader reader = getJSONData("http://eiffel.itba.edu.ar/hci/service3/Common.groovy?method=GetAllStates");
        GetAllStates states = gson.fromJson(reader, GetAllStates.class);
        System.out.println(states);
        System.out.println(states.getStates().get(0).getName());
    	
    }

    public BufferedReader getJSONData(String url){
        // create DefaultHttpClient
        HttpClient httpClient = new DefaultHttpClient();
        URI uri; // for URL
        InputStream data = null; // for URL's JSON

        try {
            uri = new URI(url);
            HttpGet method = new HttpGet(uri); // Get URI
            HttpResponse response = httpClient.execute(method); // Get response from method.  
            data = response.getEntity().getContent(); // Data = Content from the response URL. 
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new BufferedReader(new InputStreamReader(data));
    }

}

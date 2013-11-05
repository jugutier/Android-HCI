package ar.edu.itba.services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import ar.edu.itba.model.GetAllStates;
import ar.edu.itba.model.ModelObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Ejemplo de una llamada por medio de Asynctask. La clase que android nos provee para facilitar el manejo
 * de Threading. Recodremos que en general estas clases son inner dentro de la que necesita hacer algo asicronico.
 * Segun lo que vimos podria estar en "ApiService" (la clase que extiende de IntentService)
 *
 */
public class FetchJSONDataTask extends AsyncTask<String, Void, ModelObject> {

    // This gets executed on a background thread
    protected ModelObject doInBackground(String... params) {
        String urlString = params[0];//Solo vamos a usar un parametro de los argumentos variables
        BufferedReader reader = getJSONData( urlString );
        Gson gson = new GsonBuilder().create();
        GetAllStates states = gson.fromJson(reader, GetAllStates.class);
        System.out.println(states);
        System.out.println(states.getStates().get(0).getName());
        return states;
    }

    // This gets executed on the UI thread
    protected void onPostExecute(ModelObject mObj) {
    	GetAllStates states = (GetAllStates) mObj;
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

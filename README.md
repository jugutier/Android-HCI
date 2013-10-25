HCIQ2GX-BASE
============

Código base para el TPE2-Android, HCI ITBA Q2 2013


#Instructivo de instalación:
* [Descargue](http://www.genuitec.com/sdc/cloud/install/2851-dza-4943) el eclipse customizado con todos los plugins que necesitaremos. **(300MB)**

**Observación:** En Mac no funciona desde Chrome, usar Safari, debe tener Java 7 instalado.

Una vez finalizada la descarga tendra una version de eclipse preconfigurada,
cuando se abra el eclipse en el marco inferior derecho haga click en "configure workspace" dejando que la herramienta termine de descargar el material necesario.**Tenga en cuenta que este eclipse sera utilizado durante todo el desarrollo y sera una instalacion distinta a cualquier otro eclipse que ya tenga instalado**


* [Descargue](http://developer.android.com/sdk/index.html) el SDK de Android **(72MB)**. Necesitará solo el SDK asi que vaya donde indica "Use an existing IDE" y a continuación "Download SDK Tools" para su sistema operativo. Ubique la carpeta **EN EL MISMO DIRECTORIO QUE EL ECLIPSE**.
 * Exportar la variable de entorno **ANDROID_HOME** para que apunte a donde se encuentra el **SDK** descargado en el paso anterior. En mi caso use el siguiente comando de **consola**:


		export ANDROID_HOME=/Applications/eclipse/android-sdks/
	Verifique que fue exportada exitosamente mediante el comado **ls $ANDROID_HOME** deberia encontrar las siguientes carpetas `add-ons		build-tools	extras		platform-tools	platforms	system-images	temp		tools`
* **Clone** este repositorio de github y extraigalo a una ubicación **EXTERNA** a su workspace. De ser posible busque alguna forma de añadir el contenido de este repositorio a una carpeta dentro de su actual repositorio git. **Recuerde que la engrega sera en el mismo repositorio que el TPE1**. 

``Si opta por clonar recuerde no pushear los cambios que genere a este repositorio, ya que entraran en conflico con los demás grupos.``

* Con el Eclipse abierto hacer desde la barra de herramientas 

		File > Import> Existing android code into workspace 
		
	Apuntando a la carpeta que contiene el repositorio clonado.
	
###Hasta ahora tenemos:
* Eclipse con todos los plugins que vamos a necesitar
* SDK de android ubicado en el mismo directorio del eclipse y su correspondiente variable de entorno **ANDROID_HOME**
* Un workspace con este repositorio clonado e importado en el eclipse
* El ícono del proyecto de eclipse debera verse así:
	![My image](https://raw.github.com/jugutier/HCIQ2GX-BASE/master/guia.jpg). Lo que indica que eclipse lo reconoce como Git, Maven y Android. Que son los tres plugins que necesitamos.
* El proyecto sin errores 
	* Para verificarlo abra desde el eclipse **pom.xml** y haga click en 
								
			play> maven clean y luego maven install
		 verá como se descargan las librerias externas desde la consola de eclipse.
*  Si tiene algun error consulte la sección de **Solución de errores**

###Faltan algunos detalles:
Notará una nueva barra de herramientas en el eclipse. Abra en **Android SDK Manager**.
Verá un menú como [este](http://developer.android.com/tools/help/sdk-manager.html). Tilde y descargue **TODO** el contenido correspondiente al **API 18**. Tenga en cuenta que para el deploy a los dispositivos del laboratorio estaremos usando tambien el contenido del **API 15**, por ahora no descargue ese contenido. Lo hablaremos durante el taller.  

######Necesitamos configurar el emulador:
De la nueva barra del eclipse abra el [AVD](http://developer.android.com/tools/devices/managing-avds.html) (Se encuentra al lado del que acabamos de usar). Presione new y en el menu emergente ingresar los siguientes datos:

* AVD Name: HCI-Phone
* Device: Nexus 4
* Target Android 4.3 (Deberia ser la unica opcion del menu por ahora)
* Los dos checkbox tildados
* Front Camara:None
* Back Camera: Webcam si posee o Emulated sino.
* Al menos **2Gb** de **RAM**. Tenga en cuenta que se usara a demanda, es decir que es un máximo, no que ocupará ese espacio siempre.
* Internal Storage **200Mb** 
* SD Card **200Mb**. El mismo criterio de máximo aplica para estos dos puntos.
* Emulation options: Tilde la opción **Snapshot**

Presione **OK**. Debera esperar un tiempo hasta que se cree el dispositivo.


#Listo!
=======
###Solución de errores:
#####Maven no detecta el SDK
Ejecutar el siguiente comando en consola, situado sobre la carpeta que contiene el **pom.xml** aseugrandose de que el path efectivamente contiene el archivo mencionado.

	mvn install:install-file \
	-Dfile=$ANDROID_HOME/platforms/android-18/android.jar \
	-DgroupId=com.google.android \
	-DartifactId=android \
	-Dversion=4.3 \
	-Dpackaging=jar \
	-DgeneratePom=true

###Material Extra:
* [Como resolver un conflicto de git en modo grafico](http://wiki.eclipse.org/EGit/User_Guide#Resolving_a_merge_conflict), via **Egit**


* [Documentación oficial](https://code.google.com/p/google-gson/) y ejemplos de GSON

	* [Ejemplo 1](http://stackoverflow.com/questions/5314813/json-gson-fromjson-java-objects)

	* [Ejemplo 2](http://albertattard.blogspot.com.ar/2009/06/practical-example-of-gson.html)
	* [Ejemplo 3](http://www.mkyong.com/java/how-do-convert-java-object-to-from-json-format-gson-api/)

============
#Pasos con los que cree el material de este repositorio:



* Descargar eclipse kepler
* [Descargar](http://developer.android.com/sdk/index.html) el SDK de Android
###Instalacion de Plugins:
Repita los siguientes pasos para cada uno de los links listados a continuación:

* Click Help
* Click Install New Software
* Uncheck the box labeled Group items by category (this step is important or you won't see the connector in the table)
* Paste in this URL 

####Links (Respetar el orden):


* Instalar plugin de maven: [http://download.eclipse.org/technology/m2e/releases](http://)
* Instalar plugin de Egit:  
[http://download.eclipse.org/ egit/updates ](http://)
* Instalar plugin de Maven Egit (Que hace que funcionen en conjunto los respectivos plugins):
[http://repository.tesla.io:8081/nexus/content/sites/m2e.extras/m2eclipse-egit/0.14.0/N/0.14.0.201305250025/](http://)
* Instalar plugin de android:  
[https://dl-ssl.google.com/android/eclipse/](http://)
* Instalar plugin de android-maven (La especializacion de Maven para android):
[http://marketplace.eclipse.org/content/android-configurator-m2e#.UmVAmBbmdz8](http://)

#Importante: 
###Guardar el SDK de Android DENTRO de la carpeta que contiene el eclipse.



Exportar la variable de entorno **ANDROID_HOME**, que apunte 

a donde se encuentra el sdk 18 de android. En mi caso use el siguiente comando de consola:


	export ANDROID_HOME=/Applications/eclipse/android-sdks/

Ejecutar este comando parado fuera del workspace

	mvn archetype:generate \
	-DarchetypeArtifactId=android-quickstart \
	-DarchetypeGroupId=de.akquinet.android.archetypes \
	-DarchetypeVersion=1.0.11 \
	-DgroupId=ar.edu.itba \
	-DartifactId=hci-application \
	-Dplatform=18


  **Fuente:** [http://stand.spree.de/wiki_details_maven_archetypes](http://)

Desde el eclipse hacer 

	File > Import> Existing android code into workspace 

y apuntarle a la carpeta "hci-application" que genero la ejecucion del comando anterior
  Observacion: tildar la casilla "copy code into workspace"

Ir a

	 proyect properties>Android Target= Android 4.3



Ir a proyect properties>configure>convert to maven proyect

reemplazar version en el pom por

	<version>4.3</version>
	
Ejecutar el siguiente comando en consola, situado sobre la carpeta que contiene el pom.xml

	mvn install:install-file \
	 -Dfile=$ANDROID_HOME/platforms/android-18/android.jar \
	-DgroupId=com.google.android \
	-DartifactId=android \
	-Dversion=4.3 \
	-Dpackaging=jar \
	-DgeneratePom=true
###Agregar las siguientes dependencias al pom.xml:
	 Biblioteca de compatibilidad de android 4 hacia versiones anteriores
	 
	<dependency>
		<groupId>com.google.android</groupId>
		<artifactId>support-v4</artifactId>
		<version>r7</version>
	</dependency>
	
 	Gson: Java to Json conversion 
 	
    <dependency>
      <groupId>com.google.code.gson</groupId>
      <artifactId>gson</artifactId>
      <version>2.2.4</version>
      <scope>compile</scope>
    </dependency>
    
    ZXing QR Scanning
    <dependency>
		<groupId>com.google.zxing</groupId>
		<artifactId>android-integration</artifactId>
		<version>2.2</version>
	</dependency>

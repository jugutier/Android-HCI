HCIQ2GX-BASE
============

Base android code for special assignment 2, HCI ITBA Q2 2013


Instructivo de instalacion:

descargar eclipse kepler
instalar plugin de maven http://download.eclipse.org/technology/m2e/releases
instalar plugin de git  http://download.eclipse.org/egit/updates 
instalar plugin de android https://dl-ssl.google.com/android/eclipse/

ejecutar este comando parado fuera del workspace
 mvn archetype:generate \
  -DarchetypeArtifactId=android-quickstart \
  -DarchetypeGroupId=de.akquinet.android.archetypes \
  -DarchetypeVersion=1.0.11 \
  -DgroupId=ar.edu.itba \
  -DartifactId=hci-application \
  -Dplatform=18


  fuente: http://stand.spree.de/wiki_details_maven_archetypes

  desde el eclipse hacer file>import>existing android code into workspace y apuntarle a la carpeta "hci-application" que genero la ejecucion del comando anterior
  Observacion: tildar la casilla "copy code into workspace"


  ir a proyect properties>Android Target= Android 4.3

  cambiar el path a la actividad principal en el manifest

 ir a proyect properties>configure>convert to maven proyect

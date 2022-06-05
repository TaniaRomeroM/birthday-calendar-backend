
/* BBDD */

 - Herramientas/puertos utilizados en el proyecto - 
Gestor de BBDD: HeidiSQL
Despliegue de MySQL: Docker
Puerto:33060
 
1º Arrancar el servidor MySQL. 
2º Cargar el script '/src/main/resources/db/scripts/calendarbd.sql' para generar la base de datos con datos de prueba.



/* BACKEND */

 - Herramientas/puertos utilizados en el proyecto - 
IDE: IntelliJ IDEA
Puerto: 8080

1º Abrir el proyecto.
2º Cambiar el archivo '/src/main/resources/static/application.properties' si se ejecuta en otro puerto.
3º Compilar el backend
		mvn clean install
4º Iniciar la aplicacion haciendo click en '/src/main/java/com/proyectocalendar/birthdaycalendar/BirthdaycalendarApplication' y pulsando Run.



/* FRONTEND */

 - Herramientas/puertos utilizados en el proyecto - 
Editor de codigo: Visual Studio Code
Puerto: 4200

1º Ejecutar el comando 'npm install' en la consola cmd (en powershell no funciona, ya que tiene una restriccion de ejecucion de ciertos scripts).
2º Ejecutar el servidor y abrir el navegador con el comando 'ng serve --open'.

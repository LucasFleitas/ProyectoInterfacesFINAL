Instrucciones para ejecutar la aplicación
Este proyecto está basado en Java 23 y utiliza JavaFX 23.0.2 para la interfaz gráfica. A continuación, se detallan los pasos necesarios para ejecutar la aplicación correctamente.

Requisitos
JDK 23 instalado en tu sistema.
JavaFX SDK 23.0.2 instalado y configurado en tu sistema.
Pasos para ejecutar la aplicación
Asegúrate de tener Java instalado: Para comprobar que tienes Java 23 instalado en tu máquina, abre la línea de comandos (CMD) y ejecuta:


java -version
Deberías ver algo similar a:
java version "23.0.2" 2025-01-21
Java(TM) SE Runtime Environment (build 23.0.2+11-29)
Java HotSpot(TM) 64-Bit Server VM (build 23.0.2+11-29, mixed mode)

Ubicación de tu archivo .exe: Navega a la carpeta donde se encuentra el archivo ejecutable de tu aplicación (Aplicacion.exe).

Ejecutar la aplicación desde CMD:

Abre una ventana de CMD en la misma carpeta donde se encuentra el archivo .exe.
Ejecuta el siguiente comando, sustituyendo la ruta de javafx-sdk-23.0.2\lib si es necesario:

java --module-path "C:\Program Files\Java\javafx-sdk-23.0.2\lib" --add-modules javafx.controls,javafx.fxml -jar Aplicacion.exe
Nota: Si tu JavaFX SDK está instalado en otra ubicación, reemplaza "C:\Program Files\Java\javafx-sdk-23.0.2\lib" con la ruta correcta donde tengas los archivos de JavaFX.

Generación de informes: Al ejecutar la aplicación, verás botones que generan diferentes tipos de informes. Los informes se guardarán en la misma carpeta donde se encuentra el archivo .exe. Asegúrate de tener permisos para escribir en esa carpeta.

Problemas comunes
No se encuentra JavaFX: Si obtienes un error indicando que JavaFX no se encuentra, asegúrate de que la ruta proporcionada en el comando para --module-path sea correcta y que los archivos .jar de JavaFX estén en la carpeta especificada.

Problemas con la versión de Java: Si no estás usando la versión correcta de Java (JDK 23), descarga e instala JDK 23 desde el sitio oficial de Oracle.
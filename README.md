# MISW-4203-AplicacionesMoviles

Este proyecto fue generado con la versión 1.7.10 de Kotlin y la versión 2021.3.1 de Android Studio

## Servidor de Desarrollo

Para descargar el código fuente en su maquina local tiene tres opciones:
1. Desde el menú de Android Studio vaya a file -> new -> project from Version Control, e ingrese la url, finalmente de click en Clone

    ![from version control](https://user-images.githubusercontent.com/99267339/200183806-b6891489-fe11-4e35-9187-9974cfb9d3d0.png)


2. Descargar un archivo .zip directamente de este repositorio, haciendo click en el botón *"Download Zip"* del desplegable *Code*. Descomprimalo y desde Android Studio vaya a file -> open y en la ventana emergente que se abre, seleccione el folder del proyecto. 

    ![download repo](https://user-images.githubusercontent.com/99267339/200150580-5a930e8e-bd90-4f28-aa13-5386b5e5a2b0.png)

3. Si tiene Git instalado, desde una consola de comandos ejecute el comando en la carpeta o folder donde desee guardar el proyecto
   
   ```
   git clone https://github.com/mcgomeztuniandes/MISW-4203-AplicacionesMoviles.git
   ```
   
   Finalmente, desde Android Studio vaya a file -> open y en la ventana emergente que se abre, seleccione el folder del proyecto. 

**Nota:**
La primera vez que abre el proyecto verá que Android Studio ejecuta algunas acciones en segundo plano. Espere a que finalice y cuando haya terminado, en la parte superior del menú de click en *Run 'app'*. Posiblemente deba actualizar las dependencias necesarias para que el proyecto se ejecute, en este caso, Android Studio arrojara una alerta, siga los pasos para actualizar en caso de ser necesario. 

Si por algun motivo el botón *Run 'app'* aparece deshabilitado debe cerciorarse que tenga por lo menos un dispositivo virtual creado o un dispositivo fisico conectado vía USB. 

### Cómo crear un dispositivo virtual.

1. Desde el menú vaya al apartado *tools* y en la lista desplegable seleccione *Device Manager*.
2. Seleccione la opción *create device* 
3. En la ventana emergente que se abre, seleccione un dispositivo del listado. 
4. Click en Next y seleccione la **API Level**. En este caso seleccione Android 5.1 (Lollipop) o superior
5. Por último, en el campo *graphics* seleccione la opción *Automatic*. Si su computador cuenta con una tarjeta de video dedicada, selecione la opción *Hardware*
  
   ![virtual device](https://user-images.githubusercontent.com/99267339/200150748-6c79b690-a32c-4f64-b784-236d450b2fbc.png)

  
### Configurar un dispositivo físico
1. En primer lugar, debe habilitar el modo desarrollador de su celular y la depuración USB. Esto depende de la marca y la versión del celular.
2. Conecte el dispositivo físico
3. Desde el menú vaya al apartado *tools* y en la lista desplegable seleccione *Device Manager*
4. Seleccione la opción *physical* y de ser necesario instale el plugin

   ![physical device](https://user-images.githubusercontent.com/99267339/200151312-fb3fe431-4536-48ad-9d50-df7b7c28a245.png)


## Ejecutar pruebas end-to-end 

Para ejecutar las pruebas end-to-end se debe abrir el proyecto desde Android Studio y seguir los siguientes pasos:
1. En el menú superior Seleccionar la opción *Test in 'e2e'* y sincronizar las dependencias desde el archivo Gradle.

    ![e2e](https://user-images.githubusercontent.com/99267339/200183504-0188f414-f9e9-4abe-91b6-f8c6e6c7ab26.png)


2. Desde la vista Android del proyecto, ir a *app/java/e2e* y en este folder se listan los archivos de pruebas existentes. Si esea ejecutar todas las pruebas dar click derecho sobre la carpeta *e2e* y dar click en *RUN*. Si solo quiere ejecutar un archivo de pruebas de manera independiente, click derecho sobre el archivo y click en *RUN*

    ![e2e 2](https://user-images.githubusercontent.com/99267339/200183507-d6e1d45d-486c-4378-8ab3-c3492673854a.png)

    
4. Verificar el log de resultados de las pruebas

Las pruebas se ejecutaron en las siguientes versiones de Android

| Version API    | Dispositivo Emulado  |
|----------------|----------------------|
| 22 Lollipop    | MotoOneAction - 6.4" |
| 23 Marshmollow | Pixel 5 - 6.0"       |
| 24 Nougat      | Pixel 6 - 6.4"       |

Los resultados y los artefactos generados se encuentran disponibles en la [Wiki](https://github.com/mcgomeztuniandes/MISW-4203-AplicacionesMoviles/wiki/Artefactos-de-Pruebas) del proyecto

## Instalar APK
Descargar el apk e instalelo en un dispositivo Android. Tenga en cuenta que debe permitir instalar aplicaciones *no seguras* debido a que no se descargan directamente del Play Store. Seleccione la opción **Instalar de todas formas**

![no seguro](https://user-images.githubusercontent.com/99267339/200183232-7cc3ca55-53c9-4320-9673-479473c25bf0.png)





# MISW-4203-AplicacionesMoviles

Este proyecto fue generado con la versión 1.7.10 de Kotlin y la versión 2021.3.1 de Android Studio

## Development server

Para descargar el código fuente en su maquina local tiene tres opciones:
1. Desde el menú de Android Studio vaya a file -> new -> project from Version Control, e ingrese la url, finalmente de click en Clone

![open project AS](https://user-images.githubusercontent.com/99267339/200150561-aa13e27c-54bc-4f62-b46f-f8b9aeba1b64.png)

2. Descargar un archivo .zip directamente de este repositorio, haciendo click en el botón *"Download Zip"* del desplegable *Code*. Descomprimalo y desde Android Studio vaya a file -> open y en la ventana emergente que se abre, seleccione el folder del proyecto. 

![download repo](https://user-images.githubusercontent.com/99267339/200150580-5a930e8e-bd90-4f28-aa13-5386b5e5a2b0.png)

3. Si tiene Git instalado, desde una consola de comandos ejecute el comando `git clone https://github.com/mcgomeztuniandes/MISW-4203-AplicacionesMoviles.git` en la carpeta o folder donde desee guardar el proyecto. Finalmente, desde Android Studio vaya a file -> open y en la ventana emergente que se abre, seleccione el folder del proyecto. 

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


## Running end-to-end tests

Para ejecutar las pruebas end-to-end se debe abrir el proyecto desde Android Studio y sega los siguientes pasos:
1. 

**Nota:** ....

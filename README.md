# MISW-4203-AplicacionesMoviles

Este proyecto fue generado con la versión 1.7.10 de Kotlin y la versión 2021.3.1 de Android Studio
## Internacionalización

Para esta entrega se habilitó la internacionalización para los idiomas inglés y español. Para probarlo en el dispositivo, se debe instalar el [APK](https://github.com/mcgomeztuniandes/MISW-4203-AplicacionesMoviles/tree/main/app/Sprint_3) y cambiar la configuración de idioma del celular de inglés a español y viceversa.

* <b>Para tener en cuenta</b>: Al ejecutar las pruebas E2E se debe tener configurado el dispositivo en el idioma inglés, ya que es el idioma por defecto de la aplicación.

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

## Pruebas

### Ejecutar pruebas end-to-end 

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

### Instalar APK
Descargar el apk e instalelo en un dispositivo Android. Tenga en cuenta que debe permitir instalar aplicaciones *no seguras* debido a que no se descargan directamente del Play Store. Seleccione la opción **Instalar de todas formas**

![image](https://user-images.githubusercontent.com/99267339/204155871-33e21aff-887a-4cc1-b471-4ee22a9c683a.png)



### Ejecutar pruebas de reconocimiento con monkeys

Siga los siguientes pasos: 

1. Conecte el dispositivo móvil a su computadora y asegure que esté conectado en modo de **transferencia de archivos** y tenga activadas las opciones de **desarrollador**, en particular con los permisos de instalación y depuración por ADB. 

2. Verifique si se estableció el puente ABD ejecutando en la terminal el siguiente comando:

```
abd devices
```
    
  En el resultado debería estar incluído el/los dispositivo(s) conectado(s):
  
```
C:\Users\su_usuario>adb devices
List of devices attached
emulator-5554   device
```

**Nota:** si el comando `adb devices` arroja error o no es reconocido por el sistema, debe agregar `adb` como variable de entorno de acuerdo a su sistema operativo. 
    
Recuerde que el `path` de la variable `adb` puede variar de acuerdo a donde haya instalado el SDK de Android en su computador. Por defecto, en sistema operativo Windows, la ruta de instalación por defecto es:
    
```
C:\Users\SU_USUARIO\AppData\Local\Android\Sdk\platform-tools\ 
```

3. Para ejecutar pruebas de Monkey, primero es necesario que el APK esté instalado en el dispositivo Android y sea reconocido por el *Packet Manager*. Para esto, desde la misma terminal ubique el archivo [APK](https://github.com/mcgomeztuniandes/MISW-4203-AplicacionesMoviles/tree/main/app/Sprint_3) , y ejecute el siguiente comando para instalarlo en el dispositivo:

```
adb install app-vynils-final-grupo15.apk
```
4. Abra la aplicación y desde la configuración propia de su dispositivo *fije* la aplicación. 

![image](https://user-images.githubusercontent.com/99267339/204154646-c6117374-17b9-42bd-8d99-ebc5a9407391.png)

5. Llene el formulario del login e ingrese para que el monkey ejecute las pruebas desde la pantalla principal (Home)

![image](https://user-images.githubusercontent.com/99267339/204154587-e2dbbee2-d977-46d6-b501-4ee9d5017467.png)


6. Desde una terminal ejecute la prueba del monkey con el comando

```
adb shell monkey -p com.example.vinilosgrupo15 -s 3 --pct-syskeys 0 --throttle 100 --pct-majornav 10 -v -v 2000
```
Este comando genera 2000 eventos que dentro de la aplicación con distribución que privilegia eventos de navegación dentro de la misma. Además, se fija una semilla en 3. Preste atención a la pantalla de su dispositivo, ya que los eventos generan interacciones reales en el mismo que usted podrá observar.

Adicionalmente, en la terminal usted podrá ver que se muestran los resultados de la prueba

### Ejecutar pruebas de reconocimiento con Firebase Testlab

Para poder ejecutar estas pruebas debe crear un proyecto con su cuenta de Google en Firebase. Cree una aplicación cualquiera con la opción de Google Analytics activada y siga los siguientes pasos:

1. Ingrese a la aplicación recién creada y busque en el panel lateral izquierdo la opción Test Lab. 

![image](https://user-images.githubusercontent.com/99267339/204155485-e8e254ac-b716-457c-aa38-32e7bad40076.png)

2. En la ventana que se abre dar click en Run a test

3. Cargue el archivo [APK](https://github.com/mcgomeztuniandes/MISW-4203-AplicacionesMoviles/tree/main/app/Sprint_3) y [LoginActivity_robo_script.json](https://github.com/mcgomeztuniandes/MISW-4203-AplicacionesMoviles/tree/main/app/Sprint_3) o arrastrelos directamente al espacio **App APK or AAB** y **Robo script**, respectivamente.

![image](https://user-images.githubusercontent.com/99267339/204155632-dc6652af-f784-4283-87d6-c153449f4a0b.png)

4. Seleccione el dipositivo y de click en *Run a test* y espere a que aparezcan los resultados de la ejecución de las pruebas.

 ![image](https://user-images.githubusercontent.com/99267339/204155762-846ef3b0-86c0-49b5-827e-3cd3296b3654.png)

![image](https://user-images.githubusercontent.com/99267339/204155784-79020d2f-fcf2-4ed8-b613-6de621bfe2b0.png)



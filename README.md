# Java-React: Servidor KATA Full Stack - Lista de deberes (To do list)

<p align="center">
<img src="https://www.sofka.com.co/wp-content/uploads/2021/02/sofkau-logo-horizontal.png">
</p>
<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white">
  <img src="https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB">
  <img src="https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white">
  <img src="https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white">

</p>


<p align="center">
  <img src="https://img.shields.io/github/v/release/JoseNSoler/PracticaMVC?style=flat-square"
</p>   

## Descripcion General

Para el desarrollo (y posible recomendacion para implementacion rapida), se configuro un servidor MySql-Apache-PHPMyAdmin usando [USBWebServer](https://www.usbwebserver.net/downloads.html). Quedando una mapeado de puertos de la siguiente manera:

`http://localhost/phpmyadmin/` : PHPMyAdmin

`http://localhost:3306/api_java` : MySql enlace y puertos *La base de datos por defecto se llama api_java*

`http://localhost:8080/api_java/{*operaciones*}` : servicio Java Springboot API CRUD, mas abajo se detallan los metodos permitidos

`http://localhost:3000` : Servicio Node/React.js ejecutado en el puerto 3000 *Si el puerto se encuentra ocupado, el programa pedira usar otro puerto 3000+(n+1)*

<hr>

Servidor CRUD implementado en Java-Springboot y Node-React.Js, para el manejo interactivo de una lista de tareas-objetos To Do.
Para la inicializacion de ambos servidores de manera optima se recomienda lo siguiente:
1. Iniciar el servicio MySql escuchando en el puerto 3306 por peticiones HTTP

<hr>

2. Iniciar el servidor Java-SpringBoot, dirigirse a la carpeta 'backend', y adentro ejecutar los siguientes comandos:
- Para servidores Linux, el codigo se ejecuta desde el archivo `mvnw`, primero usando el comando `mvnw compile`, seguidamente de `mvnw spring-boot:run`
- Para servidores con distrubuciones Windows, el codigo se ejecuta desde el archivo `./mvnw.cmd` desde una consola de comandos (cmd) o ventana PowerShell. Primero se ejecuta el comando `./mvnw.cmd compile`, seguidamente de `./mvnw.cmd spring-boot:run`

<hr>

3. Iniciar el servidor NodeJs ubicado en la carpeta front, adentro de la misma ejecutar los siguientes comandos:
- `npm install` Para instalar todos los modulos necesarios para el funcioanmiento del programa
- `npm start` para ejecutar el servidor React desde el puerto 3000


`http://localhost:8080/{*operaciones*}` : servicio Java Springboot API CRUD, mas abajo se detallan los metodos permitidos


## Manejo de Errores

Si el usuario realiza una peticion no permitida, ya sea por un error en el tipo de datos enviados, o requiriendo informacion no existente en la DB, el servidor respondera con un JSON:

```JSON
{
    "message":  "__ERROR ToDo list con ID:20 no identificado en DB",
    "httpStatus":  "NOT_FOUND",
    "timeStamp":  "2022-02-21T04:27:37.423514Z"
}
```
Describiendo:
- El error en concreto que el usuario esta cometiendo
- HTTP status personalizado de acuerdo al tipo de problema
- Hora de respuesta del servidor

<hr>

## Operaciones permitidas

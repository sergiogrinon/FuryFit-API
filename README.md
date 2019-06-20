# FuryFit-API
_La API del proyecto Fury Fit permite una conexión independiente con la base de datos así como la reutilización del código._
_Se ha desarrollado en Java, haciendo uso de un servidor GlassFish 5, de Oracle._

> Se deben tener algunas consideraciones para poder hacer uso de este proyecto, ya sea probarlo o modificarlo y agregarle/cambiarle funcionalidades.

## Consideraciones a tener en cuenta
> Para poder utilizar la API, ya que no tengo un servidor donde alojarla y mantenerla desplegada 24/7, se debe utilizar de manera local, para lo que necesitamos GlassFish 5 así como MySQL (con la base de datos entregada), funcionando en los puertos **8080** y **3306** respectivamente.

### Consejos para la instalación y uso de la API
* Descargar e instalar **Eclipse** (versión para desarrollo web).
* Descargar e instalar **GlassFish 5** y conectarlo con Eclipse. GlassFish siempre debe desplegarse en el puerto **8080**, pues la estructura está realizada contando con ello.
* Descargar e instalar **MySQL Server** (y dejar todo por defecto para que pueda escuchar por el puerto **3306**) y **MySQL WorkBench** (esto es por si se quiere realizar algún cambio).

_Con esto estaría todo, habría que lanzar el proyecto sobre GlassFish y poner el servidor preparado para recibir peticiones._

### Posibles problemas que pueden surgir
_Principalmente puede ocurrir que las peticiones no se hagan correctamente debido al usuario. Está hecho utilizando el usuario root, por lo que si en MySQL utilizas un usuario particular, será preciso cambiarlo en el código (en las clases DAO del proyecto se cambia el nombre de usuario utilizado para establecer la conexión, se publican los cambios al servidor y no hay mayor problema)._

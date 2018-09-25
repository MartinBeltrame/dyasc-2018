# Uso de la bitacora

Al ejecutar bitacora.jar, previamente generado, se deben pasar los argumentos, que pueden ser:
  * bitacora.destino
  * bitacora.destino=[nombreArchivo.txt]
  * bitacora.destino=CONSOLA
  * bitacora.destino=[nombreArchivo.txt],CONSOLA

Una vez ejecutado el comando se podrá escribir un mensaje por pantalla representando un evento.   
La estructura debería ser del siguiente estilo:
```
java -jar bitacora.jar bitacora.destino=CONSOLA
Un evento
Otro evento
FIN
```
El comando **FIN** marca la finalización de la entrada por pantalla y genera la salida correspondiente, dependiendo el argumento que se haya pasado al inicio de la ejecución del programa.

-----

### Salida
El resultado obtenido tiene el siguiente aspecto:
```
Un evento - 20/09/2018 - 10:55:13
Otro evento - 20/09/2018 - 10:56:22
```

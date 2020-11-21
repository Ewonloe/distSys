# README

############## Análisis de sistema #######################

Carlos Henríquez Rojas
                              
                              
Características de un sistema distribuido:


1) Poner recursos a disposición: Presente. La aplicación otorga a los usuarios la facultad de generar permisos salvoconductos.

2) Apertura: Presente. La aplicación funciona según el estándar REST.

3) Escalabilidad: Escasa. La escalabilidad no está ausente en el sistema, pues es posible mejorar los la máquina (escalamiento vertical) o particionar la base de datos en más dispositivos para permitir acceso paralelo a los datos (escalamiento horizontal). Dicho esto, no es posible realizar esto actualmente en tiempo de ejecución, por lo que no es un punto fuerte en este sistema.

4) Transparencias: 

- Transparencia de acceso: Presente. El usuario no varía el procedimiento requerido para acceder a la aplicación independientemente de la máquina que use para acceder a ella.

- Transparencia de ubicación: Ausente. La única dirección IP que usa el sistema delata donde se encuentra toda la información y software accedidos.

- Transparencia de migración: Ausente/No aplica. Con una única base de datos, la información no "migra" realmente.

- Transparencia de re-localización: Ausente. Mover los componentes del sistema requiere desconectarlos. El usuario se dará cuenta en ese entonces que algo está ocurriendo con los servidores.

- Transparencia a los errores: Ausente. Si la única máquina que provee el servicio falla, no hay manera de seguir proporcionándole a los usuarios el servicio hasta que la máquina pueda volver a levantarse.

- Transparencia a replicación: Ausente/No aplica. Con una única base de datos, no hay mucho sentido en replicar la información.

- Transparencia a concurrencia: Ausente. Para probar si esta condición se cumple o no, se realizaron 100 peticiones seguidas sobre el sistema. Aunque este no falló en las operaciones, sí le llevó un tiempo considerable (4m 56s) contestar a todas. Ya que una solicitud tarda aproximadamente tres segundos en procesarse, la solicitud del (hipotético) usuario número 100 pasó por una espera de más de 290 segundos antes de comenzar a procesarse. Por ende, no hay ninguna transparencia a la concurrencia actualmente en este sistema.


-----------------------------------------------------------------------------------------------------------------------------------
Manual de uso

Base de datos

Desde PGadmin, cargar el respaldo de base de datos que se encuentra en distSys\Database backups. Utilice el nombre distSystem para la base de datos, de ser posible.

Backend

Desde consola, en el directorio distSysBack ejecutar el comando "gradlew bootRun".
Si la base de datos, puerto, nombre de usuario o contraseña de postgres no coincide con los de su configuración local, puede cambiarlos en el archivo distSys\distSysBack\src\main\resources\application.properties.

Frontend

Desde consola, en el directorio distSysFront ejecutar el comando "npm install" y luego "npm run serve". Es importante realizar estos pasos luego de haber realizado los de backend.

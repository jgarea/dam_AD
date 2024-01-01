# Ejercicio 1
Tenemos un fichero ``personas.txt``, con el nombre y apellidos de diferentes personas.
Debes implementar un programa que permita:
- Leer el fichero y almacenar cada nombre y apellido en un objeto Persona.
- Creará el siguiente menú:
  1. Introducir nuevos valores
  2. Guardar lista
  3. Mostrar contenido del fichero
- La opción 1, permite aumentar el número de elementos en la lista introduciendo nuevos nombres y apellidos por consola.
- La opción 2, creará, si no existe, un fichero llamado ``personaObjeto.txt`` en donde se almacenará la lista de Personas ordenadas por nombre de forma alfabética.
- La opción 3, comprobará si existe el fichero ``personaObjeto.txt``, lo leerá y mostrará la información por pantalla.
- No se podrán perder los datos de las personas que ya estaban añadidas en el  fichero original.

# Ejercicio 2
Tenemos un fichero usuarios.xml, que almacena los usuarios y contraseñas de una
aplicación. Debes crear una aplicación Java que solicite un usuario y contraseña para
iniciar sesión:
* Si el usuario existe en el fichero XML y la contraseña es correcta, se mostrará el
mensaje “SE HA INICIADO SESIÓN CON ÉXITO”.
* Si no, se mostrará el mensaje “ERROR: NO SE HA PODIDO INICIAR SESIÓN”.
  
Para realizar el ejercicio, puedes utilizar las siguientes clases:DocumentBuilder,
DocumentBuilderFactory, Document

# Ejercicio 3
Utilizando la base de datos de una tienda (bd-tienda.sql), desarrolla una aplicación que permita realizar los siguientes apartados. Los **datos** introducidos podrán ser **puestos a mano** sin la necesidad de solicitar por pantalla la información. Será necesario **indicar con un print qué es lo que se está haciendo** para facilitar la corrección:
- a. Cree una conexión a la base de datos de la forma más óptima que conozcas (0.25
puntos)
- b. Crear y borrar un cliente. (1 puntos)
- c. Muestra la información de un determinado cliente a partir de su id (0.75 punto)
- d. Muestra el nombre y el precio de los productos disponibles (1 punto)
- e. Realizar un nuevo pedido. Ten en cuenta que un pedido puede incluir varios
productos. (1 puntos)
- f. Mostrar los datos del último pedido realizado por un cliente, incluyendo el precio total del pedido. (1 puntos)

**Nota**: Para la realización de **las consultas e y f del ejercicio anterior** se deberán **utilizar transacciones** aunque solo sea para la realización de una subconsulta. La **no realización de la transacción** será penalizado con **-0.25 por apartado, solo en el caso
de que la consulta sea correcta.**


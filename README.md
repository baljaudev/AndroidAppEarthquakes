# Earthquakes Android App
Little Android app on Java with DialogFragment

## Enunciado

SQLite 
-	BBDD: Se debe crear una base de datos TERREMOTOS_DB con dos tablas, TERREMOTOS y PAISES_AFECTADOS.

La tabla TERREMOTOS contendrá: 
-	la fecha y hora (clave primaria), 
-	el nombre del dispositivo (único), 
-	la magnitud (decimal de 0 a 10), 
-	las coordenadas del epicentro, 
-	el lugar,
-	el cantidad de muertos.

La tabla PAISES_AFECTADOS contendrá: 
-	la fecha y hora (clave foránea de la tabla TERREMOTOS), 
-	el país
-	(ambos campos forman la clave primaria)

•	Se deben crear las clases Terremoto y PaisAfectado para generar las tablas.
•	Se deberá crear una clase TerremotosDB que representará la base de datos. 
•	Las clases TerremotosDao y PaisesDao donde se declararán los métodos para las operaciones CRUD necesarias.

-	La primera vez que se arranque la aplicación se deberá realizar una comprobación: Se consultará la tabla TERREMOTOS y si la tabla se encuentra vacía se deberá hacer una carga inicial (inserción de datos). 
•	Para realizar la carga inicial definir un ArrayList de objetos de tipo Terremoto cargado con la información indicada al final del documento.
•	Para realizar la carga inicial definir un ArrayList de objetos de tipo PaisAfectado cargado con la información indicada al final del documento.

-	Activity de Consulta: Contendrá:
	en una línea, dos botones, uno para seleccionar el filtro y otro para realizar una consultar, 
	un TextView en el que se mostrará el filtro seleccionado:

Mes:, Año:, País:.

	y un RecyclerView para mostrar los resultados. En el RecyclerView se mostrarán todos los datos de cada terremoto.

o	Si se pulsa el botón Seleccionar filtro se abrirá un cuadro de dialogo para seleccionar el filtro.

o	Si se pulsa el botón Consultar sin haber seleccionado un filtro se mostrarán todos los terremotos ordenados por magnitud.

o	Si se pulsa el botón Consultar habiendo seleccionado un filtro se mostrarán los terremotos ordenados por magnitud que cumplan: 

	Si se ha seleccionado un mes, se mostrarán los terremotos cuya fecha contenga el mes seleccionado.

	Si se ha seleccionado un año, se mostrarán los terremotos cuya fecha contenga el año seleccionado.

	Si se ha seleccionado un país, se mostrarán todos los terremotos que hayan afectado a dicho país.

	Si se ha seleccionado un mes y un año, se mostrarán los terremotos cuya fecha contenga el mes seleccionado y contenga el año seleccionado.

	Si se ha seleccionado un mes y un país, se mostrarán los terremotos cuya fecha contenga el mes seleccionado y que hayan afectado a dicho país.

	Si se ha seleccionado un año y un país, se mostrarán los terremotos cuya fecha contenga el año seleccionado y que hayan afectado a dicho país.

	Si se ha seleccionado un mes, un año y un país, se mostrarán los terremotos cuya fecha contenga el mes seleccionado, contenga el año seleccionado y que hayan afectado a dicho país.


o	Si no se encontrarán terremotos que coincidan con el filtro introducido se mostrará un mensaje indicando que no se han encontrado resultados.

                   
-	Cuadro de dialogo de selección de filtro: 
•	Contendrá: 
	En la misma línea, un TextView con el texto Mes, y un desplegable para elegir el mes (que contenga los meses en minúsculas, 
	En otra línea un TextView con el texto Año y un EditText para introducir un año.
	Y en otra línea, un TextView con el texto País y un desplegable con los distintos países que se encuentran en la tabla PAISES_AFECTADOS. Este desplegable debe rellenarse con una consulta.

	Si se pulsa el botón Aceptar, se comunicarán los datos introducidos al Activity de consulta mostrándose en el TextView. Ejemplo: Mes: marzo, Año: , País: Chile.
Ninguno de los datos es obligatorio pero si se introduce el año se deberá validar que no supere al año actual.

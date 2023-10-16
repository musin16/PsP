package Ejercicio6;

import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio6 {
	static long numIteraciones;
	static String nombreAplicacion;
	static String rutaFichero;

	static void EscribirArchivoMensaje(String mensaje) {
		try {
// Creo un objeto de la clase FileWriter para escribir en el fichero en modo append
			FileWriter fileWriter = new FileWriter(rutaFichero, true);
// Realizo la escritura del mensaje en el fichero
			fileWriter.write(mensaje);
// Cerramos el FileWriter al terminar
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Esta aplicacion lo que hace es que pasandole dos argumentos ,comprueba si el
	 * primer argumento que le han pasado si es el nombre del proceso y
	 * poesteriormente comprueba si el segundo parametro que se le ha pasado es el
	 * numero de iteraciones ,si no se le ha pasado ninguna iteracion se le asigna
	 * por defecto 100 iteraciones si el valor no es numerico se captura la
	 * excepcion NumberFormatException. A continuacion compone la ruta del archivo
	 * que la crea en la ruta del usuario que tiene la sesion iniciada. Despues se
	 * obtiene el tiempo de milisegundos al inicio de la iteración y pasamos al
	 * metodo EscribirArchivoMensaje el primer parametro del main junto con un con
	 * la variable que contiene los milisegundos iniciales. Seguidamente ,muestra
	 * por consola un mensaje con las misma veces que el numero te iteraciones que
	 * tiene asignado Por ultimo,obtenemos eltiempo en milisegundos al final de la
	 * iteracion y pasamos la metodo EscribirArchivoMensaje el primer parametro del
	 * main junto con una frase con la variable que contiene los milisegundos
	 * finales.
	 */
	public static void main(String[] args) {
// Chequeo si el usuario me ha pasado en el primer parámetro el nombre asignado al proceso
		if (args.length > 0) {
			nombreAplicacion = args[0];
		} else
			nombreAplicacion = "";
// Chequeo si el usuario me ha pasado en el segundo parámetro el número de iteraciones
		if (args.length > 1) {
			try {
				numIteraciones = Long.parseLong(args[1]);
			} catch (NumberFormatException e) {
				System.err.println(
						"El argumento pasado en el segundo parámetro debe ser un número. Se asignará un valor por defecto de 100");
				numIteraciones = 100;
			}
		} else
			numIteraciones = 100;
// Compongo en una cadena la ruta al archivo en el escritorio del usuario que tiene iniciada la sesión
		rutaFichero = System.getenv("USERPROFILE") + "\\Desktop" + "\\archivoDatos.txt";
// Obtengo el tiempo inicial en milisegundos
		long tInicial = System.currentTimeMillis();
		EscribirArchivoMensaje(nombreAplicacion + "El tiempo al que comienza en milisegundos es " + tInicial + "\n");
// Muestro por pantalla un mensaje tantas veces como indique la propiedad numIteraciones
		for (int i = 0; i < numIteraciones; i++)
			System.out.println("Mensaje número " + i);
// Obtengo el tiempo inicial en milisegundos
		long tFinal = System.currentTimeMillis();
		EscribirArchivoMensaje(nombreAplicacion + "El tiempo al que finaliza en milisegundos es " + tFinal + "\n");
	}
}
package Ejercicio6;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		String[] comadno = { "java", "C:\\Users\\MOUHCINE\\PSP\\Tarea1\\src\\Ejercicio6\\Ejercicio4.java" };

		try {
			// Crear un proceso para ejecutar el comando
			ProcessBuilder processBuilder = new ProcessBuilder(comadno);

			// Redirigir la entrada estándar del proceso hijo
			processBuilder.redirectInput(ProcessBuilder.Redirect.PIPE);
			processBuilder.redirectOutput(ProcessBuilder.Redirect.PIPE);
			// Iniciar el proceso y esperar a que termine
			Process process = processBuilder.start();
			int exitCode = process.waitFor();
			// Imprimir el código de salida del proceso hijo
			System.out.println("Código de salida: " + exitCode);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}

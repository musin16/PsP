package Ejercicio4;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Scanner;

public class Mainn {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Introduce el fichero: ");
		String fichero = sc.nextLine();
		String[] comando = { "java", "C:\\Users\\MOUHCINE\\PSP\\Tarea1\\src\\Ejercicio4Parte2\\Ejercicio4.java",
				fichero };

		try {
			// Crear un proceso para ejecutar el comando
			ProcessBuilder pb = new ProcessBuilder(comando);
			pb.redirectOutput(Redirect.INHERIT);
			pb.redirectInput(Redirect.INHERIT);

			Process process = pb.start();
			process.waitFor();
		} catch (IOException | InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}

package Ejercicio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Introduce el fichero del que quieres comprobar sus letras: ");
		String fichero = sc.nextLine();

		System.out.println("Introduce el fichero que quieres comprobar sus letras: ");
		String letra = sc.nextLine();
		String[] comando = { "java", "C:\\Users\\MOUHCINE\\PSP\\Tarea1\\src\\Ejercicio3\\Ejercicio3.java", fichero,
				letra };
		try {
			ProcessBuilder pb = new ProcessBuilder(comando);
			pb.redirectOutput(Redirect.INHERIT);
			Process proceso = pb.start();
			proceso.waitFor();

//				Process proceso = Runtime.getRuntime().exec(cmd);
//				proceso.waitFor();
		} catch (IOException | InterruptedException e) {
			System.exit(-1);
			System.out.println("-1");
		}
		contarVocales(comando, fichero);

	}

	public static void contarVocales(String[] cmd, String fich) {
		int letr = 0, cont = 1;
		String[] vocales = { "a", "e", "i", "o", "u" };
		int[] numVoc = new int[5];
		try {
			for (int i = 0; i < 5; i++) {
				FileReader leer;
				leer = new FileReader(new File(fich));
				while ((letr = leer.read()) != -1) {
					if ((char) vocales[i].charAt(0) == Character.toString((char) letr).toLowerCase().charAt(0)) {
						numVoc[i] = cont++;
					}
				}
				cont = 1;

			}
			for (int i = 0; i < numVoc.length; i++) {
				System.out.println(
						"En total hay de la letra: " + vocales[i].charAt(0) + " la cantidad de : " + numVoc[i]);
			}
			System.exit(0);
		} catch (FileNotFoundException e) {
			System.exit(-1);
		} catch (IOException e) {
			System.exit(-1);
		}
	}
}

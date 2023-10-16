package Ejercicio4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4Parte2 {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		if (args[0].isEmpty()) {
			System.out.println("La cadena esta vacía");
		} else {
			leerFichero(args);
		}
	}

	private static void leerFichero(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(args[0]));
			String linea = "";
			while ((linea = br.readLine()) != null) {
				boolean validar = considerarPálindromo(linea.toLowerCase());
				if (validar) {
					escribirFichero(linea);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void escribirFichero(String linea) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("Palindromo.txt", true));
			bw.write(linea);
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					if (bw != null) {
						bw.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static boolean considerarPálindromo(String linea) {

		String palabraReves = "";
		String sinEspacio = linea.replaceAll(" ", "");
		for (int i = linea.length() - 1; i >= 0; i--) {
			palabraReves += linea.charAt(i);
		}
		if (sinEspacio.equalsIgnoreCase(palabraReves.replaceAll(" ", ""))) {
			return true;
		} else {
			return false;
		}
	}
}

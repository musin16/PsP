package Ejercicio2Version1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		// HiloFichero p = new HiloFichero(args);
		BufferedReader br = null;
		try {
			for (int i = 0; i < args.length; i++) {
				HiloFichero pL = new HiloFichero();
				br = new BufferedReader(new FileReader(args[i]));
				String linea = "";
				while ((linea = br.readLine()) != null) {
					String[] palabras = linea.split(" ");
					pL.setCantidadCaracteres(pL.getCantidadCaracteres() + linea.length());
					pL.setCantidadPalabras(pL.getCantidadPalabras() + palabras.length);
					HiloFichero.totalPalabras += palabras.length;
					HiloFichero.totalLetras += linea.length();
				}
				System.out.println("El fichero " + args[i] + " tiene " + pL.getCantidadCaracteres() + " caracteres ");
				System.out.println("El fichero " + args[i] + " tiene " + pL.getCantidadPalabras() + " palabras ");
			}
			System.out.println("Los fichero en total tienen " + HiloFichero.totalLetras + " caracteres y "
					+ HiloFichero.totalPalabras + " palabras");
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no existe");
		} catch (IOException e) {
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Tardo " + (System.currentTimeMillis() - inicio));
	}

}

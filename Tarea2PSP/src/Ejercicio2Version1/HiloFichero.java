package Ejercicio2Version1;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HiloFichero {
	private int cantidadCaracteres;
	private int cantidadPalabras;
	private String[] ficheros;
	public static int totalLetras = 0;
	public static int totalPalabras = 0;

	public HiloFichero() {

	}

	public HiloFichero(String[] ficheros) {
		this.ficheros = ficheros;
	}

	public int getCantidadCaracteres() {
		return cantidadCaracteres;
	}

	public void setCantidadCaracteres(int cantidadCaracteres) {
		this.cantidadCaracteres = cantidadCaracteres;
	}

	public int getCantidadPalabras() {
		return cantidadPalabras;
	}

	public void setCantidadPalabras(int cantidadPalabras) {
		this.cantidadPalabras = cantidadPalabras;
	}

	public String[] getFicheros() {
		return ficheros;
	}

	public void setFicheros(String[] ficheros) {
		this.ficheros = ficheros;
	}

}

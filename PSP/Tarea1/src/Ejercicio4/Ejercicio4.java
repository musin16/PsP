package Ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Introduce una palabra: ");
		String palabra = sc.nextLine().toLowerCase();
		if (palabra.isEmpty()) {
			System.out.println("La cadena está vacía");
		} else {
			String palabraReves = "";
			for (int i = palabra.length() - 1; i >= 0; i--) {
				palabraReves += palabra.charAt(i);
			}
			if (palabra.trim().equalsIgnoreCase(palabraReves)) {
				System.out.println("Es un palíndromo");
			} else {
				System.out.println("No es un palíndromo");
			}
		}
	}
}

package Ejercicio1;

public class Main {
	public static void main(String[] args) {
		for (int i = 1; i < 4; i++) {
			Thread th = new Thread(new Hilos("Hilo " + i, i - 1));
			th.start();
		}
	}
}

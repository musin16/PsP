package Ejercicio3Sem;

import java.util.concurrent.Semaphore;

public class Cinta {
	public static final int CONTADOR = 10;
	public Semaphore smProductor = new Semaphore(CONTADOR);
	public Semaphore smConsumidor = new Semaphore(0);
	public static int[] producto = new int[CONTADOR];
	public static int[] productoMostrar = new int[CONTADOR];

	public int producir(int cont) {
		try {
			smProductor.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		producto[cont] = (int) (Math.random() * 100);
		productoMostrar[cont] = producto[cont];
		return producto[cont];
	}

	public int consumir(int cont) {
		try {
			smConsumidor.acquire();
			smProductor.release();
			smConsumidor.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return producto[cont];
	}
}

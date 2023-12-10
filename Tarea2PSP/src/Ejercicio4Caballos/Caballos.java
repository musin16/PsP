package Ejercicio4Caballos;

public class Caballos implements Runnable {
	private int distancia;
	private int contador;
	private static int cont = 0;
	private static int contOpcion = 0;
	private static int contEspera = 0;
	public static int contBool = 0;
	public static boolean winner = false;
	public static Object bloquearlock = new Object();
	private String caballo;

	public Caballos(int distancia, int cont, String caballo) {
		this.distancia = distancia;
		this.contador = cont;
		this.caballo = caballo;
	}

	@Override
	public void run() {

		try {
			while (winner == false) {

				synchronized (bloquearlock) {
					if (contador == 1000 * (cont + 1)) {
						contEspera = 1;
					}
					if (contEspera == 1) {
						contOpcion++;
						System.out.println(this.caballo + " lleva " + contador + "metros");
						if (contOpcion == contBool) {
							System.out.println("");
							contEspera = 0;
							contOpcion = 0;
							cont++;
							Thread.sleep(2000);
							bloquearlock.notifyAll();
						} else {
							bloquearlock.wait();
						}
					}
					if (contador == distancia) {
						winner = true;
						System.out.println(this.caballo + " ganador ");
						cont = 6;
						contador++;
					}
				}
				if (contEspera == 0) {
					contador++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

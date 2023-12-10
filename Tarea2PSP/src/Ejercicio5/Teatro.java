package Ejercicio5;

public class Teatro implements Runnable {

	public static int[][] asiento = new int[25][20];
	public String nombreVentana;

	public Teatro(String ventana) {
		this.nombreVentana = ventana;
	}

	@Override
	public void run() {
		try {
			while (true) {
				int i = (int) (Math.random() * asiento.length);
				int j = (int) (Math.random() * asiento[0].length);
				if (asiento[i][j] == 0) {
					asiento[i][j] = 1;
					System.out.println("Reservado." + nombreVentana + " Fila " + i + " Butaca " + j);
					Thread.sleep((long) (Math.random() * 2000));
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

package Ejercicio5;

public class Teatro implements Runnable {

	public static int[][] asiento = new int[25][20];
	public String nombreVentana;

	public Teatro(String ventana) {
		this.nombreVentana = ventana;
	}

	@Override
	public void run() {
		for (int i = 0; i < asiento.length; i++) {
			for (int j = 0; j < asiento[0].length; j++) {
				if (asiento[i][j] == 0) {
					asiento[i][j] = 1;
					System.out.println(nombreVentana + " Fila " + i + " Butaca " + j);
				}
			}
		}
	}

}

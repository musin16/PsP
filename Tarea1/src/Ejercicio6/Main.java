package Ejercicio6;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

public class Main extends Thread {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			try {
				String[] comadno = { "java", "src/Ejercicio6/Ejercicio6.java", "rutaEjercicio6",
						String.valueOf(Math.round(Math.floor(Math.random() * 100))) };

				ProcessBuilder pb = new ProcessBuilder(comadno);
				pb.redirectOutput(Redirect.INHERIT);
				Process p = pb.start();
				p.waitFor();

			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

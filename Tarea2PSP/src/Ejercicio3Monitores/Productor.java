package Ejercicio3Monitores;

public class Productor implements Runnable {

	public Productor() {

	}

	@Override
	public void run() {

		while (true) {
			synchronized (Cinta.obj) {
				while (Cinta.cont == 10) {
					try {
						Cinta.obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				int valor = (Cinta.producto[Cinta.cont] = (int) (Math.random() * 200));
				System.out.println("Se ha producido correctamente: " + valor);
				Cinta.cont++;
				Cinta.obj.notifyAll();
				try {
					Thread.sleep((long) (Math.random() * 2000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}
}

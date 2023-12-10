package Ejercicio3Monitores;

public class Consumidor implements Runnable {
	public String nom;

	public Consumidor(String nom) {
		this.nom = nom;
	}

	@Override
	public void run() {

		while (true) {
			synchronized (Cinta.obj) {
				while (Cinta.cont == 0) {
					try {
						Cinta.obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Cinta.cont--;
				System.out.println("Se ha consumido " + Cinta.producto[Cinta.cont]);

				Cinta.obj.notify();
			}
		}
	}
}

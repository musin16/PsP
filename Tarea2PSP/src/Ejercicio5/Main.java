package Ejercicio5;

import java.util.concurrent.Semaphore;

public class Main {
//	Ejercicio 5: Implementa un programa que simule un sistema de 
//	venta de entradas para un teatro. El teatro consta de
//	un aforo de 25 filas con 20 butacas cada una. El teatro 
//	abre sus dos taquillas, una hora antes de cada función y en
//	ellas se atienden las peticiones que van haciendo los 
//	clientes que llegan. Debes garantizar que dos personas no
//	reserven el mismo asiento al mismo tiempo y que se respete 
//	el límite de asientos disponibles.
//	Cada ventanilla se gestionará mediante un thread e irá 
//	recibiendo clientes a los que se les asignará una entrada
//	hasta completar el aforo. La forma de elegir la butaca 
//	libre para asignar al cliente puede ser la que tú quieras. Pon
//	una pausa aleatoria cada vez que se realice una venta 
//	para ver la evolución del programa. Cada vez que se venda una
//	entrada se mostrará un mensaje por consola del tipo:
//	Reservada. Ventanilla X – Fila i, Butaca j
	public static void main(String[] args) {
		Semaphore sem = new Semaphore(25);
		Thread ventanaX = new Thread(new Teatro("Ventana X"));
		ventanaX.start();
		Thread ventanaY = new Thread(new Teatro("Ventana Y"));
		ventanaY.start();

	}

}

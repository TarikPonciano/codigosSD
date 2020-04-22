import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Calculadora  implements ICalculadora {

	private static final long serialVersionUID = 1L;
	
	private static int chamadas = 0;

	public int calcular(int a, int b, int op) throws RemoteException {
		switch (op) {
            case 1:  
		chamadas++;
		System.out.println("Metodo soma chamado \n");
		System.out.println("Total de chamadas: "+chamadas);
		return a + b;
                     break;
            case 2:  
		chamadas++;
		System.out.println("Metodo subtracao chamado \n");
		System.out.println("Total de chamadas: "+chamadas);
		return a - b;
                     break;
            case 3:  
		chamadas++;
		System.out.println("Metodo multiplicacao chamado \n");
		System.out.println("Total de chamadas: "+chamadas);
		return a * b;
                     break;
            case 4:  
		chamadas++;
		System.out.println("Metodo divisao chamado \n");
		System.out.println("Total de chamadas: "+chamadas);
		return a / b;
                     break;
	    default: System.out.println("Operacao invalida");
		     break;
		
	}
	}
	public static void main(String[] args) throws AccessException, RemoteException, AlreadyBoundException  {
		Calculadora calculadora = new Calculadora();		
		Registry reg = null;
		ICalculadora stub = (ICalculadora) UnicastRemoteObject.
				exportObject(calculadora, 1100);
		try {
			System.out.println("Creating registry...");
			reg = LocateRegistry.createRegistry(1099);
		} catch (Exception e) {
			try {
				reg = LocateRegistry.getRegistry(1099);
			} catch (Exception e1) {
				System.exit(0);
			}
		}
		reg.rebind("calculadora", stub);
	}
}

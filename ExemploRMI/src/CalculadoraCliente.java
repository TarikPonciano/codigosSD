import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CalculadoraCliente {
	
	public static void main(String[] args) {
		
		Registry reg = null;
		ICalculadora calc;		
		try {
			reg = LocateRegistry.getRegistry(1099);
			calc = (ICalculadora) reg.lookup("calculadora");
			
			System.out.println("Insira a operação:\n");
			System.out.println("1. Soma \n 2. Subtracao \n 3. Multiplicacao \n 4. Divisao \n");
			int op = sc.nextInt();
			System.out.println("Insira o primeiro inteiro:\n");
			int op1 = sc.nextInt();
			System.out.println("Insira o segundo inteiro:\n");
			int op2 = sc.nextInt();
			
			System.out.println(calc.calcular(op1,op2,op));
			
		} catch (RemoteException | NotBoundException e) {
				System.out.println(e);
				System.exit(0);
		}
	}		

}


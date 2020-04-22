public class Calculadora {
    public String sayHello(String nome, String sobrenome) {
        return "Fala "+ nome + " " + sobrenome;
    }
   public double calcular(double a, double b, int op) throws RemoteException {
		switch (op) {

    case 1:  
		
		System.out.println("Metodo soma chamado \n");
		
		return a + b;
    
    case 2:  
		
		System.out.println("Metodo subtracao chamado \n");
		
		return a - b;
                     
    case 3:  
		
		System.out.println("Metodo multiplicacao chamado \n");
		
		return a * b;
                     
    case 4:  
		
		System.out.println("Metodo divisao chamado \n");
		
		return a / b;
                     
	  default: System.out.println("Operacao invalida");
    return "Operacao invalida";
		     
  	}
  }
}

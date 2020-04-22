public class Calculadora {
    public String sayHello(String nome, String sobrenome) {
        return "Fala "+ nome + " " + sobrenome;
    }
    	public double calcular(double a, double b, int op) throws RemoteException {
		switch (op) {
    case 1:  
		chamadas++;
		System.out.println("Metodo soma chamado \n");
		System.out.println("Total de chamadas: "+chamadas);
		return a + b;
    
            case 2:  
		chamadas++;
		System.out.println("Metodo subtracao chamado \n");
		System.out.println("Total de chamadas: "+chamadas);
		return a - b;
                     
            case 3:  
		chamadas++;
		System.out.println("Metodo multiplicacao chamado \n");
		System.out.println("Total de chamadas: "+chamadas);
		return a * b;
                     
            case 4:  
		chamadas++;
		System.out.println("Metodo divisao chamado \n");
		System.out.println("Total de chamadas: "+chamadas);
		return a / b;
                     
	    default: System.out.println("Operacao invalida");
      return null;
		     
		
	}
  }
}

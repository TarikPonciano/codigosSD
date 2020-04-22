import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculadoraServerSocket {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    ServerSocket welcomeSocket; // Criação do Servidor Socket
	    DataOutputStream socketOutput; // Canal para envio de dados    	
	    DataInputStream socketInput; // Canal para recebimento de dados 
	    BufferedReader socketEntrada; // Tradução e tratamento de dados recebidos
	    Calculadora calc = new Calculadora();
		try {
			welcomeSocket = new ServerSocket(9090); // Porta através da qual o servidor irá se comunicar
		  int i=0; //número de clientes
	  
	      System.out.println ("Servidor no ar");
	      while(true) { 
	  
	           Socket connectionSocket = welcomeSocket.accept(); // Verifica se um cliente se conectou
	           i++; // Incrementa o número de clientes
	           System.out.println ("Nova conexão");
	           
	           //Interpretando dados do servidor
	       socketEntrada = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); // Recebe e trata dados enviado pelo cliente
               String operacao= socketEntrada.readLine(); // Recebe como string bytes enviado pelo cliente
               String oper1=socketEntrada.readLine(); // Recebe como string bytes enviado pelo cliente
               String oper2=socketEntrada.readLine(); // Recebe como string bytes enviado pelo cliente
               
               //Chamando a calculadora
               String result= ""+calc.calcular(Double.parseDouble(oper1),Double.parseDouble(oper2),Integer.parseInt(operacao)); // Chama o método calcular e passa como argumento os parametros passados pelo cliente e retorna o resultado como uma mensagem.
               
               //Enviando dados para o servidor
               socketOutput= new DataOutputStream(connectionSocket.getOutputStream()); // Canal de envio de dados é aberto	
	           socketOutput.writeBytes(result+ '\n'); // Prepara a String armazenada na variável result para envio como mensagem.
	           System.out.println (result);	           
	           socketOutput.flush(); // Mensagem é enviada aos clientes
	           socketOutput.close(); // O canal de envio de dados é fechado

	                    
	      }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	}

}

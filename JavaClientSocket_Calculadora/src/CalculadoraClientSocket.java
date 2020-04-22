import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class CalculadoraClientSocket {

  public static void main(String[] args) {
		
		// TODO Auto-generated method stub
	  Scanner sc = new Scanner(System.in);	

	  System.out.println("Insira a operacao:\n");

	  System.out.println("1. Soma \n 2. Subtracao \n 3. Multiplicacao \n 4. Divisao \n");

	  int op = sc.nextInt();

	  while (op<1 || op>4) {
		System.out.println("Operacao invalida, insira novamente: \n");
		op = sc.nextInt();
	  }

	  System.out.println("Insira o primeiro inteiro:\n");
	  double a = sc.nextDouble();

	  System.out.println("Insira o segundo inteiro:\n");
	  double b = sc.nextDouble();

	  String result="";

	  try {

			//Conex�o com o Servidor
		    Socket clientSocket = new Socket("192.168.0.11", 9090); // Endereço do ip do servidor a se conectar e a porta de conexão
		    DataOutputStream socketSaidaServer = new DataOutputStream(clientSocket.getOutputStream()); // Criação de canal de conexão para envio de dados ao servidor

		    //Enviando os dados
		    socketSaidaServer.writeBytes(op+"\n"); // Adição de informação em forma de Bytes em uma mensagem para enviar ao Servidor
		    socketSaidaServer.writeBytes(a+ "\n"); // Adição de informação em forma de Bytes em uma mensagem para enviar ao Servidor
		    socketSaidaServer.writeBytes(b+ "\n");// Adição de informação em forma de Bytes em uma mensagem para enviar ao Servidor
		    socketSaidaServer.flush(); // Envio da mensagem

		    //Recebendo a resposta
		    BufferedReader messageFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // Canal para recebimento de dados enviados pelo Servidor 
		    result=messageFromServer.readLine(); // Mensagem recebida

		    System.out.println("resultado="+result); // Impressão da mensagem recebida
		    clientSocket.close(); // Encerramento da conexão com o Servidor

	   } 
	     catch (IOException e) {
		    e.printStackTrace();
	     }


}

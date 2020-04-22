import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import java.util.Scanner;

public class CalculadoraClientHTTP {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);		
	String result="";
        System.out.println("Insira a operação:\n");
	System.out.println("1. Soma \n 2. Subtracao \n 3. Multiplicacao \n 4. Divisao \n");
	int op = sc.nextInt();
			
	while (op<1 || op>4) {
		System.out.println("Metodo invalido, insira novamente: \n");
		op = sc.nextInt();
	}
			
	System.out.println("Insira o primeiro inteiro:\n");
	int a = sc.nextInt();
	System.out.println("Insira o segundo inteiro:\n");
	int b = sc.nextInt();
      
    try {

       URL url = new URL("https://double-nirvana-273602.appspot.com/?hl=pt-BR"); //Endereço do servidor a se conectar
       HttpsURLConnection conn = (HttpsURLConnection) url.openConnection(); // Tentativa de estabelecer conexão com o servidor informado
        conn.setReadTimeout(10000); // Estabelece limite de espera para o recebimento de uma resposta do servidor
        conn.setConnectTimeout(15000); // Limite de espera para o estabelecimento da conexão com o servidor
        conn.setRequestMethod("POST"); // Determina o tipo de requisição que será feito ao servidor
        conn.setDoInput(true); // Determina que a conexão poderá ser utilizada para receber dados do servidor
        conn.setDoOutput(true) ; // Determina que a conexão poderá ser utilizada para enviar dados ao servidor

        //ENVIO DOS PARAMETROS
        OutputStream os = conn.getOutputStream(); // Canal para envio de dados ao servidor
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8")); // Objeto que traduz a mensagem para ser enviada ao servidor. São determiandos o canal de envio e o tipo de mensagem a ser traduzida, no caso caracteres no padrão UTF-8.
        writer.write("oper1="+a+"&oper2="+b+"&operacao="+op); //1-somar 2-subtrair 3-dividir 4-multiplicar //Mensagem a ser enviada ao servidor.
        writer.flush(); // É feito o envio da mensagem
        writer.close(); // É fechado o processo de escrita e tradução de mensagens
        os.close(); // É fechado o canal de envio para os ervidor

        int responseCode=conn.getResponseCode(); // Recebe o código de resposta do servidor para a mensagem enviada
        if (responseCode == HttpsURLConnection.HTTP_OK) { // Se houver confirmação do recebimento da mensagem e que há conexão com o servidor

            //RECBIMENTO DOS PARAMETROS


            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8")); // Objeto que traduz a mensagem recebida do servidor
            StringBuilder response = new StringBuilder(); // String a ser construída com os caractéres não nulos enviados pelo servidor
            String responseLine = null;  // Variável usada para guardar cada caractere enviado pelo servidor
            while ((responseLine = br.readLine()) != null) { //Percorre a mensagem do servidor caractere por caractere
                response.append(responseLine.trim()); //Os caracteres não nulos são aglutinados na variável response
            }
            result = response.toString(); // Cria uma string com os caracteres armazenados
            System.out.println("Resposta do Servidor PHP="+result); // É impressa a mensagem traduzida do servidor
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class CalculadoraClientHTTP {

	public static void main(String[] args) {
		
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

       URL url = new URL("https://double-nirvana-273602.appspot.com/?hl=pt-BR");
       HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true) ;

        //ENVIO DOS PARAMETROS
        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(os, "UTF-8"));
        writer.write("oper1="+a+"&oper2="+b+"&operacao="+op); //1-somar 2-subtrair 3-dividir 4-multiplicar
        writer.flush();
        writer.close();
        os.close();

        int responseCode=conn.getResponseCode();
        if (responseCode == HttpsURLConnection.HTTP_OK) {

            //RECBIMENTO DOS PARAMETROS


            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            result = response.toString();
            System.out.println("Resposta do Servidor PHP="+result);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
	}
}

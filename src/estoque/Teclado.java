package estoque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

public class Teclado implements Serializable {

	private static InputStreamReader reader = new InputStreamReader(System.in);
	private static BufferedReader buffer = new BufferedReader(reader);
	
	public static String lerString(String msg) throws IOException {
		System.out.println(msg);
		return buffer.readLine();
	}
	
	public static int lerInteiro(String msg) throws NumberFormatException, IOException {
		return Integer.parseInt(lerString(msg));
	}
	
	public static float lerFloat(String msg) throws IOException {
		String numero = lerString(msg);
		if (numero.contains(",")) {
			numero = numero.replace(",", ".");
		}
		return Float.parseFloat(numero);
	}
}

package logica;

import java.util.Arrays;
import java.util.Scanner;

public class ExerJSE4 {
	static String arrNomes[];
	static float arrValores[];

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Quantos produtos para cadastrar?");
		int quantidade = teclado.nextInt();
		
		arrNomes = new String[quantidade];
		arrValores = new float[quantidade];
		
		for (int i=0; i<quantidade; i++) {
			lerTeclado(i);
		}
		
		System.out.printf("Total dos produtos R$ %.2f", precoTotal());
	}
	
	public static void lerTeclado(int indice) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.printf("Nome do produto %d\n", indice + 1);
		arrNomes[indice] =  teclado.nextLine(); 		
		
		System.out.printf("Preço do produto %d\n",indice + 1);
		arrValores[indice] = teclado.nextFloat();
	}
	
	public static float precoTotal() {
		float total = 0;
		for(int i=0; i<arrValores.length; i++) {
			total += arrValores[i];
		}
		
		return total;
	}

}

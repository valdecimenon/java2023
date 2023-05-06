package logica;

import static java.lang.System.out;

import java.io.PrintStream;
import java.util.Scanner;

public class ExerJSE1 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		PrintStream s =  System.out;
	
		
		s.println("Valor do produto 1");
		float p1 = teclado.nextFloat();
		
		s.println("Valor do produto 2");
		float p2 = teclado.nextFloat();
		
		s.println("Valor do produto 3");
		float p3 = teclado.nextFloat();
		
		float total = p1 + p2 + p3;
		float media = total / 3;
		float aVista = total * 0.9f;
		float em3x = total / 3;
		float em10x = total * 0.115f;

		// verifica menor pre�o
		if (p1 < p2 && p1 < p3)
			out.println("Produto 1 tem o menor pre�o");
		else if (p2 < p3)
			out.println("Produto 2 tem o menor pre�o");
		else
			out.println("Produto 3 tem o menor pre�o");
		
		// verifica maior pre�o
		if (p1 > p2 && p1 > p3)
			out.println("Produto 1 tem o maior pre�o");
		else if (p2 > p3)
			out.println("Produto 2 tem o maior pre�o");
		else
			out.println("Produto 3 tem o maior pre�o");

		// mostra o total dos produtos
		s.printf("Total R$ %.2f\n", total);
		
		// mostra o pre�o m�dio
		s.printf("Pre�o m�dio dos produtos R$ %.2f\n", media);
		
		s.printf("Pre�o � vista com 10%% de desconto: R$ %.2f\n", aVista);
		
		s.printf("Valor da parcela em 3X sem juros: R$ %.2f\n", em3x);
		
		s.printf("Valor em 10X com 15%% de acr�scimo: R$ %.2f\n", em10x);
	}

}

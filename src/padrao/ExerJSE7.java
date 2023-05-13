package padrao;

import java.util.Scanner;

public class ExerJSE7 {

	public static Produto[] estoque;
	
	public static void main(String[] args) {
		 
		Scanner teclado = new Scanner(System.in);
		System.out.println("\nTamanho do estoque:");
		int quantidade = teclado.nextInt();
		
		estoque = new Produto[quantidade]; // ex: quantidade=3
		
		for (int i=0; i<estoque.length; i++) {
			estoque[i] = lerProduto();
		}

		float total = 0;
		for (Produto p : estoque) {
			total += p.getValor();
			System.out.println(p);
		}
		
		System.out.printf("Valor total: R$ %.2f", total);
	}
	
	public static Produto lerProduto() {
		Scanner teclado = new Scanner(System.in);
		Produto produto = new Produto();

		
		System.out.println("Nome do produto:");
		produto.setNome(teclado.nextLine()); 		
		
		System.out.println("Preço do produto:");
		produto.setValor(teclado.nextFloat());
		
		return produto;
	}
	

}

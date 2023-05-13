package estoque;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {

	public static Opcao show() {
		Scanner teclado = new Scanner(System.in);
		int min = Opcao.SAIR.getCodMin();
		int max = Opcao.SAIR.getCodMax();
		
		System.out.println("\n\n======== Sistema de Estoque 0.1 =========");
		Opcao.LISTAR.imprimir();
		Opcao.INCLUIR.imprimir();
		Opcao.EXCLUIR.imprimir();
		Opcao.MOSTRAR_QUANT.imprimir();
		Opcao.MOSTRAR_VALOR.imprimir();
		Opcao.SALVAR_EXCEL.imprimir();
		Opcao.LER_EXCEL.imprimir();
		Opcao.SAIR.imprimir();
		
		int escolha;
		
		do {
			System.out.println("Qual opção?");
			escolha = teclado.nextInt();
		} while (escolha < min || escolha > max);
		
	
		for (Opcao op : Opcao.values()) {
			if (escolha == op.getCodigo())
				return op;
		}
		
		return Opcao.SAIR;
	}

}

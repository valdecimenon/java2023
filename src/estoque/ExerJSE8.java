package estoque;

import static java.lang.System.out;

import java.io.IOException;

public class ExerJSE8 {

	private static Produto[] arrEstoque = null;
	private static int posicao = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {

		int tamanho = Teclado.lerInteiro("\nTamanho do estoque:");
		arrEstoque = new Produto[tamanho];
		Opcao escolhida;

		do {
			escolhida = Menu.show();

			switch (escolhida) {

			case INCLUIR:
				incluir();
				break;

			case EXCLUIR:
				excluir();
				break;

			case LISTAR:
				out.println("Listando...");
				break;

			case MOSTRAR_QUANT:
				out.println("Mostrando quantidade...");
				break;

			case MOSTRAR_VALOR:
				out.println("Mostrando valor...");
				break;

			case SALVAR_EXCEL:
				out.println("Salvando excel...");
				break;

			case LER_EXCEL:
				out.println("Lendo excel...");
				break;

			case SAIR:
				out.println("\nAdeus!");
				break;
			}

		} while (escolhida != Opcao.SAIR);
	}

	private static void incluir() throws IOException {
		if (posicao < arrEstoque.length) {
			Produto p = new Produto();
			p.setNome(Teclado.lerString("\n>>Nome do produto: "));
			p.setValor(Teclado.lerFloat("\n>>Preço do produto: "));
			arrEstoque[posicao] = p;
			System.out.printf("Produto cadastrado na posição %d do estoque\n", posicao);
			posicao++;
		} else {
			System.out.println("Não há mais espaço no array estoque!");
		}
	}
	
	private static void excluir() throws IOException {
		String nome = Teclado.lerString("Nome do produto para excluir: ");
		boolean apagou = false;
		
		// busca sequencial
		for(int i=0; i<arrEstoque.length; i++) {
			Produto p = arrEstoque[i];
			if (p.getNome().equalsIgnoreCase(nome)) {
				arrEstoque[i] = null;
				realocarArray(i);
				posicao--;
				apagou = true;
				break;
			}
		}
				
		System.out.println(apagou ? "Produto deletado!" : "Produto não encontrado!");
	}

	private static void realocarArray(int inicio) {
		for (int i=inicio; i<arrEstoque.length - 1; i++) {
			arrEstoque[i] = arrEstoque[i+1];
		}
		
		arrEstoque[arrEstoque.length - 1] = null;
	}

}

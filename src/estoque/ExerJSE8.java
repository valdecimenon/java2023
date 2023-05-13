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
				out.println("Excluindo...");
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

}

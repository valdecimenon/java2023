package com.softgraf.primavera.service;

import static java.lang.System.out;

import java.util.List;
import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.softgraf.primavera.data.entity.Produto;
import com.softgraf.primavera.data.repository.ProdutoRepository;

@Service
public class CrudService {

	private final ProdutoRepository produtoRepository;

	// construtor
	// ProdutoRepository será injetado pelo Spring
	public CrudService(ProdutoRepository produtoRepository) {
		System.out.println("CrudService instanciado pelo Spring");
		this.produtoRepository = produtoRepository;
	}

	public void cadastra3produtos() {
		Produto p1 = new Produto("TV Samsung OLED", 2999.0, 10);
		Produto p2 = new Produto("Computador Intel", 5800.0, 5);
		Produto p3 = new Produto("Teclado 101 teclas", 49.90, 20);

		produtoRepository.save(p1);
		produtoRepository.save(p2);
		produtoRepository.save(p3);
	}

	public void cadastraNovoProduto() {
		Scanner scanner = new Scanner(System.in);
		Produto p = new Produto();

		System.out.println("Descrição: ");
		p.setDescricao(scanner.nextLine());

		System.out.println("Preço: ");
		p.setPreco(scanner.nextDouble());

		System.out.println("Quantidade: ");
		p.setQuantidade(scanner.nextInt());

		produtoRepository.save(p);
		System.out.println("=== produto salvo ===");
//		scanner.close();
	}

	public void listarTodosProdutos() {
		System.out.println("\n\n=== Listando Todos os Produtos ===");
		produtoRepository.findAll().forEach(System.out::println);
	}

	public void buscarPorDescricao() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite a descrição do produto:");
		String descricao = scanner.nextLine();
		Sort sort = Sort.by("descricao").descending();

		List<Produto> lista = produtoRepository.findByDescricaoContaining(descricao, sort);
		if (lista.isEmpty())
			System.out.println("Nenhum produto encontrado com casa descrição");
		else
			lista.forEach(System.out::println);
	}

	public void cadastra100Produtos() {
		for (int i = 1; i <= 100; i++) {
			Produto p = new Produto();
			p.setDescricao(randomTexto(7));
			p.setPreco((double) Math.random() * 100); // 0 a 100
			p.setQuantidade(1 + (int) (Math.random() * 300)); // 1 a 300

			produtoRepository.save(p);
			System.out.printf("\nProduto %d/100 salvo", i);
		}
	}

	public String randomTexto(int tamanho) {
		StringBuilder builder = new StringBuilder();
		int base = 97; // 'a'
		for (int i = 0; i < tamanho; i++) {
			char letra = (char) (base + (Math.random() * 26)); // 'a' até 'z'
			builder.append(letra);
		}

		return builder.toString();
	}

	// usar campo = "id" para testar
	// campo = id, descricao, preco, quantidade
	public void listarProdutosComPaginacao(String campo) {
		int pageNumber = 0; // primeira página
		int pageSize = 20; // tamanho da página = quantidade de itens por página
		// Um Pageable é como um índice de um livro
		// org.springframework.data.domain
		Pageable paginacao = PageRequest.of(pageNumber, pageSize, Sort.by(campo).ascending());

		// um Page é como uma página de um livro
		Page<Produto> pagina = produtoRepository.findAll(paginacao);
		out.println("\n\n>>Total de páginas: " + pagina.getTotalPages()); // 0..n
		out.println(">>Página atual: " + pagina.getNumber());
		out.println(">>Itens por página: " + pagina.getSize()); // 0..n
		out.println(">>Total de itens da consulta: " + pagina.getTotalElements());

		Scanner scanner = new Scanner(System.in);
		String escolha = "";

		do {
			out.println("\n\n==== Menu de Paginação ====");
			out.println("MOSTRAR - conteúdo da página atual");
			out.println("PROX - vai para próxima página");
			out.println("ANT - vai para a página anterior");
			out.println("PRI - vai para primeira página");
			out.println("ULT - vai para a última página");
			out.println("CONV - converte página atual em lista");
			out.println("FIM - sai do menu");

			out.println("Qual opção?");
			escolha = scanner.next().toUpperCase();

			switch (escolha) {
			
				case "MOSTRAR" -> {
					out.println("\n\n----- Exibindo página: " + pagina.getNumber());
					pagina.forEach(out::println);
				}
	
				case "PROX" -> {
					if (pagina.hasNext()) {
						pagina = produtoRepository.findAll(pagina.nextPageable());
						out.println("\n\n*** Foi para página: " + pagina.getNumber());
					} else
						out.println("\n\n*** Não há próxima página");
				}
	
				case "ANT" -> {
					if (pagina.hasPrevious()) {
						pagina = produtoRepository.findAll(pagina.previousPageable());
						out.println("\n\n*** Foi para página: " + pagina.getNumber());
					} else
						out.println("\n\n*** Não há página anterior");
				}
	
				case "PRI" -> {
					pagina = produtoRepository.findAll(paginacao.first());
					out.println("\n\n*** Foi para página: " + pagina.getNumber());
				}
	
				case "ULT" -> {
					paginacao = PageRequest.of(pagina.getTotalPages() - 1, pageSize, Sort.by(campo).ascending());
					pagina = produtoRepository.findAll(paginacao);
					out.println("\n\n*** Foi para página: " + pagina.getNumber());
				}
				
				case "CONV" -> {
					// converte mas não faz nada com a lista
					List<Produto> lista = pagina.getContent();
					out.println("\n\n*** Converteu página em lista");
				}
				
				case "FIM" -> out.println("\n\n*** Saiu do menu de paginação");
				
				default -> out.println("\n*** Opção inválida");
			}
			
		} while (!escolha.equals("FIM"));
	}
}

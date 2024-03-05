package com.softgraf.primavera.rest;

/*
 * usado por ProdutoApiController
 * Exceção lançada quando o id do produto não é encontrado no banco
 */
public class ProdutoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1236408655157912691L;
	
	public ProdutoNotFoundException(Long id) {
		super("Não foi possível encontrar o produto com id=" + id);
	}
	
}

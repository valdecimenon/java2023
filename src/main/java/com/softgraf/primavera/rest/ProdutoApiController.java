package com.softgraf.primavera.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softgraf.primavera.data.dto.ProdutoRecordDTO;
import com.softgraf.primavera.data.entity.Produto;
import com.softgraf.primavera.data.repository.ProdutoRepository;

import jakarta.validation.Valid;

@RestController // define que esta é uma API RestFull
@RequestMapping("api") // url da API
public class ProdutoApiController {

	// instancia um objeto
	@Autowired // usar Autowired e não Inject!
	private ProdutoRepository repository;

	// Salva um único produto - use insomnia (ou postman) para testar
	// POST: localhost:8080/api/cadastrar
	/*
	 * JSON: {"descricao": "Computador Dell", "preco": 5999.0, "quantidade": 5,
	 * "urlImagem": "imagem.png" }
	 */

	// recebe um objeto javascript
	/*
	 * public void cadastrar(@RequestBody String json) { System.out.println(json); }
	 */

	@PostMapping("cadastrar")
	public Produto cadastrar(@RequestBody Produto produto) {
		System.out.println(produto);
		// salva entidade no banco
		return repository.save(produto);
	}

	// Lista todos os produtos
	// GET: http://localhost:8080/api/listar
	@GetMapping("listar")
	public List<Produto> listarTodos() {
		return repository.findAll();
	}

	// Busca um produto por id
	@GetMapping("produto/{id}")
	public Produto buscarPorId(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new ProdutoNotFoundException(id));
	}

	// atualiza ou salva um único
	// PUT: localhost:8080/api/produto/3
	/* {"id": 1, "descricao": "Computador Dell Atualizado", "preco": 5999.0,
	 *  "quantidade": 5, "urlImagem": "imagem.png" }
    */
	@PutMapping("/produto/{id}")
	public Produto atualizarPorId(@RequestBody @Valid ProdutoRecordDTO produtoDTO, @PathVariable Long id) {
		return repository.findById(id).map(produto -> {
			produto.setDescricao(produtoDTO.descricao());
			produto.setPreco(produtoDTO.preco());
			produto.setQuantidade(produtoDTO.quantidade());
			produto.setUrl(produtoDTO.url());
			return repository.save(produto);
		}).orElseGet(() -> {
			return repository.save(produtoDTO.toProduto() );
		});
	}
	
	// Apaga um produto por id
	// DELETE: localhost:8080/api/produto/3
	// sem retorno!
	@DeleteMapping("produto/{id}")
	public void deletarPorId(@PathVariable Long id) {
		repository.deleteById(id);
	}
}

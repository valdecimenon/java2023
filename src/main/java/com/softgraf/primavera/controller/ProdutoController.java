package com.softgraf.primavera.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softgraf.primavera.data.dto.ProdutoRequest;
import com.softgraf.primavera.data.entity.Produto;
import com.softgraf.primavera.data.repository.ProdutoRepository;

@Controller
// Todas as requisições endereçadas com "/produto/" chegarão neste controller
@RequestMapping("produto")
public class ProdutoController {

	private final int PAGESIZE = 20;
	
	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private ProdutoRepository repository;
	
	// localhost:8080/produto/cadastar
	@GetMapping("cadastrar")   // src/main/resources/templates/produto/cadastrar.html
	public ModelAndView cadastrar(ModelAndView mv) {
		mv.addObject("imagens", listarImagens());
		// nome do HTML para carregar
		mv.setViewName("produto/cadastrar");
		return mv;  // retorna: "templates/produto/cadastrar.html"
	}
	
	// lista de todas as imagens da pasta uploads
	private List<String> listarImagens(){
		List<String> lista = new ArrayList<>();
		try {
			// org.springframework.core.io.Resource                 // WebConfig
			Resource[] resources = applicationContext.getResources("file:uploads/**");
			for (Resource r : resources) {
				lista.add(r.getFilename());
				System.out.println(r.getFilename());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	// localhost:8080/produto/salvar
	@PostMapping("salvar")
	public String salvar(ProdutoRequest requisicao) throws IOException {
		Produto produto = requisicao.toProduto();
		repository.save(produto);
		
		// salva a imagem no folder /uploads
		String nomeImagem = requisicao.getImagem().getOriginalFilename();
		if (!nomeImagem.isBlank()) {  // java.nio
			Path nomeCompleto = Paths.get("uploads", nomeImagem);
			Files.write(nomeCompleto, requisicao.getImagem().getBytes());
		}
		
		return "redirect:/produto/gerenciar";
	}
	

	
	// localhost:8080/produto/gerenciar
	@GetMapping("gerenciar")
	public ModelAndView gerenciar(ModelAndView mv, 
								  @SortDefault(sort="id", direction = Sort.Direction.ASC)
								  @PageableDefault(page=0, size=PAGESIZE) Pageable pageable) {
		
		Page<Produto> pagina = repository.findAll(pageable);
		mv.addObject("produtos", pagina);
		mv.addObject("uploads", "/uploads/");
		

		// número da próxima página
		int next = pagina.hasNext() ? pagina.nextPageable().getPageNumber() : pagina.getNumber();
		mv.addObject("nextPage", next);
		mv.addObject("previousPage", pageable.previousOrFirst().getPageNumber());
		mv.addObject("lastPage", pagina.getTotalPages() - 1);
		mv.addObject("pageSize", PAGESIZE);
		mv.addObject("hasNext", pagina.hasNext());
		mv.addObject("hasPrevious", pagina.hasPrevious());
		
		mv.setViewName("produto/gerenciar");
		return mv;
	}

	
	// localhost:8080/produto/alterar/101
	@GetMapping("alterar/{id}")
	public ModelAndView alterar(ModelAndView mv, @PathVariable Long id) {
		Optional<Produto> optional = repository.findById(id);
		mv.addObject("produto", optional.get());
		mv.addObject("imagens", listarImagens());
		// softgraf.com/cursojava/primavera/alterar.html
		mv.setViewName("produto/alterar");
		return mv;     // retorna "templates/produto/alterar.html"
	}
	
	
	
	// localhost:8080/produto/atualizar
	@PostMapping("atualizar")
	public String atualizar(ProdutoRequest requisicao) throws IOException {
		Produto novo = requisicao.toProduto();
		Optional<Produto> optional = repository.findById(novo.getId());
		Produto existente = optional.get();
		existente.setDescricao(novo.getDescricao());
		existente.setPreco(novo.getPreco());
		existente.setQuantidade(novo.getQuantidade());
		existente.setUrl(novo.getUrl());
		repository.save(existente);
		
		// salva a imagem no folder /uploads
		String nomeImagem = requisicao.getImagem().getOriginalFilename();
		if (!nomeImagem.isBlank()) { 
			// import java.nio.file.Paths;
			Path nomeCompleto = Paths.get("uploads", nomeImagem);
			Files.write(nomeCompleto, requisicao.getImagem().getBytes());
		}
		
		return "redirect:/produto/gerenciar";
	}
	
	// localhost:8080/produto/excluir/101
	@GetMapping("excluir/{id}")
	public String excluir(@PathVariable Long id) {
		repository.deleteById(id);
		return "redirect:/produto/gerenciar";
	}
	
}

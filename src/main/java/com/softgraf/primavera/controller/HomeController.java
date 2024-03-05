package com.softgraf.primavera.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softgraf.primavera.data.entity.Produto;
import com.softgraf.primavera.data.repository.ProdutoRepository;

@Controller
public class HomeController {
	
	@Autowired
	private ProdutoRepository repository;
	private final int PAGESIZE = 12;
	
	public static List<Produto> listarProdutos(){
		Produto p1 = new Produto(1L, "Iphone 15 Pro 256GB", 10099.0, 2);
		Produto p2 = new Produto(2L, "Samsung Galaxxy S23 Ultra 1TB", 8600.0, 3);
		Produto p3 = new Produto(3L, "Motorla Edge 30 Fusion 256GB", 2999.99, 5);
		return List.of(p1, p2, p3);
	}
	
	// GET: http://localhost:8080/model
	@GetMapping("model")
	// Model é uma interface
	public String homeModel(Model model) {
		List<Produto> lista = listarProdutos();
		model.addAttribute("produtos", lista);
		// redireciona para uma view chamada "templates/home.html"
		return "home";  // view
	}
	
	// GET: http://localhost:8080/modelmap
	@GetMapping("modelmap")
	// Model é uma classe que implementa LinkedHashMap
	public String homeModelMap(ModelMap map) {
		List<Produto> lista = listarProdutos();
		map.put("produtos", lista);
		return "home";  // view
	}
	
	// GET: http://localhost:8080/modelandview
	@GetMapping("modelandview")
	// ModelAndView é uma classe contendo objetos ModelMap e View
	public ModelAndView homeModelAndView() {
		List<Produto> lista = listarProdutos();
		ModelAndView mview = new ModelAndView("home");  // nome da view para carregar
		mview.addObject("produtos", lista);
		return mview;  // retorna um Model View
	}
	
	// GET: http://localhost:8080/homepage?page=1
	@GetMapping("homepage")
	public ModelAndView homePage(ModelAndView mview, @PageableDefault(page=0, size=PAGESIZE) Pageable pageable) {
		mview.setViewName("home");
		Page<Produto> pagina = repository.findAll(pageable);
		mview.addObject("produtos", pagina);
		mview.addObject("uploads", "/uploads/");
		
		// número da próxima página
		int next = pagina.hasNext() ? pagina.nextPageable().getPageNumber() : pagina.getNumber();
		mview.addObject("nextPage", next);
		mview.addObject("previousPage", pageable.previousOrFirst().getPageNumber());
		mview.addObject("lastPage", pagina.getTotalPages() - 1);
		mview.addObject("pageSize", PAGESIZE);
		mview.addObject("hasNext", pagina.hasNext());
		mview.addObject("hasPrevious", pagina.hasPrevious());
		
		return mview;
	}
	
	@GetMapping("/")
	public String index() {
		return "redirect:/homepage";
	}
	
	@GetMapping("sobre")
	public String sobre() {
		return "sobre";
	}
	

}

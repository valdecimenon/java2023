package com.softgraf.service.ws;

import java.util.List;
import com.softgraf.entity.Editora;
import com.softgraf.entity.Livro;
import com.softgraf.service.LivrariaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

// usar google chrome
// instalar extensão: JSON Viewer
@Path("livros")
public class WSResource {

	@Inject
	private LivrariaService service;
	
	// http://localhost:8080/livraria/ws/livros/text
	@GET
	@Path("text")
	@Produces(MediaType.TEXT_PLAIN)
	public String getText() {
		return "Hello World com TEXTO";
	}

	// http://localhost:8080/livraria/ws/livros/html
	@GET
	@Path("html")
	@Produces(MediaType.TEXT_HTML)
	public String getHTML() {
		StringBuilder sb = new StringBuilder("<html><body><h3>Todos os Livros</h3><ul>");
		service.todosLivros().stream().forEach(livro -> sb.append("<li>").append(livro.toString()).append("</li>"));
		sb.append("</ul></body></html>");
		return sb.toString();
	}

	// http://localhost:8080/livraria/ws/livros/json
	// @JsonbTransient para não gerar json recursivo
	// public class Editora {
	//     private Set<Livro> livros;
	@GET
	@Path("json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Livro> getJSON() {	
		return service.todosLivros();
	}
	
	// http://localhost:8080/livraria/ws/livros/xml
	// @XmlRootElement
	// public class Livro {
	//
	// @XmlTransient para não gerar xml recursivo
	// public class Editora {
	//    	public Set<Livro> getLivros() {
	@GET
	@Path("xml")
	@Produces(MediaType.APPLICATION_XML)
	public List<Livro> getXML() {	
		return service.todosLivros();
	}

	// http://localhost:8080/livraria/ws/livros/1
	@GET
	@Path("{id}") // ws/livros/1
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscaPorParam(@PathParam("id") Long id) {
		Livro livro = service.findLivroById(id);
		if (livro != null)
			return Response.status(Response.Status.FOUND).entity(livro).build();

		return Response.status(Response.Status.BAD_REQUEST).entity("{}").build();
	}

	@GET
	@Path("query") // ws/livros/query?id=1
	// com vários par�metros: /query?id=1&nome=abc => @QueryParam("nome")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscaPorQuery(@QueryParam("id") Long id) {
		Livro livro = service.findLivroById(id);
		if (livro != null)
			return Response.status(Response.Status.FOUND).entity(livro).build();

		return Response.status(Response.Status.BAD_REQUEST).entity("{}").build();
	}
	
	@POST
	@Path("cadastrar")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response cadastrarLivro(@FormParam("titulo") String titulo, @FormParam("editoraId") Long editoraId, @Context UriInfo uriInfo) {
//		System.out.println(uriInfo.getAbsolutePathBuilder().build());

		Editora editora = service.findEditoraById(editoraId);
		if (editora == null) {
			return Response.status(Response.Status.NOT_FOUND)
					   .entity("<html><body><h2>Erro: Editora n�o encontrada!</h2></body></html>")
					   .type(MediaType.TEXT_HTML)
					   .build();			
		}
		
		Livro livro = new Livro();
		livro.setTitulo(titulo);
		livro.setEditora(editora);
		service.persist(livro);

		return Response.status(Response.Status.OK)
					   .entity("<html><body><h2>Livro cadastrado!</h2></body></html>")
					   .type(MediaType.TEXT_HTML)
					   .build();
	}
}
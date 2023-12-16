package com.softgraf.beans;

import java.io.Serializable;
import java.util.List;

import com.softgraf.entity.Editora;
import com.softgraf.entity.Livro;
import com.softgraf.service.LivrariaService;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("bean")
@RequestScoped
public class LivrariaBean implements Serializable {

	private static final long serialVersionUID = 618804837894894272L;

	private Editora editora;
	private Long editoraId;

	private Livro livro;
	private Long livroId;

	private Long paramId;

	@Inject
	private LivrariaService service;

	@Inject
	private MessagesView messages;

	public LivrariaBean() {
		this.editora = new Editora();
		this.livro = new Livro();
	}

	public String salvarEditora() {

		try {

			if (paramId == null) {

				System.out.println("\nSalvando editora: " + editora);
				service.persist(editora);
				messages.info("Editora salva");
				
			} else {
				editora.setId(paramId);
				System.out.println("\nAtualizando editora: " + editora);
				service.update(editora);
				messages.info("Editora atualizada");
			}

		} catch (Exception ex) {
			messages.error("Não foi possível salvar/atualizar editora");
			System.out.println(ex);
		}

		this.paramId = null;
		return "/index";
	}

	public String salvarLivro() {
		livro.setEditora(service.findEditoraById(editoraId));
		livro.getEditora().getLivros().add(livro);

		try {
			System.out.println("\nSalvando livro: " + livro);
			service.persist(livro);
			messages.info("Livro salvo");

		} catch (Exception ex) {
			messages.error("Não foi possível salvar/atualizar livro");
			System.out.println(ex);
		}

		return "/index";
	}

	public String excluirEditora() {
		try {
			service.removeEditoraById(editoraId);

		} catch (Exception ex) {
			messages.error("Não foi possível excluir editora selecionada.");
			System.out.println(ex);
		}

		return null;
	}

	public String excluirLivro() {
		try {
			service.removeLivroById(livroId);

		} catch (Exception ex) {
			messages.error("Não foi possível excluir livro selecionada.");
			System.out.println(ex);
		}

		return null;
	}

	public void editarEditora() {
		if (paramId != null) {
			editora = service.findEditoraById(paramId);
		}
	}

	public List<Editora> getEditoras() {
		return service.todasEditoras();
	}

	public List<Livro> getLivros() {
		return service.todosLivros();
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Long getEditoraId() {
		return editoraId;
	}

	public void setEditoraId(Long editoraId) {
		this.editoraId = editoraId;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Long getLivroId() {
		return livroId;
	}

	public void setLivroId(Long livroId) {
		this.livroId = livroId;
	}

	public Long getParamId() {
		return paramId;
	}

	public void setParamId(Long paramId) {
		this.paramId = paramId;
	}

}

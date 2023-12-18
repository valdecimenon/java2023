package com.softgraf.beans;

import java.io.IOException;
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

	private static final long serialVersionUID = 1L;

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

	public String salvarEditora() throws IOException {
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
		
		try {
			livro.setEditora(service.findEditoraById(editoraId));
			livro.getEditora().getLivros().add(livro);
			
			if (paramId == null) {
				System.out.println("\nSalvando livro: " + livro);
				service.persist(livro);
				messages.info("Livro salvo");
			} else {
				livro.setId(paramId);
				System.out.println("\nAtualizando livro: " + livro);
				service.update(livro);
				messages.info("Livro atualizado");
			}

		} catch (Exception ex) {
			messages.error("Não foi possível salvar/atualizar livro");
			System.out.println(ex);
		}

		this.paramId = null;
		return "/index";
	}

	public String excluirLivro() {
		try {
			service.removeLivroById(livroId);

		} catch (Exception ex) {
			messages.error("Não foi possível excluir livro selecionado");
			System.out.println(ex);
		}

		return null;
	}

	public String excluirEditora() {
		try {
			service.removeEditoraById(editoraId);

		} catch (Exception ex) {
			messages.error("Não foi possível excluir editora selecionado");
			System.out.println(ex);
		}

		return null;
	}

	public List<Editora> getEditoras() {
		return service.todasEditoras();
	}

	public List<Livro> getLivros() {
		return service.todosLivros();
	}

	public void editarEditora() {
		if (paramId != null) {
			editora = service.findEditoraById(paramId);
		}
	}

	public void editarLivro() {
		if (paramId != null) {
			livro = service.findLivroById(paramId);
			if (livro.getEditora() != null)
				editoraId = livro.getEditora().getId();
		}
	}

	public String getTituloEditora() {
		if (paramId == null)
			return "Cadastra Editora";
		else
			return "Edita Editora";
	}

	public String getTituloLivro() {
		if (paramId == null)
			return "Cadastra Livro";
		else
			return "Edita Livro";
	}

	// getters e setters
	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Long getEditoraId() {
		return editoraId;
	}

	public Long getLivroId() {
		return livroId;
	}

	public void setLivroId(Long livroId) {
		this.livroId = livroId;
	}

	public void setEditoraId(Long editoraId) {
		this.editoraId = editoraId;
	}

	public Long getParamId() {
		return paramId;
	}

	public void setParamId(Long paramId) {
		this.paramId = paramId;
	}
}

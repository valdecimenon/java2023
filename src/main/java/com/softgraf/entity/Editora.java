package com.softgraf.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import jakarta.xml.bind.annotation.XmlTransient;

@Entity
public class Editora implements Serializable {

	private static final long serialVersionUID = 5419294589852687473L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 60, nullable = false)
	private String nome;

	@JsonbTransient
	@OneToMany(mappedBy = "editora", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Livro> livros;

	public Editora() {
		this.livros = new HashSet<Livro>();
	}

	@Transient
	public int getTotalLivros() {
		return livros.size();
	}
	
	public void setTotalLivros(int total) {
		
	}
	
	// getters e setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@XmlTransient
	public Set<Livro> getLivros() {
		return livros;
	}

	public void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Editora other = (Editora) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Editora [id=" + id + ", nome=" + nome + "]";
	}

}

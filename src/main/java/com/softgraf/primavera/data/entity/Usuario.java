package com.softgraf.primavera.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode

@Entity
@Table(name="users")
public class Usuario {

	@Id
	@Column(name="username", length = 50, nullable = false, unique = true)
	private String nome;
	
	@Column(name="password", length = 500, nullable = false)
	private String senha;
	
	@Column(name="enabled", nullable=false)
	private Boolean ativo;
}

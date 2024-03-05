package com.softgraf.primavera.data.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@EqualsAndHashCode
@Embeddable
public class AutoridadeId implements Serializable {

	private static final long serialVersionUID = -2146300800410899625L;
	
	@Column(name="username", length = 50, nullable = false)
	private String nomeUsuario;
	
	@Column(name="authority", length=50, nullable = false)
	private String autorizacao;

}

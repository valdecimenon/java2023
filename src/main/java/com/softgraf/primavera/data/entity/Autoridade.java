package com.softgraf.primavera.data.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
// tabela que define os roles do usuário
@Table(name="Authorities")
public class Autoridade {

	@EmbeddedId
	private AutoridadeId id;
}

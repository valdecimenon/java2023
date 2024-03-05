package com.softgraf.primavera.data.dto;

import com.softgraf.primavera.data.entity.Produto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// DTO = Data Transfer Object -> POJO somente leitura
public record ProdutoRecordDTO(

		// Bean validation funciona junto com @Valid
		@NotBlank(message = "Descrição do produto é obrigatório")
		String descricao,
		
		@DecimalMin(value = "0.0", inclusive = false, message = "Preço abaixo do mínimo")
		@DecimalMax(value = "9999.0", message = "Preço acima do máximo")
		Double preco,
		
		@NotNull(message = "Quantidade é obrigatório")
		@Min(1)
		@Max(9999)
		Integer quantidade,
		
		@Column(length = 255)
		String url
) {

	// converte o Record produto na entidade produto
	public Produto toProduto() {
		return new Produto(descricao, preco, quantidade, url);
	}
}

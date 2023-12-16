package com.softgraf.conversores;

import com.softgraf.entity.Editora;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(value = "editoraConverter", forClass = Editora.class)
public class EditoraConverter implements Converter<Long>{

	
	/*
	 * quando o botão salvar é clicado esta função é chamada recebendo uma
	 * String contendo o id da Editora selecionada que será convertido em Long
	 */
	// vem do frontend e vai para o backend
	@Override
	public Long getAsObject(FacesContext context, UIComponent component, String id) {
		if (id != null) {
			System.out.println("getAsObject(String id) = " + id);
			return Long.parseLong(id);
		}
		
		return null;
	}

	/* quando a lista de editoras é carregada, o id de cada Editora será salvo no
	 * proprio componente p:selectOneMenu, para ser recuperado quando o botão salvar for 
	 * clicado 
	 */
	// vem do backend e vai para o frontend
	@Override
	public String getAsString(FacesContext context, UIComponent component, Long id) {
		if (id != null) {
			System.out.println("getAsString(Long id) = " + id);
			return id.toString();
		}	

		return null;
	}

}

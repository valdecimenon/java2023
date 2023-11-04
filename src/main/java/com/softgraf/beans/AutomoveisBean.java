package com.softgraf.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.softgraf.model.Automovel;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.model.ArrayDataModel;
import jakarta.faces.model.ListDataModel;
import jakarta.inject.Named;

@Named("automoveis")
@SessionScoped
public class AutomoveisBean implements Serializable {

	private static final long serialVersionUID = -894819441138827382L;
	private List<Automovel> lista;
	// idem List, porém tem a propriedade rowIndex e outras
	private ListDataModel<Automovel> dataModel;
	/*
	 * ListDataModel para usar com listas
	 * ArrayDataModel para usar com arrays
	 */
	
	// esse método será chamado automaticamente após o construtor finalizar
	@PostConstruct
	public void init() {
		Automovel a1 = new Automovel("VW", "Gol", 2018, 39000.0f, "Único proprietário");
		Automovel a2 = new Automovel("Ford", "Fiesta", 2015, 27000.0f, "Bom estado");
		Automovel a3 = new Automovel("Fiat", "Palio", 2020, 45000.0f, null);
		
		lista = new ArrayList<>(List.of(a1, a2, a3));
		this.dataModel = new ListDataModel<>(lista);
	}

	
	public ListDataModel<Automovel> getDataModel() {
		return dataModel;
	}
	
	public void setDataModel(ListDataModel<Automovel> dataModel) {
		this.dataModel = dataModel;
	}
	
	public String incluir() {
		Automovel auto = new Automovel();
		lista.add(auto);
		return null;
	}
	
	public String apagar(Automovel auto) {
		lista.remove(auto);
		return null;
	}
	
	public String editar(Automovel auto) {
		auto.setEditar(true);
		return null;
	}
	
	public String atualizar(Automovel auto) {
		auto.setEditar(false);
		return null;
	}
	
}

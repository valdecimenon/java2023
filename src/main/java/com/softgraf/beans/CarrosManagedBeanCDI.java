package com.softgraf.beans;


import java.io.Serializable;
import java.util.Collection;
import com.softgraf.model.Marca;
import com.softgraf.model.Modelo;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("carrosBean")
@SessionScoped
public class CarrosManagedBeanCDI implements Serializable {

	private static final long serialVersionUID = -3853634607868238356L;

	private Collection<Marca> marcas;
	private Collection<Modelo> modelos;
	private String siglaMarca;
	private String nomeModelo;
	private String placa;
	@Inject
	private FacesContext contexto;  // JSF 2.3

	@PostConstruct
	public void init() {
		this.marcas = Marca.todasMarcas.values();
	}
	
	// evento disparado antes de setSiglaMarca(), 
	// então preciso obter a marca a partir de event
	public void carregarModelos(ValueChangeEvent event) {
		Object ret = event.getNewValue();
		if (ret != null) {
			String siglaMarca = ret.toString().toLowerCase();
			Marca marca =  Marca.todasMarcas.get(siglaMarca);
			this.modelos = marca.getModelos();
			
			// pula todas as fases do JSF e vai direto para a fase de renderização
			contexto.renderResponse();
		}
	}
	
	// getters e setters
	public Collection<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(Collection<Marca> marcas) {
		this.marcas = marcas;
	}

	public Collection<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(Collection<Modelo> modelos) {
		this.modelos = modelos;
	}

	public String getSiglaMarca() {
		return siglaMarca;
	}

	public void setSiglaMarca(String siglaMarca) {
		this.siglaMarca = siglaMarca;
	}

	public String getNomeModelo() {
		return nomeModelo;
	}

	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String mostrar() {		
		System.out.println("Marca: " + siglaMarca);
		System.out.println("Modelo: " + nomeModelo);
		return null;
	}
}

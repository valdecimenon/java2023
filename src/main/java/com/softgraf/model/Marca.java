package com.softgraf.model;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;

public class Marca implements Comparable<Marca>{

	private String sigla;
	private Collection<Modelo> modelos = new TreeSet<>();

	public static Map<String, Marca> todasMarcas = new TreeMap<>();;

	static {		
		Marca vw = new Marca("VW");
		vw.getModelos().add(new Modelo("Gol", vw));
		vw.getModelos().add(new Modelo("Fox", vw));
		vw.getModelos().add(new Modelo("Golf", vw));
		
		Marca ford = new Marca("Ford");
		ford.getModelos().add(new Modelo("Fiesta", ford));
		ford.getModelos().add(new Modelo("Ka", ford));
		ford.getModelos().add(new Modelo("Eco Sport", ford));
		
		Marca bmw = new Marca("BMW");
		bmw.getModelos().add(new Modelo("BMW X1", bmw));
		bmw.getModelos().add(new Modelo("BMW X3", bmw));
		bmw.getModelos().add(new Modelo("BMW X5", bmw));
		
		todasMarcas.put("vw", vw);
		todasMarcas.put("ford", ford);
		todasMarcas.put("bmw", bmw);
	}	
	
	public Marca(String sigla) {
		this.sigla = sigla;
	}

	@Override
	public int compareTo(Marca marca) {
		return this.sigla.compareTo(marca.sigla);
	}
	
	
	// getters e setters
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Collection<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(Collection<Modelo> modelos) {
		this.modelos = modelos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sigla);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Marca other = (Marca) obj;
		return Objects.equals(sigla, other.sigla);
	}
}

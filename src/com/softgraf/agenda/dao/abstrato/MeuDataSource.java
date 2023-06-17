package com.softgraf.agenda.dao.abstrato;

public interface MeuDataSource {

	String getStringConexao();
	
	String getClasse();
	
	String getDriver();
	
	String getUrl();
	
	String getDatabase();
	
	String getUser();
	
	String getPassword();
}

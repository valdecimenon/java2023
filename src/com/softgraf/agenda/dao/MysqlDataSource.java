package com.softgraf.agenda.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.softgraf.agenda.dao.abstrato.MeuDataSource;

public class MysqlDataSource implements MeuDataSource {

	final private String arqConfig = "mysql.properties";
	// Properties é um HashTable persistente (salva no disco)
	// Properties extends HashTable implements Map
	private Properties config;
	
	// construtor
	public MysqlDataSource() throws IOException {
		this.config = new Properties();
		
		if (new File(arqConfig).exists()) {
			lerPropriedades();
		} else {
			definirConfiguracaoPadrao();
			salvarPropriedades();
		}
	}
	
	private void definirConfiguracaoPadrao() {
		config.setProperty("classe", "com.mysql.cj.jdbc.Driver");
		config.setProperty("driver", "mysql");
		config.setProperty("url", "localhost:3306");
		config.setProperty("database", "agenda");
		config.setProperty("user", "root");
		config.setProperty("password", "softgraf");
	}
	
	private void salvarPropriedades() throws IOException {
		FileOutputStream output = new FileOutputStream(arqConfig);
		config.store(output, "Propriedades de conexão do banco de dados agenda");
		output.close();
	}
	
	private void lerPropriedades() throws IOException {
		FileInputStream input = new FileInputStream(arqConfig);
		config.load(input);
		input.close();
	}
	
	@Override
	public String getStringConexao() {
		return "jdbc:" + getDriver() + "://" + getUrl() + "/" + getDatabase();
	}

	@Override
	public String getClasse() {
		return config.getProperty("classe");
	}

	@Override
	public String getDriver() {
		return config.getProperty("driver");
	}

	@Override
	public String getUrl() {
		return config.getProperty("url");
	}

	@Override
	public String getDatabase() {
		return config.getProperty("database");
	}

	@Override
	public String getUser() {
		return config.getProperty("user");
	}

	@Override
	public String getPassword() {
		return config.getProperty("password");
	}
}

package com.softgraf.agenda.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.softgraf.agenda.beans.Contato;
import com.softgraf.agenda.dao.ConnectionFactory;
import com.softgraf.agenda.dao.ContatoRepository;
import com.softgraf.agenda.dao.MysqlDataSource;

public class Teste {

	public static void main(String[] args) throws IOException, SQLException {
		
		MysqlDataSource ds = new MysqlDataSource();
		Connection conexao = ConnectionFactory.getMysqlConnection(ds);
		ContatoRepository repositorio = new ContatoRepository(conexao);
		
		/*
		Contato contato = new Contato("Luiza Camargo", "(42)3025-1234");
		repositorio.save(contato);
		System.out.println(contato.getId());
		
		Contato procurado = repositorio.findById(1L);
		System.out.println(procurado);
		
		
		List<Contato> lista = repositorio.findAll();
		lista.forEach(System.out::println);

		
		repositorio.delete(8L);
	
		System.out.println(repositorio.existsById(1L));
		System.out.println(repositorio.existsById(10L));
		
		*/
		
		repositorio.update(7L, new Contato("Helena Souza", "9999-7777"));
			
		conexao.close();
		System.out.println("OK");

	}

}

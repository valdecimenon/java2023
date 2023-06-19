package com.softgraf.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.softgraf.agenda.beans.Contato;
import com.softgraf.agenda.dao.abstrato.Repository;

public class ContatoRepository implements Repository<Contato> {

	private Connection conexao;
	private String sql;
	private PreparedStatement stmt; // executor de comandos

	// construtor
	public ContatoRepository(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public boolean save(Contato contato) {
		int retorno = 0;

		sql = "INSERT INTO Contato (nome, fone) VALUES (?, ?)";

		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getFone());
			retorno = stmt.executeUpdate();
			
			// recupera o id 
			if (retorno > 0) {
				ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID() AS id");
				rs.next();
				Long id = rs.getLong("id");
				contato.setId(id);
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			System.out.println("Erro ao salvar entidade contato");
			e.printStackTrace();
		}
		
		return retorno > 0;
	}

	@Override
	public Contato findById(Long id) {
		sql = "SELECT * FROM Contato WHERE id=?";
		Contato contato = null;
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				String nome = rs.getString("nome");
				String fone = rs.getString("fone");
				contato = new Contato(id, nome, fone);
				stmt.close();
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao buscar entidade por id");
			e.printStackTrace();
		}
		
		return contato;
	}

	@Override
	public List<Contato> findAll() {
		List<Contato> lista = new ArrayList<>();
		sql = "SELECT * FROM Contato";
		
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Long id = rs.getLong("id");
				String nome = rs.getString("nome");
				String fone = rs.getString("fone");
				Contato contato = new Contato(id, nome, fone);
				lista.add(contato);
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			System.out.println("Erro ao listar entidades com findAll()");
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public void delete(Long id) {
		sql = "DELETE FROM Contato WHERE id=?";
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.executeUpdate();
			stmt.close();
			
		} catch (SQLException e) {
			System.out.println("Erro ao apagar entidade contato");
			e.printStackTrace();
		}
	}

	
	@Override
	public boolean existsById(Long id) {
		sql = "SELECT EXISTS(SELECT * FROM Contato WHERE id=?) AS existe";
		boolean existe = false;
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			existe = rs.getInt("existe") == 1;
			stmt.close();
			
			
		} catch (SQLException e) {
			System.out.println("Erro em existsById()");
			e.printStackTrace();
		}
		
		return existe;
	}

	@Override
	public void update(Long id, Contato contato) {
		sql = "UPDATE Contato SET nome=?, fone=? WHERE id=?";
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getFone());
			stmt.setLong(3, id);
			stmt.executeUpdate();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

}

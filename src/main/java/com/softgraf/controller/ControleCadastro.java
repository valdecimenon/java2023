package com.softgraf.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.softgraf.entity.Aluno;
import com.softgraf.repository.AlunoRepository;
import com.softgraf.view.Alerta;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import util.JpaUtil;

public class ControleCadastro implements Initializable {

	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtEmail;
	
	private AlunoRepository alunoRepository;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Carregou tela de cadastro");
		this.alunoRepository = new AlunoRepository(JpaUtil.getEntityManager());
	}
	
	@FXML
	void acaoSalvar(ActionEvent event) {
		String nome = txtNome.getText().trim();
		String email = txtEmail.getText().trim();
		
		if (nome.isBlank())
			Alerta.msgAlerta("Faltou digitar o nome");
		
		else if (email.isBlank())
			Alerta.msgAlerta("Faltou digitar o email");
		
		else {
			Aluno aluno = new Aluno(nome, email);
			alunoRepository.persistir(aluno);
			Alerta.msgSucesso("Dados salvos!");
			txtId.clear();
			txtNome.clear();
			txtEmail.clear();
		}
	}
	
	@FXML
	void acaoBuscarPorNome(ActionEvent event) {
		String nome = txtNome.getText().trim();
		
		if (nome.isBlank())
			Alerta.msgAlerta("Faltou digitar o nome");
		else {
			Aluno aluno = alunoRepository.buscarPorNome(nome);
			if (aluno == null)
				Alerta.msgAlerta("Aluno não encontrado!");
			else {
				txtId.setText(aluno.getId().toString());
				txtNome.setText(aluno.getNome());
				txtEmail.setText(aluno.getEmail());
			}
		}
	}


}

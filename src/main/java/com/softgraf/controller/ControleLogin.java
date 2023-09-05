package com.softgraf.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.softgraf.repository.UsuarioRepository;
import com.softgraf.view.Alerta;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.JpaUtil;



public class ControleLogin implements Initializable {

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtSenha;
    
    private UsuarioRepository usuarioRepository;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("\nInicializando ControleLogin...");
		this.usuarioRepository = new UsuarioRepository(JpaUtil.getEntityManager());
	}

    
    @FXML
    void AcaoOk(ActionEvent event) throws IOException {
    	String nome = txtLogin.getText();
    	String senha = txtSenha.getText();
    	
//    	if (nome.equals("valdeci") && senha.equals("123")) {
    	if (usuarioRepository.autenticar(nome, senha)) {
    		
    		URL arquivoFXML = this.getClass().getResource("/com/softgraf/view/TelaCadastro.fxml");
    		Parent painel = (Parent) FXMLLoader.load(arquivoFXML);
    		
    		Stage stage = new Stage();
    		stage.setScene(new Scene(painel));
    		stage.setTitle("Cadastro de Alunos");
    		stage.setResizable(false);
    		stage.show();
    		PrincipalApp.stage.hide();
    	} else {
    		Alerta.msgAlerta("Login/senha inválida");
    	}

    }

    
    @FXML
    void AcaoCancelar(ActionEvent event) {
    }


   
}

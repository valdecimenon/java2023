package com.softgraf.controller;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.JpaUtil;

public class PrincipalApp extends Application {

	public static Stage stage;
	
	public static void main(String[] args) {
		System.out.println("\nInicializando main...");
		launch(args);  // launch chama start()
	}

	@Override
	public void start(Stage palco) throws Exception {
		stage = palco;
		
		URL arquivoFXML = this.getClass().getResource("/com/softgraf/view/TelaLogin.fxml");
		Parent painel = (Parent) FXMLLoader.load(arquivoFXML);

		palco.setScene(new Scene(painel, 330, 200));
		palco.setTitle("Faça seu login");
		palco.setResizable(false);
		palco.show();
	}
	
	@Override
	public void stop() throws Exception {
		System.out.println("\nFechando PrincipalLogin...");
		JpaUtil.close();
		super.stop();
	}

}

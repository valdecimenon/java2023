package com.softgraf.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerta {

	private static Alert alerta;
	
	public static void msgAlerta(String msgHeader) {
		alerta = new Alert(AlertType.WARNING);
		alerta.setTitle("Atenção");
		alerta.setHeaderText(msgHeader);
		alerta.showAndWait();
	}
	
	public static void msgSucesso(String msgHeader) {
		alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("Sucesso");
		alerta.setHeaderText(msgHeader);
		alerta.showAndWait();
	}
}

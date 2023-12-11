package com.softgraf.listeners;

import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.event.ActionListener;

public class ListenerAcao implements ActionListener {

	// chamado após a fase de Invoke Application, antes do Render Response
	@Override
	public void processAction(ActionEvent event) throws AbortProcessingException {
		String id = event.getComponent().getClientId();
		System.out.println("Executando ListenerAcao.processAction() \nComponente id: " + id + "\nPhaseId: " + event.getPhaseId());
	}
}

package com.softgraf.listeners;

import jakarta.faces.component.UIInput;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.faces.event.ValueChangeListener;

public class ListenerMudancaValor implements ValueChangeListener {

	// chamado após a fase de Process Validation, antes de Update Model Values
	@Override
	public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
		UIInput input = (UIInput) event.getComponent();
		String value = (String) input.getValue();
		input.setValue(value.toUpperCase());

		System.out.println("Executando ListenerMudancaValor.processValueChange()");		
	}
}

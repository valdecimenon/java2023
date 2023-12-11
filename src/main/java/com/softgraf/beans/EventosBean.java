package com.softgraf.beans;

import java.util.List;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.component.UIViewRoot;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;

@Named
@RequestScoped
public class EventosBean {

	// ============= Evento: ActionListener
	public String acaoBotao() {
		System.out.println("\nExecutando eventos.acaoBotao()");
		return null;
	}

	// chamado após a fase de Invoke Application: fase 5, antes do Render Response
	public String acaoListener(ActionEvent event) {
		String id = event.getComponent().getClientId();
		System.out.println("\nExecutando eventos.acaoListener() \nComponente id: " + id + "\nPhaseId: " + event.getPhaseId());
		return null;
	}
	
	
	// ============= Evento: ValueChangeListener
	
	public String mudancaValor(ValueChangeEvent event) {
		UIInput input = (UIInput) event.getComponent();
		String value = (String) input.getValue();
		input.setValue(value.toUpperCase());
		
		System.out.println("\nExecutando eventos.mudancaValor()");
		return null;
	}
	
	// ============= Evento: preRenderView
	public void carregaDados(ComponentSystemEvent event) {
		System.out.println("\nExecutando carregaDados... evento preRenderView..." + event.getComponent());
		System.out.println("Lista de componentes da view:");
		
		UIViewRoot view = (UIViewRoot) event.getComponent();
		List<UIComponent> lista = view.getChildren();
		
		lista.forEach(c -> {
			System.out.println(c.getId());
			if (c.getId().equals("form"))
				c.getChildren().forEach(item -> System.out.println("\t\t" + item.getId()));
		});
		
		UIInput campo1 = (UIInput) view.findComponent("form:campo1");
		campo1.setValue("Evento preRenderView");
	}
	
	// ============= Evento: postRenderView
	public void verificaDados(ComponentSystemEvent event) {
		System.out.println("\nExecutando verificaDados... evento postRenderView..." + event.getComponent());
	}
}

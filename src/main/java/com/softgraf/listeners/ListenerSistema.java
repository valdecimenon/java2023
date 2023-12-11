package com.softgraf.listeners;

import jakarta.faces.application.Application;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.SystemEvent;
import jakarta.faces.event.SystemEventListener;

/*  Incluir em faces-config.xml:
 * 
 * 	<application>
		<system-event-listener>
			<system-event-listener-class>
				com.softgraf.listeners.ListenerSistema
			</system-event-listener-class>
			<system-event-class>
				jakarta.faces.event.PostConstructApplicationEvent
			</system-event-class>
		</system-event-listener>
	</application>
 */

// Processa System Events da aplicação 
public class ListenerSistema implements SystemEventListener {

	@Override
	public void processEvent(SystemEvent event) throws AbortProcessingException {
		System.out.println("\n========== Processando evento do sistema ==========");
	}

	// retorna o tipo de origem do evento
	@Override
	public boolean isListenerForSource(Object source) {
		return source instanceof Application;
	}
}

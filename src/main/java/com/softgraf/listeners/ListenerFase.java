package com.softgraf.listeners;

import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;

/*
 * Um PhaseListener pode ser implementado para uma view específica, 
 * através da tag <f:phaseListener type="pacote.meuPhaseListener"/>
 * 
 * Ou para todas as views incluindo a tag abaixo em faces-config.xml
 * <faces-config>
 *    <lifecycle>
 *       <phase-listener type="pacote.meuPhaseListener"/>
 *    </lifecycle>
 * </faces-config>
 */

public class ListenerFase implements PhaseListener {

	private static final long serialVersionUID = 5124147212512172661L;

	public void beforePhase(PhaseEvent event) {
		System.out.println("beforePhase");
	}
	
	public void afterPhase(PhaseEvent event) {
		System.out.println("afterPhase");
	}
	
	@Override
	public PhaseId getPhaseId() {
		// diz ao JSF qual fase eu estou interessado em me
		// registrar, para receber as informações desta fase
		return PhaseId.ANY_PHASE;
	}
}

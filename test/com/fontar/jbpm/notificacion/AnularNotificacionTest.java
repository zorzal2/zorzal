package com.fontar.jbpm.notificacion;

import org.jbpm.taskmgmt.exe.TaskInstance;

import com.fontar.jbpm.util.JbpmConstants;

/**
 * 
 * Tests de anulacion de <code>Notificacion</code> en diferentes 
 * nodos del process definition.<br>
 * @author ssanchez
 */
public class AnularNotificacionTest extends BaseNotificacionTest {
	
	public void testAnularDesdePendienteEnvio(){
		
		// pateo el token del estado inicial
		token.signal();
		
		assertEquals(3,this.getUnfinishedTask().size());
		
		TaskInstance anular = this.findTaskInstanceByNameFromUnfinished(ANULAR_PROYECTO);
		assertNotNull(anular);
		anular.end();
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertEquals(0,token.getActiveChildren().keySet().size());
		assertTrue(processInstance.hasEnded());
	}
	
	public void testAnularDesdePendienteAcuse(){
		
		// pateo el token del estado inicial
		token.signal();
		
		assertEquals(3,this.getUnfinishedTask().size());
		
		TaskInstance enviarNotificacion = this.findTaskInstanceByNameFromUnfinished(ENVIAR_NOTIFICACION);
		assertNotNull(enviarNotificacion);
		enviarNotificacion.setVariable(JbpmConstants.VariableNames.REQUIERE_ACUSE,true);
		enviarNotificacion.end();
		
		assertEquals(3,this.getUnfinishedTask().size());
		
		TaskInstance anular = this.findTaskInstanceByNameFromUnfinished(ANULAR_PROYECTO);
		assertNotNull(anular);
		anular.end();
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertEquals(0,token.getActiveChildren().keySet().size());
		assertTrue(processInstance.hasEnded());
	}
}

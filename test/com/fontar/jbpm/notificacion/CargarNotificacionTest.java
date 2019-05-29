package com.fontar.jbpm.notificacion;

import org.jbpm.taskmgmt.exe.TaskInstance;

import com.fontar.jbpm.util.JbpmConstants;

/**
 * 
 * @author ssanchez
 *
 */
public class CargarNotificacionTest extends BaseNotificacionTest {

	public void testEnviarNotificacionSinAcuse(){
		
		token.signal();
		
		assertEquals(3,this.getUnfinishedTask().size());
		
		TaskInstance enviar = this.findTaskInstanceByNameFromUnfinished(ENVIAR_NOTIFICACION);
		assertNotNull(enviar);
		enviar.setVariable(JbpmConstants.VariableNames.REQUIERE_ACUSE,false);
		enviar.end();
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertEquals(0,token.getActiveChildren().keySet().size());
		assertTrue(processInstance.hasEnded());
	}

	public void testEnviarNotificacionConAcuse(){
		
		token.signal();
		
		assertEquals(3,this.getUnfinishedTask().size());
		
		TaskInstance enviar = this.findTaskInstanceByNameFromUnfinished(ENVIAR_NOTIFICACION);
		assertNotNull(enviar);
		enviar.setVariable(JbpmConstants.VariableNames.REQUIERE_ACUSE,true);
		enviar.end();
		
		TaskInstance recibir = this.findTaskInstanceByNameFromUnfinished(RECIBIR_ACUSE);
		assertNotNull(recibir);
		recibir.end();

		assertEquals(0,this.getUnfinishedTask().size());
		assertEquals(0,token.getActiveChildren().keySet().size());
		assertTrue(processInstance.hasEnded());
	}
	
	
}

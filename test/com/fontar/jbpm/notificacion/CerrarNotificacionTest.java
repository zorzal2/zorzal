package com.fontar.jbpm.notificacion;

import org.jbpm.taskmgmt.exe.TaskInstance;

import com.fontar.jbpm.util.JbpmConstants;

/**
 * 
 * Tests de cerrado de <code>Notificacion</code> en diferentes 
 * nodos del process definition.<br>
 * @author ssanchez
 */
public class CerrarNotificacionTest extends BaseNotificacionTest {
	
	public void testCerrarDesdePendienteEnvio(){
		
		// pateo el token del estado inicial
		token.signal();
		
		assertEquals(3,this.getUnfinishedTask().size());
		
		TaskInstance cerrar = this.findTaskInstanceByNameFromUnfinished(CERRAR_PROYECTO);
		assertNotNull(cerrar);
		cerrar.end();
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertEquals(0,token.getActiveChildren().keySet().size());
		assertTrue(processInstance.hasEnded());
	}
	
	public void testCerrarDesdePendienteAcuse(){
		
		// pateo el token del estado inicial
		token.signal();
		
		assertEquals(3,this.getUnfinishedTask().size());
		
		TaskInstance enviarNotificacion = this.findTaskInstanceByNameFromUnfinished(ENVIAR_NOTIFICACION);
		assertNotNull(enviarNotificacion);
		enviarNotificacion.setVariable(JbpmConstants.VariableNames.REQUIERE_ACUSE,true);
		enviarNotificacion.end();
		
		assertEquals(3,this.getUnfinishedTask().size());
		
		TaskInstance cerrar = this.findTaskInstanceByNameFromUnfinished(CERRAR_PROYECTO);
		assertNotNull(cerrar);
		cerrar.end();
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertEquals(0,token.getActiveChildren().keySet().size());
		assertTrue(processInstance.hasEnded());
	}
}

package com.fontar.jbpm.seguimiento.evaluacion;

import org.jbpm.taskmgmt.exe.TaskInstance;

/**
 * 
 * Tests de anulacion de <code>EvaluacionSeguimiento</code>.<br>
 * @author ssanchez
 */
public class AnularEvaluacionSeguimientoTest extends BaseEvaluacionSeguimientoTest {
	
	public void testAnular(){
		
		// pateo el token del estado inicial
 		token.signal();
		
		assertEquals(2,this.getUnfinishedTask().size());
		
		TaskInstance anular = this.findTaskInstanceByNameFromUnfinished(ANULAR);
		assertNotNull(anular);
		anular.end();
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertEquals(0,token.getActiveChildren().keySet().size());
		assertTrue(processInstance.hasEnded());
	}
}

package com.fontar.jbpm.ideaProyecto;

import org.jbpm.taskmgmt.exe.TaskInstance;

public class ElegibilidadTest extends BaseIdeaProyectoTest {

	public void testElegibilidad(){
		
		// pateo el token del estado incial
		token.signal();
		
		assertEquals(4,this.getUnfinishedTask().size());
		
		TaskInstance cargarPrimera = this.findTaskInstanceByNameFromUnfinished(TASK_EVALUAR_PRIMERA);
		assertNotNull(cargarPrimera);
		cargarPrimera.end();
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertEquals(0,token.getActiveChildren().keySet().size());
		assertTrue(processInstance.hasEnded());
	}
	
}




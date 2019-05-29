package com.fontar.jbpm.paquete;

import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.taskmgmt.exe.TaskInstance;

public class LiberarProyectosTest extends BasePaqueteTest {

	/**
	 *
	 */
	public void testLiberarProyectos(){
		
		cargarProyectos();
		
		token.signal();
		
		taskMgmt = processInstance.getTaskMgmtInstance();
		token = processInstance.getRootToken();
		
		// anulo el paquete
		TaskInstance anular = this.findTaskInstanceByNameFromUnfinished(TASK_ANULAR);
		assertNotNull(anular);
		anular.end();
		
		//
		
		assertTrue(processInstance.hasEnded());
	}
	
	
	private void cargarProyectos(){
		// Instancio 10 proyectos para meter en el paquete
		for (int i = 0; i < 10; i++) {
			ProcessInstance processInstanceProyecto = new ProcessInstance(ProcessDefinition.parseXmlResource("com/fontar/jbpm/process/Proyecto.par/processdefinition.xml"));
			@SuppressWarnings("unused") long id = processInstanceProyecto.getId();
		}
	}
	
	/**
	 * 
	 */
	
	

}

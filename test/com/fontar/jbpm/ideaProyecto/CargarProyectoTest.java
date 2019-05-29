package com.fontar.jbpm.ideaProyecto;

import org.jbpm.taskmgmt.exe.TaskInstance;

import com.fontar.data.impl.domain.codes.ideaProyecto.EstadoIdeaProyecto;
import com.fontar.jbpm.util.JbpmConstants;

/**
 * 
 * @author ssanchez
 *
 */
public class CargarProyectoTest extends BaseIdeaProyectoTest {

	public void testEvaluarPorJuntaElegible(){
		
		token.signal();
		
		assertEquals(4,this.getUnfinishedTask().size());
		
		TaskInstance evaluarPorJunta = this.findTaskInstanceByNameFromUnfinished(TASK_JUNTA);
		assertNotNull(evaluarPorJunta);
		evaluarPorJunta.setVariable(JbpmConstants.VariableNames.ESTADO,EstadoIdeaProyecto.ELEGIBLE);
		evaluarPorJunta.end();
		
		assertEquals(3,this.getUnfinishedTask().size());

		TaskInstance anular = this.findTaskInstanceByNameFromUnfinished(TASK_ANULAR );
		assertNotNull(anular);

		TaskInstance cerrar = this.findTaskInstanceByNameFromUnfinished(TASK_CERRAR);
		assertNotNull(cerrar);
		
		TaskInstance cargarProyecto = this.findTaskInstanceByNameFromUnfinished(TASK_CARGAR_PROYECTO);
		assertNotNull(cargarProyecto);
		cargarProyecto.end();
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertEquals(0,token.getActiveChildren().keySet().size());
		assertTrue(processInstance.hasEnded());
	}
	
}

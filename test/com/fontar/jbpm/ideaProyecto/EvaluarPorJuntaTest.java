package com.fontar.jbpm.ideaProyecto;

import org.jbpm.taskmgmt.exe.TaskInstance;

import com.fontar.data.impl.domain.codes.ideaProyecto.EstadoIdeaProyecto;
import com.fontar.jbpm.util.JbpmConstants;

/**
 * 
 * @author ssanchez
 *
 */
public class EvaluarPorJuntaTest extends BaseIdeaProyectoTest {

	public void testEvaluarPorJuntaElegible(){
		
		token.signal();
		
		assertEquals(4,this.getUnfinishedTask().size());
		
		TaskInstance evaluarPorJunta = this.findTaskInstanceByNameFromUnfinished(TASK_JUNTA);
		assertNotNull(evaluarPorJunta);
		evaluarPorJunta.setVariable(JbpmConstants.VariableNames.ESTADO,EstadoIdeaProyecto.ELEGIBLE);
		evaluarPorJunta.end();
		
		assertEquals(3,this.getUnfinishedTask().size());
		TaskInstance cargarProyecto = this.findTaskInstanceByNameFromUnfinished(TASK_CARGAR_PROYECTO);
		assertNotNull(cargarProyecto);
		
		TaskInstance anular = this.findTaskInstanceByNameFromUnfinished(TASK_ANULAR );
		assertNotNull(anular);

		TaskInstance cerrar = this.findTaskInstanceByNameFromUnfinished(TASK_CERRAR);
		assertNotNull(cerrar);
	}
	
	public void testEvaluarPorJuntaNoElegible(){
		
		token.signal();
		
		assertEquals(4,this.getUnfinishedTask().size());
		
		TaskInstance evaluarPorJunta = this.findTaskInstanceByNameFromUnfinished(TASK_JUNTA);
		assertNotNull(evaluarPorJunta);
		evaluarPorJunta.setVariable(JbpmConstants.VariableNames.ESTADO,EstadoIdeaProyecto.CERRADO);
		evaluarPorJunta.end();
		
		assertEquals(3,this.getUnfinishedTask().size());
		TaskInstance cargarProyecto = this.findTaskInstanceByNameFromUnfinished(TASK_RECONSIDERAR);
		assertNotNull(cargarProyecto);
		
		TaskInstance anular = this.findTaskInstanceByNameFromUnfinished(TASK_ANULAR );
		assertNotNull(anular);

		TaskInstance cerrar = this.findTaskInstanceByNameFromUnfinished(TASK_CERRAR);
		assertNotNull(cerrar);
	}	
}

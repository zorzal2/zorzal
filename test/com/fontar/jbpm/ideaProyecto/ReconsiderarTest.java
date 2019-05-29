package com.fontar.jbpm.ideaProyecto;

import org.jbpm.taskmgmt.exe.TaskInstance;

import com.fontar.data.impl.domain.codes.ideaProyecto.EstadoIdeaProyecto;
import com.fontar.jbpm.util.JbpmConstants;

/**
 * 
 * @author ssanchez
 *
 */
public class ReconsiderarTest extends BaseIdeaProyectoTest {

	public void testReconsiderarSinEvaluaciones(){
		
		token.signal();
		
		assertEquals(4,this.getUnfinishedTask().size());
		
		TaskInstance evaluarPorJunta = this.findTaskInstanceByNameFromUnfinished(TASK_JUNTA);
		assertNotNull(evaluarPorJunta);
		evaluarPorJunta.setVariable(JbpmConstants.VariableNames.ESTADO,EstadoIdeaProyecto.CERRADO);
		evaluarPorJunta.end();
		
		TaskInstance reconsiderar = this.findTaskInstanceByNameFromUnfinished(TASK_RECONSIDERAR);
		assertNotNull(reconsiderar);
		reconsiderar.end();

		assertEquals(4,this.getUnfinishedTask().size());
		
		TaskInstance cargarPrimeraEvaluacion = this.findTaskInstanceByNameFromUnfinished(TASK_EVALUAR_PRIMERA);
		assertNotNull(cargarPrimeraEvaluacion);
		
		TaskInstance evaluarPorJunta2 = this.findTaskInstanceByNameFromUnfinished(TASK_JUNTA);
		assertNotNull(evaluarPorJunta2);

		TaskInstance anular = this.findTaskInstanceByNameFromUnfinished(TASK_ANULAR );
		assertNotNull(anular);

		TaskInstance cerrar = this.findTaskInstanceByNameFromUnfinished(TASK_CERRAR);
		assertNotNull(cerrar);		
		
	}
	
	public void testReconsiderarConEvaluaciones(){
		
		token.signal();
		
		assertEquals(4,this.getUnfinishedTask().size());
		
		TaskInstance primeraEvaluacion = this.findTaskInstanceByNameFromUnfinished(TASK_EVALUAR_PRIMERA);
		assertNotNull(primeraEvaluacion);
		primeraEvaluacion.end();

		TaskInstance evaluarPorJunta = this.findTaskInstanceByNameFromUnfinished(TASK_JUNTA);
		assertNotNull(evaluarPorJunta);
		evaluarPorJunta.setVariable(JbpmConstants.VariableNames.ESTADO,EstadoIdeaProyecto.CERRADO);
		evaluarPorJunta.end();

		TaskInstance reconsiderar = this.findTaskInstanceByNameFromUnfinished(TASK_RECONSIDERAR);
		assertNotNull(reconsiderar);
		reconsiderar.end();

		assertEquals(4,this.getUnfinishedTask().size());
		
		TaskInstance cargarPrimeraEvaluacion = this.findTaskInstanceByNameFromUnfinished(TASK_EVALUAR_PRIMERA);
		assertNotNull(cargarPrimeraEvaluacion);
		
		TaskInstance evaluarPorJunta2 = this.findTaskInstanceByNameFromUnfinished(TASK_JUNTA);
		assertNotNull(evaluarPorJunta2);

		TaskInstance anular = this.findTaskInstanceByNameFromUnfinished(TASK_ANULAR );
		assertNotNull(anular);

		TaskInstance cerrar = this.findTaskInstanceByNameFromUnfinished(TASK_CERRAR);
		assertNotNull(cerrar);		
		
	}
	
	public void testReconsiderarConEvaluacionesYCargarProyecto(){
		
		token.signal();
		
		assertEquals(4,this.getUnfinishedTask().size());
		
		TaskInstance primeraEvaluacion = this.findTaskInstanceByNameFromUnfinished(TASK_EVALUAR_PRIMERA);
		assertNotNull(primeraEvaluacion);
		primeraEvaluacion.end();

		TaskInstance evaluarPorJunta = this.findTaskInstanceByNameFromUnfinished(TASK_JUNTA);
		assertNotNull(evaluarPorJunta);
		evaluarPorJunta.setVariable(JbpmConstants.VariableNames.ESTADO,EstadoIdeaProyecto.CERRADO);
		evaluarPorJunta.end();

		TaskInstance reconsiderar = this.findTaskInstanceByNameFromUnfinished(TASK_RECONSIDERAR);
		assertNotNull(reconsiderar);
		reconsiderar.end();

		assertEquals(4,this.getUnfinishedTask().size());
		
		TaskInstance cargarPrimeraEvaluacion = this.findTaskInstanceByNameFromUnfinished(TASK_EVALUAR_PRIMERA);
		assertNotNull(cargarPrimeraEvaluacion);
		
		TaskInstance evaluarPorJunta2 = this.findTaskInstanceByNameFromUnfinished(TASK_JUNTA);
		assertNotNull(evaluarPorJunta2);

		TaskInstance anular = this.findTaskInstanceByNameFromUnfinished(TASK_ANULAR );
		assertNotNull(anular);

		TaskInstance cerrar = this.findTaskInstanceByNameFromUnfinished(TASK_CERRAR);
		assertNotNull(cerrar);		
		
		TaskInstance evaluarPorJunta3 = this.findTaskInstanceByNameFromUnfinished(TASK_JUNTA);
		assertNotNull(evaluarPorJunta3);
		evaluarPorJunta3.setVariable(JbpmConstants.VariableNames.ESTADO,EstadoIdeaProyecto.ELEGIBLE );
		evaluarPorJunta3.end();
		
		TaskInstance cargarProyecto = this.findTaskInstanceByNameFromUnfinished(TASK_CARGAR_PROYECTO);
		assertNotNull(cargarProyecto);
		cargarProyecto.end();
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertEquals(0,token.getActiveChildren().keySet().size());
		assertTrue(processInstance.hasEnded());		
	}	
	
}

package com.fontar.jbpm.ideaProyecto;

import org.jbpm.taskmgmt.exe.TaskInstance;

import com.fontar.data.impl.domain.codes.ideaProyecto.EstadoIdeaProyecto;
import com.fontar.jbpm.util.JbpmConstants;

/**
 * 
 * Tests de anulacion de idea proyecto en diferentes nodos del process definition
 * 
 * @author ssanchez
 *
 */
public class AnularIdeaProyectoTest extends BaseIdeaProyectoTest {

	
	public void testAnularDesdeEvaluacion(){
		
		// pateo el token del estado incial
		token.signal();
		
		assertEquals(4,this.getUnfinishedTask().size());
		
		TaskInstance anular = this.findTaskInstanceByNameFromUnfinished(TASK_ANULAR);
		assertNotNull(anular);
		anular.end();
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertEquals(0,token.getActiveChildren().keySet().size());
		assertTrue(processInstance.hasEnded());
	}
	
	public void testAnularDesdeAgregarEvaluacion(){
		
		// pateo el token del estado incial
		token.signal();
		
		assertEquals(4,this.getUnfinishedTask().size());
		
		TaskInstance primeraEvaluacion = this.findTaskInstanceByNameFromUnfinished(TASK_EVALUAR_PRIMERA);
		assertNotNull(primeraEvaluacion);
		primeraEvaluacion.end();
		
		assertEquals(4,this.getUnfinishedTask().size());
		
		TaskInstance anular = this.findTaskInstanceByNameFromUnfinished(TASK_ANULAR);
		assertNotNull(anular);
		anular.setVariable(JbpmConstants.VariableNames.ESTADO,EstadoIdeaProyecto.CERRADO);
		anular.end();
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertEquals(0,token.getActiveChildren().keySet().size());
		assertTrue(processInstance.hasEnded());
	}
	
	public void testAnularDesdeElegible(){
		
		// pateo el token del estado incial
		token.signal();
		
		assertEquals(4,this.getUnfinishedTask().size());
		
		TaskInstance primeraEvaluacion = this.findTaskInstanceByNameFromUnfinished(TASK_EVALUAR_PRIMERA);
		assertNotNull(primeraEvaluacion);
		primeraEvaluacion.end();
		
		assertEquals(4,this.getUnfinishedTask().size());

		TaskInstance evaluarPorJunta = this.findTaskInstanceByNameFromUnfinished(TASK_JUNTA);
		assertNotNull(evaluarPorJunta);
		evaluarPorJunta.setVariable(JbpmConstants.VariableNames.ESTADO,EstadoIdeaProyecto.ELEGIBLE);
		evaluarPorJunta.end();
		
		
		TaskInstance anular = this.findTaskInstanceByNameFromUnfinished(TASK_ANULAR);
		assertNotNull(anular);
		anular.end();
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertEquals(0,token.getActiveChildren().keySet().size());
		assertTrue(processInstance.hasEnded());
	}
	
	public void testAnularDesdeNoElegible(){
		
		// pateo el token del estado incial
		token.signal();
		
		assertEquals(4,this.getUnfinishedTask().size());
		
		TaskInstance primeraEvaluacion = this.findTaskInstanceByNameFromUnfinished(TASK_EVALUAR_PRIMERA);
		assertNotNull(primeraEvaluacion);
		primeraEvaluacion.end();
		
		assertEquals(4,this.getUnfinishedTask().size());

		TaskInstance evaluarPorJunta = this.findTaskInstanceByNameFromUnfinished(TASK_JUNTA);
		assertNotNull(evaluarPorJunta);
		evaluarPorJunta.setVariable(JbpmConstants.VariableNames.ESTADO,EstadoIdeaProyecto.CERRADO);
		evaluarPorJunta.end();
		
		TaskInstance anular = this.findTaskInstanceByNameFromUnfinished(TASK_ANULAR);
		assertNotNull(anular);
		anular.end();
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertEquals(0,token.getActiveChildren().keySet().size());
		assertTrue(processInstance.hasEnded());
	}	
	
}

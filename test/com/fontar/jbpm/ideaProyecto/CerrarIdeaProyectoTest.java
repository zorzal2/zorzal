package com.fontar.jbpm.ideaProyecto;

import org.jbpm.taskmgmt.exe.TaskInstance;

import com.fontar.data.impl.domain.codes.ideaProyecto.EstadoIdeaProyecto;
import com.fontar.jbpm.util.JbpmConstants;

/**
 * 
 * Tests de cerrado de idea proyecto en diferentes nodos del process definition
 * 
 * @author ssanchez
 *
 */
public class CerrarIdeaProyectoTest extends BaseIdeaProyectoTest {

	
	public void testCerrarDesdeEvaluacion(){
		
		// pateo el token del estado incial
		token.signal();
		
		assertEquals(4,this.getUnfinishedTask().size());
		
		TaskInstance cerrar = this.findTaskInstanceByNameFromUnfinished(TASK_CERRAR);
		assertNotNull(cerrar);
		cerrar.end();
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertEquals(0,token.getActiveChildren().keySet().size());
		assertTrue(processInstance.hasEnded());
	}
	
	public void testCerrarDesdeAgregarEvaluacion(){
		
		// pateo el token del estado incial
		token.signal();
		
		assertEquals(4,this.getUnfinishedTask().size());
		
		TaskInstance primeraEvaluacion = this.findTaskInstanceByNameFromUnfinished(TASK_EVALUAR_PRIMERA);
		assertNotNull(primeraEvaluacion);
		primeraEvaluacion.end();
		
		assertEquals(4,this.getUnfinishedTask().size());
		
		TaskInstance cerrar = this.findTaskInstanceByNameFromUnfinished(TASK_CERRAR);
		assertNotNull(cerrar);
		cerrar.setVariable(JbpmConstants.VariableNames.ESTADO,EstadoIdeaProyecto.CERRADO);
		cerrar.end();
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertEquals(0,token.getActiveChildren().keySet().size());
		assertTrue(processInstance.hasEnded());
	}
	
	public void testCerrarDesdeElegible(){
		
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
		
		
		TaskInstance cerrar = this.findTaskInstanceByNameFromUnfinished(TASK_CERRAR);
		assertNotNull(cerrar);
		cerrar.end();
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertEquals(0,token.getActiveChildren().keySet().size());
		assertTrue(processInstance.hasEnded());
	}
	
	public void testCerrarDesdeNoElegible(){
		
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
		
		TaskInstance cerrar = this.findTaskInstanceByNameFromUnfinished(TASK_CERRAR);
		assertNotNull(cerrar);
		cerrar.end();
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertEquals(0,token.getActiveChildren().keySet().size());
		assertTrue(processInstance.hasEnded());
	}	
	
}

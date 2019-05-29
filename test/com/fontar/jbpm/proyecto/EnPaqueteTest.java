package com.fontar.jbpm.proyecto;

import org.jbpm.graph.exe.Token;
import org.jbpm.taskmgmt.exe.TaskInstance;

import com.fontar.data.impl.domain.codes.proyecto.EstadoProyecto;
import com.fontar.jbpm.util.JbpmConstants;
import com.pragma.PragmaException;

public class EnPaqueteTest extends BaseProyectoTest {
	
	/*
	 * Chequeo que al entrar en el estado En Paquete sigan disponibles las tareas globales
	 */
	public void testGlobalesActivas()
	{
		token.signal();
				
		// Admito
		admitir();
		
		// Agrego 1ra Evaluacion
		TaskInstance primeraEvaluacion = this.findTaskInstanceByNameFromUnfinished("Agregar Evaluación");
		assertNotNull(primeraEvaluacion);
		primeraEvaluacion.end();
		
		// Finalizo control
		TaskInstance finalizarControl = this.findTaskInstanceByNameFromUnfinished("Finalizar Control");
		assertNotNull(finalizarControl);
		
		// Aca seteo el Estado, seria el estado luego de la evaluacion del PAQUETE
		finalizarControl.setVariable(JbpmConstants.VariableNames.ESTADO,EstadoProyecto.EVALUACION);
		finalizarControl.end();
		
		// No tengo que seguir evaluando
		TaskInstance seguirEvaluando = this.findTaskInstanceByNameFromUnfinished("Agregar Evaluación");
		assertNull(seguirEvaluando);
				
		// Entro en estado EnProceso, la tarea Cerrar Proyecto y Editar Presupuesto se suspenden
		assertEquals(0,this.getUnfinishedTask().size());
				
		//Salgo de EnPaquete
		Token token = processInstance.findToken("principal");
		
		try {
			token.signal();	
		}
		catch(PragmaException ex) {
			System.out.println(ex.getMessage());
		}
				
		// Finalizar Control, Agregar Evaluacion, Editar Presupuesto , Cerrar Proyecto y Anular Proyecto
		assertEquals(5,this.getUnfinishedTask().size());
		assertFalse(processInstance.hasEnded());
	}
	
}

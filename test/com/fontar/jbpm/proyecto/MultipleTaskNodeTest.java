package com.fontar.jbpm.proyecto;

import org.jbpm.taskmgmt.exe.TaskInstance;

public class MultipleTaskNodeTest extends BaseProyectoTest {

	@SuppressWarnings("unchecked")
	public void testOpenedTaskInAgregarPrimeraEvaluacion()
	{
		// arranco
		token.signal();
		
		// admito
		admitir();
				
		// Cargo primera evaluacion
		TaskInstance evaluacion = this.findTaskInstanceByNameFromUnfinished("Agregar Evaluación");
		assertNotNull(evaluacion);
		evaluacion.end();
		
		// Pasar proxima etapa debe estar cancelada 
		TaskInstance pasarPE = this.findTaskInstanceByName(taskMgmt.getTaskInstances(),"Pasar Próxima Etapa");
		assertNotNull(pasarPE);
		assertTrue(pasarPE.isCancelled());
		
		TaskInstance finalizar = this.findTaskInstanceByNameFromUnfinished("Finalizar Control");
		assertNotNull(finalizar);
		finalizar.end();
			
	}
}

package com.fontar.jbpm.paquete;

import java.util.Collection;

import org.jbpm.taskmgmt.exe.TaskInstance;

public class TareasTest extends BasePaqueteTest {
	
	public void testTareasInicial()
	{
		// kick token from start
		token.signal();
		
		// las pendientes
		Collection<TaskInstance> unfinished = this.getUnfinishedTask();
		
		// tiene que haber tareas pendientes
		assertTrue(unfinished.size() == 3);

		TaskInstance anular = findTaskInstanceByName(unfinished, TASK_ANULAR);
		TaskInstance editar = findTaskInstanceByName(unfinished, TASK_EDITAR);
		TaskInstance evaluar = findTaskInstanceByName(unfinished, TASK_EVALUAR);
		
		// deben existir
		assertNotNull(anular);
		assertNotNull(editar);
		assertNotNull(evaluar);
		
		assertFalse(processInstance.hasEnded());
	}
		
	public void testTareasEvaluado()
	{
		// kick token from start
		token.signal();
		
		// las pendientes
		Collection<TaskInstance> unfinished = this.getUnfinishedTask();
		
		// evaluo
		TaskInstance primeraEvaluacion = findTaskInstanceByName(unfinished, TASK_EVALUAR);
		primeraEvaluacion.end();
		
		unfinished = this.getUnfinishedTask();
		
		// tiene que haber tareas pendientes
		assertTrue(unfinished.size() == 3);

		TaskInstance anular = findTaskInstanceByName(unfinished, TASK_ANULAR);
		TaskInstance confirmar = findTaskInstanceByName(unfinished, TASK_CONFIMAR);
		TaskInstance evaluar = findTaskInstanceByName(unfinished, TASK_EVALUAR);
				
		// deben existir
		assertNotNull(anular);
		assertNotNull(confirmar);
		assertNotNull(evaluar);
		
		assertFalse(processInstance.hasEnded());
	}
	
	public void testTareasConfirmado()
	{
		// kick token from start
		token.signal();
		
		// las pendientes
		Collection<TaskInstance> unfinished = this.getUnfinishedTask();
		
		// evaluo
		TaskInstance primeraEvaluacion = findTaskInstanceByName(unfinished, TASK_EVALUAR);
		assertNotNull(primeraEvaluacion);
		primeraEvaluacion.end();
		
		unfinished = this.getUnfinishedTask();
		
		TaskInstance confirmar = findTaskInstanceByName(unfinished, TASK_CONFIMAR);
		assertNotNull(confirmar);
		confirmar.end();
		
		unfinished = this.getUnfinishedTask();
		
		assertTrue(unfinished.size() == 0);				
		assertTrue(processInstance.hasEnded());
	}
}

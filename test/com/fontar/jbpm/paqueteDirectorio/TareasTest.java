package com.fontar.jbpm.paqueteDirectorio;

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
		TaskInstance controlar = findTaskInstanceByName(unfinished, TASK_CONTROLAR);
		
		// deben existir
		assertNotNull(anular);
		assertNotNull(editar);
		assertNotNull(controlar);
		
		assertFalse(processInstance.hasEnded());
	}
		
	public void testTareasControlado()
	{
		// kick token from start
		token.signal();
		
		// las pendientes
		Collection<TaskInstance> unfinished = this.getUnfinishedTask();
		
		// evaluo
		TaskInstance controlar = findTaskInstanceByName(unfinished, TASK_CONTROLAR);
		assertNotNull(controlar);
		controlar.end();
		
		unfinished = this.getUnfinishedTask();
		
		// tiene que haber tareas pendientes
		assertTrue(unfinished.size() == 2);

		TaskInstance anular = findTaskInstanceByName(unfinished, TASK_ANULAR);
		TaskInstance evaluar = findTaskInstanceByName(unfinished, TASK_EVALUAR);
				
		// deben existir
		assertNotNull(anular);
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
		TaskInstance controlar = findTaskInstanceByName(unfinished, TASK_CONTROLAR);
		assertNotNull(controlar);
		controlar.end();
		
		unfinished = this.getUnfinishedTask();
		
		TaskInstance primeraEvaluacion = findTaskInstanceByName(unfinished, TASK_EVALUAR);
		assertNotNull(primeraEvaluacion);
		primeraEvaluacion.end();
		
		unfinished = this.getUnfinishedTask();
		
		assertTrue(unfinished.size() == 3);
		
		TaskInstance anular = findTaskInstanceByName(unfinished, TASK_ANULAR);
		TaskInstance evaluar = findTaskInstanceByName(unfinished, TASK_EVALUAR);
		TaskInstance confirmar = findTaskInstanceByName(unfinished, TASK_CONFIMAR);
		
		assertNotNull(anular);
		assertNotNull(evaluar);
		assertNotNull(confirmar);
		
		confirmar.end();
		
		unfinished = this.getUnfinishedTask();
						
		assertTrue(unfinished.size() == 0);
		assertTrue(processInstance.hasEnded());
	}
}

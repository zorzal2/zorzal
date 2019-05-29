package com.fontar.jbpm.paquete;

import java.util.Collection;

import org.jbpm.taskmgmt.exe.TaskInstance;

public class AnularPaqueteTest extends BasePaqueteTest {
	
	/**
	 * Anulo el PAQUETE cuando esta en Cargar Evaluación
	 */
	public void testAnularCargarEvaluacion()
	{
		// kick token from start
		token.signal();
		
		// las pendientes
		Collection<TaskInstance> unfinished = this.getUnfinishedTask();
		
		// tiene que haber tareas pendientes
		assertTrue(unfinished.size() > 0);

		// tomo la tarea Anular de la Task Pendiente Resultado
		TaskInstance anular = findTaskInstanceByName(unfinished, TASK_ANULAR);
		
		// tiene que existir la tarea
		assertNotNull(anular);
		
		assertSame(anular.getToken().getNode(), ANULAR);
		
		// la termino
		anular.end();
		
		assertTrue(processInstance.hasEnded());
		assertEquals(this.getUnfinishedTask().size(),0);
	}
	
	
	/**
	 * Intento anular desde la TASK PENDIENTE RESULTADO sin setear el estado
	 *
	 */
	public void testAnularConfirmarPaquete()
	{
		// kick token from start
		token.signal();
		
		// las pendientes
		Collection<TaskInstance> unfinished = this.getUnfinishedTask();
		
		// tiene que haber tareas pendientes
		assertTrue(unfinished.size() > 0);

		// tomo la tarea Anular de la Task Pendiente Resultado
		TaskInstance evaluar = findTaskInstanceByName(unfinished, TASK_EVALUAR);
				
		// tiene que existir la tarea
		assertNotNull(evaluar);

		// termino evaluar paquete
		evaluar.end();
		
		//
		unfinished = this.getUnfinishedTask();
		
		
		// tomo la tarea Anular de la Task Pendiente Resultado
		TaskInstance anular = findTaskInstanceByName(unfinished, TASK_ANULAR);
		
		assertSame(anular.getToken().getNode(), ANULAR);
		anular.end();
		
		assertTrue(processInstance.hasEnded());
		assertEquals(this.getUnfinishedTask().size(),0);
	}
	
	public void testEditarPaqueteAnular()
	{
		// kick token from start
		token.signal();
		
		// las pendientes
		Collection<TaskInstance> unfinished = this.getUnfinishedTask();
		
		// tiene que haber tareas pendientes
		assertTrue(unfinished.size() > 0);
		
		// edito 10 veces
		for (int i = 1; i < 10; i++)
		{
			// edito
			unfinished = this.getUnfinishedTask();
			TaskInstance editar = findTaskInstanceByName(unfinished, TASK_EDITAR);
			assertNotNull(editar);
			editar.end();
		}

		// tomo la tarea Anular de la Task Pendiente Resultado
		TaskInstance anular = findTaskInstanceByName(unfinished, TASK_ANULAR);
		
		// tiene que existir la tarea
		assertNotNull(anular);
		
		assertSame(anular.getToken().getNode(), ANULAR);
		
		// la termino
		anular.end();
		
		assertTrue(processInstance.hasEnded());
		assertEquals(this.getUnfinishedTask().size(),0);
	}
}

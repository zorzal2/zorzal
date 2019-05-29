package com.fontar.jbpm.evaluacion;

import java.util.Collection;

import org.jbpm.graph.def.Node;
import org.jbpm.taskmgmt.exe.TaskInstance;

import com.fontar.data.impl.domain.codes.evaluacion.EstadoEvaluacion;
import com.fontar.jbpm.util.JbpmConstants;

public class ConfirmarEvaluacionTest extends BaseEvaluacionTest {
	
	private static String TASK_CARGAR = "Cargar resultado";
	private static String TASK_CONFIRMAR = "Confirmar resultado";
	private static Node PENDIENTE_RESULTADO = processDefinition.getNode("Pendiente de Resultado");
	private static Node CARGAR_RESULTADO = processDefinition.getNode("Cargar Resultado");
	
	
	/**
	 * Carga primer resultado y luego ejecuta 10 veces la tarea repetitiva de Cargar Resultado
	 *
	 */
	public void testLoopCargarResultado()
	{
		// asi el estado de decision hace lo que queremos
		processInstance.getContextInstance().createVariable(JbpmConstants.VariableNames.ESTADO,EstadoEvaluacion.PEND_RESULT);
		
		// kick token from start
		token.signal();
		
		// las pendientes
		Collection<TaskInstance> unfinished = this.getUnfinishedTask();
		
		// tiene que haber tareas pendientes
		assertTrue(unfinished.size() > 0);
		
		// tomo la tarea Cargar Resultado de la Task Pendiente Resultado
		TaskInstance cargarResultado = findTaskInstanceByName(unfinished, TASK_CARGAR);
		
		// tiene que existir la tarea
		assertNotNull(cargarResultado);
		
		// tiene que estar en el nodo pendiente resultado
		assertEquals(cargarResultado.getToken().getNode(), PENDIENTE_RESULTADO);
		
		// la termino
		cargarResultado.end();
		
		
		// ahora hago loop sobre CargarResultado repetible
		for (int i = 0; i < 10; i++)
		{
			unfinished = this.getUnfinishedTask();
			
			// tiene que haber tareas pendientes
			assertTrue(unfinished.size() > 0);
			
			// tomo la tarea Cargar Resultado de la Task Pendiente Resultado
			TaskInstance cargarResultadoloop = findTaskInstanceByName(unfinished, TASK_CARGAR);
			
			// tiene que existir la tarea
			assertNotNull(cargarResultadoloop);
			
			// tiene que estar en el nodo pendiente resultado
			assertEquals(cargarResultadoloop.getToken().getNode(), CARGAR_RESULTADO);
			
			// la termino
			cargarResultadoloop.end();
		}
		
		unfinished = this.getUnfinishedTask();

		// tengo que tener Cargar Resultado y Confirmar Resultado del Fork
		assertTrue(unfinished.size() == 2);
		assertFalse(processInstance.hasEnded());
	}
	
	/**
	 * Carga primer resultado , luego ejecuta 10 veces la tarea repetitiva de Cargar Resultado
	 * y finalmente ejecutar Confirmar Resultado
	 */
	public void testConfirmarResultado()
	{
		// asi el estado de decision hace lo que queremos
		processInstance.getContextInstance().createVariable(JbpmConstants.VariableNames.ESTADO,EstadoEvaluacion.PEND_RESULT);
		
		// kick token from start
		token.signal();
		
		// las pendientes
		Collection<TaskInstance> unfinished = this.getUnfinishedTask();
		
		// tiene que haber tareas pendientes
		assertTrue(unfinished.size() > 0);
		
		// tomo la tarea Cargar Resultado de la Task Pendiente Resultado
		TaskInstance cargarResultado = findTaskInstanceByName(unfinished, TASK_CARGAR);
		
		// tiene que existir la tarea
		assertNotNull(cargarResultado);
		
		// tiene que estar en el nodo pendiente resultado
		assertEquals(cargarResultado.getToken().getNode(), PENDIENTE_RESULTADO);
		
		// la termino
		cargarResultado.end();
		
		
		// ahora hago loop sobre CargarResultado repetible
		for (int i = 0; i < 10; i++)
		{
			unfinished = this.getUnfinishedTask();
			
			// tiene que haber tareas pendientes
			assertTrue(unfinished.size() > 0);
			
			// tomo la tarea Cargar Resultado de la Task Cargar Resultado
			TaskInstance cargarResultadoloop = findTaskInstanceByName(unfinished, TASK_CARGAR);
			
			// tiene que existir la tarea
			assertNotNull(cargarResultadoloop);
			
			// tiene que estar en el nodo Cargar Resultado
			assertEquals(cargarResultadoloop.getToken().getNode(), CARGAR_RESULTADO);
			
			// la termino
			cargarResultadoloop.end();
		}
		
		unfinished = this.getUnfinishedTask();
		TaskInstance confirmarResultado = findTaskInstanceByName(unfinished,TASK_CONFIRMAR);
		confirmarResultado.end();

		unfinished = this.getUnfinishedTask();

		assertTrue(unfinished.size() == 0);
		assertTrue(processInstance.hasEnded());
	}
}
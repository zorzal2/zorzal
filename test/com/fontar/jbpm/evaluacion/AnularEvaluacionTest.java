package com.fontar.jbpm.evaluacion;

import java.util.Collection;

import org.jbpm.graph.def.Node;
import org.jbpm.taskmgmt.exe.TaskInstance;

import com.fontar.data.impl.domain.codes.evaluacion.EstadoEvaluacion;
import com.fontar.jbpm.util.JbpmConstants;

public class AnularEvaluacionTest extends BaseEvaluacionTest {
	
	private static String TASK_ANULAR = "Anular";
	private static Node PENDIENTE_RESULTADO = processDefinition.getNode("Pendiente de Resultado");
	private static Node PENDIENTE_AUTORIZACION = processDefinition.getNode("Pendiente Autorizacion");

	/**
	 * Seteo el estado en PEND_RESULTADO e intento anular desde la TASK PENDIENTE RESULTADO
	 *
	 */
	public void testAnularPendienteResultado()
	{
		
		// asi el estado de decision hace lo que queremos
		processInstance.getContextInstance().createVariable(JbpmConstants.VariableNames.ESTADO,EstadoEvaluacion.PEND_RESULT);
		
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
		
		// tiene que estar en el nodo pendiente resultado
		assertSame(anular.getToken().getNode(), PENDIENTE_RESULTADO);
		
		// la termino
		anular.end();
		
		assertTrue(processInstance.hasEnded());
		assertEquals(this.getUnfinishedTask().size(),0);
	}
	
	
	/**
	 * Intento anular desde la TASK PENDIENTE RESULTADO sin setear el estado
	 *
	 */
	public void testAnularPendienteAutorizacion()
	{
		processInstance.getContextInstance().createVariable(JbpmConstants.VariableNames.ESTADO,EstadoEvaluacion.PEND_AUTORIZ);
		
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
		
		// tiene que estar en el nodo Pendiente Autorizacion
		assertSame(anular.getToken().getNode(), PENDIENTE_AUTORIZACION);
		
		// la termino
		anular.end();
		
		assertTrue(processInstance.hasEnded());
		assertEquals(this.getUnfinishedTask().size(),0);
	}
}

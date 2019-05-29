package com.fontar.jbpm.proyecto;

import java.util.Collection;

import org.jbpm.graph.exe.Token;
import org.jbpm.taskmgmt.exe.TaskInstance;

import com.fontar.data.impl.domain.codes.proyecto.EstadoProyecto;
import com.fontar.jbpm.util.JbpmConstants;

/*
 * @author fferrara 
 */

public class CancelarProyectoTest extends BaseProyectoTest {
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void testUnfinishedTaskInAdmision()
	{
		Collection<TaskInstance> unfinished = getUnfinishedTask(); 
		assertTrue(unfinished.size() == 0);
		
		token.signal();
		
		unfinished = getUnfinishedTask();
		
		for(TaskInstance ti: unfinished)
		{
			System.out.println(ti.toString());
		}
		
		assertTrue(unfinished.size() > 0);
	}
	
	/**
	 * 
	 */
	public void testCancelAllUnfinishedTask()
	{
		token.signal();
		Collection<TaskInstance> unfinished = this.getUnfinishedTask();
		
		assertTrue(unfinished.size() > 0);			
		
		for(TaskInstance ti: unfinished)
		{
			System.out.println(ti.toString());
			ti.cancel();
		}
		unfinished = this.getUnfinishedTask();
		assertEquals(unfinished.size(),0);
	}
	
	/**
	 * 
	 *
	 */
	public void testCancelProcess()
	{
		//JbpmConstants.VariableNames.RESULTADO_ADMISION
		token.signal();
		//lo pongo en finalizado
		processInstance.end();
		
		Collection<TaskInstance> unfinished = this.getUnfinishedTask();
				
		for(TaskInstance ti: unfinished)
		{
			System.out.println(ti.toString()+ " - " + ti.getCreate() +" - " + ti.getStart() + " - " + ti.getEnd());
			ti.cancel();
		}
		
		unfinished = this.getUnfinishedTask();
		
		assertTrue(processInstance.hasEnded());
		assertTrue(unfinished.size()==0);
	}
	
	@SuppressWarnings("unchecked")
	public void testCerrarProyectoEnEvaluacion()
	{
		
		log.debug("HOLA!");
		
		token.signal();
		// fork, tengo 3 tokens

		Collection<TaskInstance> unfinished = getUnfinishedTask();
				
		for(TaskInstance ti: unfinished)
		{
			// me fijo sobre Cerrar proyecto
			if(ti.getName().equalsIgnoreCase("Cerrar Proyecto"))
			{
				ti.end();
			}
		}
		
		unfinished = getUnfinishedTask();
		
		for(TaskInstance ti: unfinished)
		{
			System.out.println(ti.toString()+ " - " + ti.getCreate() +" - " + ti.getStart() + " - " + ti.getEnd());
			log.debug(ti.toString()+ " - " + ti.getCreate() +" - " + ti.getStart() + " - " + ti.getEnd());
		}
		
		assertTrue(processInstance.hasEnded());
		assertTrue(unfinished.size()==0);
	}
	
	@SuppressWarnings("unchecked")
	public void testCerrarProyectoAdmitido()
	{
		token.signal();
		// fork, tengo 3 tokens

		admitir();
		
		// traigo tareas no terminadas
		Collection<TaskInstance> unfinished = getUnfinishedTask();
		
		for(TaskInstance ti: unfinished)
		{
			// me fijo sobre Cerrar proyecto
			if(ti.getName().equalsIgnoreCase("Cerrar Proyecto"))
			{
				ti.end();
			}
		}
		
		// traigo tareas no terminadas
		unfinished = getUnfinishedTask();
		
		for(TaskInstance ti: unfinished)
		{
			System.out.println(ti.toString()+ " - " + ti.getCreate() +" - " + ti.getStart() + " - " + ti.getEnd());
			log.debug(ti.toString()+ " - " + ti.getCreate() +" - " + ti.getStart() + " - " + ti.getEnd());
		}
		
		assertTrue(processInstance.hasEnded());
		assertTrue(unfinished.size()==0);
	}	
	
	
	@SuppressWarnings("unchecked")
	public void testCerrarProyectoNoAdmitido()
	{
		token.signal();
		// fork, tengo 3 tokens

		noAdmitir();
		Collection<TaskInstance> unfinished = getUnfinishedTask();
		
		TaskInstance ti = findTaskInstanceByNameFromUnfinished("Cerrar Proyecto");
		ti.end();
				
		// traigo tareas no terminadas
		unfinished = getUnfinishedTask();
		
		assertTrue(processInstance.hasEnded());
		assertTrue(unfinished.size()==0);
	}	

	
	@SuppressWarnings("unchecked")
	public void testCerrarProyectoConPrimeraEvaluacion()
	{
		token.signal();
		// fork, tengo 3 tokens
		
		admitir();
		Collection<TaskInstance> unfinished = getUnfinishedTask();
				
		TaskInstance agregarEvaluacion = findTaskInstanceByNameFromUnfinished("Agregar Evaluación");
		agregarEvaluacion.end();
						
		// traigo tareas no terminadas
		unfinished = getUnfinishedTask();
		
		TaskInstance finalizarControl = findTaskInstanceByNameFromUnfinished("Finalizar Control");
		finalizarControl.end();
		
		// Entro en estado en Paquete -> no puedo cerrar proyecto
		TaskInstance cerrar = this.findTaskInstanceByNameFromUnfinished("Cerrar Proyecto");
		assertNull(cerrar);
		
		assertFalse(processInstance.hasEnded());
	}	
	
	@SuppressWarnings("unchecked")
	public void testCerrarProyectoFirmaContrato()
	{
		token.signal();
		// fork, tengo 3 tokens
			
		cerrarProyectoEnPaquete(EstadoProyecto.ADJUDICADO);
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertTrue(processInstance.hasEnded());
	}	

	@SuppressWarnings("unchecked")
	public void testCerrarProyectoSolicitudReconsideracion()
	{
		token.signal();
		// fork, tengo 3 tokens
			
		cerrarProyectoEnPaquete(EstadoProyecto.POS_RECON);
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertTrue(processInstance.hasEnded());
	}	
	
	@SuppressWarnings("unchecked")
	public void testCerrarProyectoCargarAlicuota()
	{
		token.signal();
		// fork, tengo 3 tokens
		
		cerrarProyectoEnPaquete(EstadoProyecto.PEND_ALIC);
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertTrue(processInstance.hasEnded());
	}
	
	public void testCerrarProyectoAnalisisLegal()
	{
		token.signal();
		// fork, tengo 3 tokens
		
		avanzarProyectoEnPaquete(EstadoProyecto.POS_RECON);
		
		TaskInstance solicitarReconsideracion = this.findTaskInstanceByNameFromUnfinished("Solicitar Reconsideracion");
		assertNotNull(solicitarReconsideracion);
		solicitarReconsideracion.end();
		
		TaskInstance cerrar = this.findTaskInstanceByNameFromUnfinished("Cerrar Proyecto");
		
		assertNotNull(cerrar);
		cerrar.end();		
				
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertTrue(processInstance.hasEnded());
	}
	
	public void testCerrarProyectoReconsideracion()
	{
		token.signal();
		// fork, tengo 3 tokens
		
		avanzarProyectoEnPaquete(EstadoProyecto.POS_RECON);
		
		TaskInstance solicitarReconsideracion = this.findTaskInstanceByNameFromUnfinished("Solicitar Reconsideracion");
		assertNotNull(solicitarReconsideracion);
		solicitarReconsideracion.end();
		
	
		TaskInstance analizar = this.findTaskInstanceByNameFromUnfinished("Analizar Reconsideracion");
		assertNotNull(analizar);
		
		analizar.setVariable(JbpmConstants.VariableNames.ESTADO,EstadoProyecto.RECON);
		analizar.end();
			
		TaskInstance cerrar = this.findTaskInstanceByNameFromUnfinished("Cerrar Proyecto");
		
		assertNotNull(cerrar);
		cerrar.end();		
				
		assertEquals(0,this.getUnfinishedTask().size());
		assertTrue(processInstance.hasEnded());
	}
	
	
	public void testCerrarProyectoSinReconsideracion()
	{
		token.signal();
		// fork, tengo 3 tokens
		
		avanzarProyectoEnPaquete(EstadoProyecto.POS_RECON);
		
		TaskInstance solicitarReconsideracion = this.findTaskInstanceByNameFromUnfinished("Solicitar Reconsideracion");
		assertNotNull(solicitarReconsideracion);
		solicitarReconsideracion.end();
		
		TaskInstance analizar = this.findTaskInstanceByNameFromUnfinished("Analizar Reconsideracion");
		assertNotNull(analizar);
		
		analizar.setVariable(JbpmConstants.VariableNames.ESTADO,EstadoProyecto.CERRADO);
		analizar.end();
			
		TaskInstance cerrar = this.findTaskInstanceByNameFromUnfinished("Cerrar Proyecto");
		assertNull(cerrar);
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertTrue(processInstance.hasEnded());
	}
	
	public void testCerrarProyectoSinReconsideracionAdjudicado()
	{
		token.signal();
		// fork, tengo 3 tokens
		
		avanzarProyectoEnPaquete(EstadoProyecto.ADJUDICADO);
		
		TaskInstance solicitarReconsideracion = this.findTaskInstanceByNameFromUnfinished("Solicitar Reconsideracion");
		assertNotNull(solicitarReconsideracion);
		solicitarReconsideracion.end();
		
		TaskInstance analizar = this.findTaskInstanceByNameFromUnfinished("Analizar Reconsideracion");
		assertNotNull(analizar);
		
		analizar.setVariable(JbpmConstants.VariableNames.ESTADO,EstadoProyecto.CERRADO);
		analizar.end();
			
		TaskInstance cerrar = this.findTaskInstanceByNameFromUnfinished("Cerrar Proyecto");
		assertNull(cerrar);
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertTrue(processInstance.hasEnded());
	}
	
	
	public void testCerrarProyectoReconsideracionAlicuota()
	{
		token.signal();
		// fork, tengo 3 tokens
		
		avanzarProyectoEnPaquete(EstadoProyecto.POS_RECON);
		
		TaskInstance solicitarReconsideracion = this.findTaskInstanceByNameFromUnfinished("Solicitar Reconsideracion");
		assertNotNull(solicitarReconsideracion);
		solicitarReconsideracion.end();
		
		TaskInstance analizar = this.findTaskInstanceByNameFromUnfinished("Analizar Reconsideracion");
		assertNotNull(analizar);
		
		analizar.setVariable(JbpmConstants.VariableNames.ESTADO,EstadoProyecto.PEND_ALIC);
		analizar.end();
			
		TaskInstance cerrar = this.findTaskInstanceByNameFromUnfinished("Cerrar Proyecto");
		assertNotNull(cerrar);
		cerrar.end();
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertTrue(processInstance.hasEnded());
	}
	
	public void testCerrarProyectoFinalizarReconsideracionRechazado()
	{
		token.signal();
		// fork, tengo 3 tokens
		
		avanzarProyectoEnPaquete(EstadoProyecto.POS_RECON);
		
		TaskInstance solicitarReconsideracion = this.findTaskInstanceByNameFromUnfinished("Finalizar Posibilidad Reconsideracion");
		solicitarReconsideracion.setVariable(JbpmConstants.VariableNames.ESTADO,EstadoProyecto.CERRADO);
		assertNotNull(solicitarReconsideracion);
		solicitarReconsideracion.end();
							
		TaskInstance cerrar = this.findTaskInstanceByNameFromUnfinished("Cerrar Proyecto");
		assertNull(cerrar);
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertTrue(processInstance.hasEnded());
	}
	
	public void testCerrarProyectoFinalizarReconsideracionNoRechazado()
	{
		token.signal();
		// fork, tengo 3 tokens
		
		avanzarProyectoEnPaquete(EstadoProyecto.POS_RECON);
		
		TaskInstance solicitarReconsideracion = this.findTaskInstanceByNameFromUnfinished("Finalizar Posibilidad Reconsideracion");
		solicitarReconsideracion.setVariable(JbpmConstants.VariableNames.ESTADO,EstadoProyecto.EVALUACION);
		assertNotNull(solicitarReconsideracion);
		solicitarReconsideracion.end();
							
		TaskInstance cerrar = this.findTaskInstanceByNameFromUnfinished("Cerrar Proyecto");
		assertNotNull(cerrar);
		cerrar.end();
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertTrue(processInstance.hasEnded());
	}		
	
	private void avanzarProyectoEnPaquete(EstadoProyecto estado)
	{
		Collection<TaskInstance> unfinished = getUnfinishedTask();
		
		admitir();	
		
		TaskInstance evaluacion = this.findTaskInstanceByNameFromUnfinished("Agregar Evaluación");
		assertNotNull(evaluacion);
		evaluacion.end();
		
		TaskInstance finalizarControl = this.findTaskInstanceByNameFromUnfinished("Finalizar Control");
		assertNotNull(finalizarControl);
		finalizarControl.setVariable(JbpmConstants.VariableNames.ESTADO,estado);
		finalizarControl.end();
	
		//Entro en estado en Paquete -> no puedo cerrar proyecto
		TaskInstance cerrar = this.findTaskInstanceByNameFromUnfinished("Cerrar Proyecto");
		assertNull(cerrar);
		
		// lo saco del estado En Paquete
		Token ppal = processInstance.findToken("principal");
		ppal.signal();
	}
		
	
	private void cerrarProyectoEnPaquete(EstadoProyecto estado)
	{
		avanzarProyectoEnPaquete(estado);
		
		TaskInstance cerrar = this.findTaskInstanceByNameFromUnfinished("Cerrar Proyecto");
		
		assertNotNull(cerrar);
		cerrar.end();
	}
	
	
	@SuppressWarnings("unchecked")
	public void testSignalProcessToEnd()
	{
		token.signal();
		processInstance.suspend();
		processInstance.end();
	}
}

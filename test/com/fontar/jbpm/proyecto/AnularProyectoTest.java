package com.fontar.jbpm.proyecto;

import java.util.Collection;

import org.jbpm.graph.exe.Token;
import org.jbpm.taskmgmt.exe.TaskInstance;

import com.fontar.data.impl.domain.codes.proyecto.EstadoProyecto;
import com.fontar.jbpm.util.JbpmConstants;

/*
 * @author fferrara 
 */

public class AnularProyectoTest extends BaseProyectoTest {
	
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
	public void testAnularProyectoEnEvaluacion()
	{
		
		log.debug("HOLA!");
		
		token.signal();
		// fork, tengo 3 tokens

		Collection<TaskInstance> unfinished = getUnfinishedTask();
				
		for(TaskInstance ti: unfinished)
		{
			// me fijo sobre Anular Proyecto
			if(ti.getName().equalsIgnoreCase("Anular Proyecto"))
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
	public void testAnularProyectoAdmitido()
	{
		token.signal();
		// fork, tengo 3 tokens

		admitir();
		
		// traigo tareas no terminadas
		Collection<TaskInstance> unfinished = getUnfinishedTask();
		
		for(TaskInstance ti: unfinished)
		{
			// me fijo sobre Anular Proyecto
			if(ti.getName().equalsIgnoreCase("Anular Proyecto"))
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
	public void testAnularProyectoNoAdmitido()
	{
		token.signal();
		// fork, tengo 3 tokens

		noAdmitir();
		Collection<TaskInstance> unfinished = getUnfinishedTask();
		
		TaskInstance ti = findTaskInstanceByNameFromUnfinished("Anular Proyecto");
		ti.end();
				
		// traigo tareas no terminadas
		unfinished = getUnfinishedTask();
		
		assertTrue(processInstance.hasEnded());
		assertTrue(unfinished.size()==0);
	}	

	
	@SuppressWarnings("unchecked")
	public void testAnularProyectoConPrimeraEvaluacion()
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
		
		// Entro en estado en Paquete -> no puedo Anular Proyecto
		TaskInstance anular = this.findTaskInstanceByNameFromUnfinished("Anular Proyecto");
		assertNull(anular);
		
		assertFalse(processInstance.hasEnded());
	}	
	
	@SuppressWarnings("unchecked")
	public void testAnularProyectoFirmaContrato()
	{
		token.signal();
		// fork, tengo 3 tokens
			
		anularProyectoEnPaquete(EstadoProyecto.ADJUDICADO);
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertTrue(processInstance.hasEnded());
	}	

	@SuppressWarnings("unchecked")
	public void testAnularProyectoReconsideracion()
	{
		token.signal();
		// fork, tengo 3 tokens
			
		anularProyectoEnPaquete(EstadoProyecto.POS_RECON);
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertTrue(processInstance.hasEnded());
	}	
	
	@SuppressWarnings("unchecked")
	public void testAnularProyectoCargarAlicuota()
	{
		token.signal();
		// fork, tengo 3 tokens
		
		anularProyectoEnPaquete(EstadoProyecto.PEND_ALIC);
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertTrue(processInstance.hasEnded());
	}
	
	private void anularProyectoEnPaquete(EstadoProyecto estado)
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
		
		// Entro en estado en Paquete -> no puedo Anular Proyecto
		TaskInstance anular = this.findTaskInstanceByNameFromUnfinished("Anular Proyecto");
		assertNull(anular);
		
		// lo saco del estado En Paquete
		Token ppal = processInstance.findToken("principal");
		ppal.signal();
		
		//	Entro en estado en Paquete -> no puedo Anular Proyecto
		anular = this.findTaskInstanceByNameFromUnfinished("Anular Proyecto");
		assertNotNull(anular);
		anular.end();
	}
	
	@SuppressWarnings("unchecked")
	public void testSignalProcessToEnd()
	{
		token.signal();
		processInstance.suspend();
		processInstance.end();
	}
}

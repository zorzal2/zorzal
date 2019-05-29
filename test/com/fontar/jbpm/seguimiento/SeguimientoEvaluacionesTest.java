package com.fontar.jbpm.seguimiento;

import java.util.ArrayList;
import java.util.Collection;

import com.fontar.data.impl.domain.codes.seguimiento.EstadoSeguimiento;

/**
 * Unit test de evaluaciones de <code>Seguimiento</code>.<br> 
 * @author ssanchez
 */
public class SeguimientoEvaluacionesTest extends BaseSeguimientoTest {

	/**
	 * Aprueban el <strong>Seguimiento</strong> No Financiero 
	 * en <i>Finalizar Control</i>. Esto produce que se finalice
	 * el Workflow en el decision <i>¿Es Financiero?</i>.
	 */
	public void testAprobarSeguimientoNoFinanciero() {
		
		token.signal();

		cargarPrimeraEvaluacion();
		
		existenTareasAbiertas();

		processInstance.getContextInstance().setVariable(ES_FINANCIERO,FALSE);
		
		finalizarControl(EstadoSeguimiento.CONTROLADO);
		
		noExistenTareasAbiertas();
	}	
	
	/**
	 * Evalua para Autorización el <code>Seguimiento</code>,
	 * lo Autoriza pateando el token hacia el
	 * task-node <i>Evaluar Gestion De Pago</i>.<br>
	 */
	@SuppressWarnings("unchecked")
	public void testAutorizarEvaluarAutorizacionDePago() {
		
		token.signal();

		cargarPrimeraEvaluacion();
		
		processInstance.getContextInstance().setVariable(ES_FINANCIERO,TRUE);

		finalizarControl(EstadoSeguimiento.CONTROLADO);
		
		existenTareasAbiertas();
		
		evaluarAutorizacionPago(EstadoSeguimiento.AUTORIZADO);
		
		Collection<String> lista = new ArrayList();
		lista.add(TASK_EVALUAR_GESTION_PAGO);
		lista.add(TASK_ANULAR);
		lista.add(TASK_CERRAR);
		tareasAbiertas(lista);
	}	
	
	/**
	 * Evalua para Autorización el <code>Seguimiento</code>,
	 * NO lo Autoriza pateando el token hacia el
	 * task-node <i>Cerrar</i>.<br>
	 */
	@SuppressWarnings("unchecked")
	public void testNoAutorizarEvaluarAutorizacionDePago() {
		
		token.signal();

		cargarPrimeraEvaluacion();
		
		processInstance.getContextInstance().setVariable(ES_FINANCIERO,TRUE);

		finalizarControl(EstadoSeguimiento.CONTROLADO);
		
		existenTareasAbiertas();
		
		evaluarAutorizacionPago(EstadoSeguimiento.NO_AUTORIZADO);
		
		Collection<String> lista = new ArrayList();
		lista.add(TASK_CERRAR);
		lista.add(TASK_ANULAR);
		lista.add(TASK_PRIMERA_EVALUACION);
		tareasAbiertas(lista);
	}	

	
	/**
	 * Termina la tarea <i>Evaluar Gestion De Pago</i>
	 * con el estado del seguimiento en <i>Gestionado</i>
	 * finalizando el workflow.<br>
	 */
	public void testEvaluarGestionDePagoGestion() {
		
		token.signal();

		cargarPrimeraEvaluacion();
		
		processInstance.getContextInstance().setVariable(ES_FINANCIERO,TRUE);

		finalizarControl(EstadoSeguimiento.CONTROLADO);
		
		existenTareasAbiertas();
		
		evaluarAutorizacionPago(EstadoSeguimiento.AUTORIZADO);
		
		existenTareasAbiertas();
		
		evaluarGestionPago(EstadoSeguimiento.GESTIONADO);
		
		noExistenTareasAbiertas();
	}
	
	/**
	 * Termina la tarea <i>Evaluar Gestion De Pago</i>
	 * con el estado del seguimiento en <i>No Gestionado</i>
	 * finalizando el workflow.<br>
	 */
	public void testEvaluarGestionDePagoNoGestion() {
		
		token.signal();

		cargarPrimeraEvaluacion();
		
		processInstance.getContextInstance().setVariable(ES_FINANCIERO,TRUE);

		finalizarControl(EstadoSeguimiento.CONTROLADO);
		
		existenTareasAbiertas();
		
		evaluarAutorizacionPago(EstadoSeguimiento.AUTORIZADO);
		
		existenTareasAbiertas();
		
		evaluarGestionPago(EstadoSeguimiento.NO_GESTIONADO);
		
		noExistenTareasAbiertas();
	}		
	
	/**
	 * Termina la tarea <i>Evaluar Gestion De Pago</i>
	 * con el estado del seguimiento en <i>Evaluacion</i>
	 * quedando nuevamente el seguimiento para evaluar.<br>
	 */
	@SuppressWarnings("unchecked")
	public void testEvaluarGestionDePagoRevaluar() {
		
		token.signal();

		cargarPrimeraEvaluacion();
		
		processInstance.getContextInstance().setVariable(ES_FINANCIERO,TRUE);

		finalizarControl(EstadoSeguimiento.CONTROLADO);
		
		existenTareasAbiertas();
		
		evaluarAutorizacionPago(EstadoSeguimiento.AUTORIZADO);
		
		existenTareasAbiertas();
		
		evaluarGestionPago(EstadoSeguimiento.EVALUACION);
		
		Collection<String> lista = new ArrayList();
		lista.add(TASK_CERRAR);
		lista.add(TASK_ANULAR);
		lista.add(TASK_PRIMERA_EVALUACION);
		tareasAbiertas(lista);
	}		
}

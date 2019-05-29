package com.fontar.jbpm.seguimiento;

import com.fontar.data.impl.domain.codes.seguimiento.EstadoSeguimiento;

/**
 * Unit test de anulación de <code>Seguimiento</code>.<br> 
 * @author ssanchez
 */
public class SeguimientoAnularTest extends BaseSeguimientoTest {

	/**
	 * Anula el <strong>Seguimiento</strong> en el primer task-node 
	 * <i>Agregar Primera Evaluación</i>.
	 */
	public void testAnularEnAgregarPrimeraEvaluacion() {
		
		token.signal();
		
		existenTareasAbiertas();
		
		anular();
		
		noExistenTareasAbiertas();
	}
	
	/**
	 * Anula el <strong>Seguimiento</strong> 
	 * en el task-node <i>Finalización de Control</i>.
	 */
	public void testAnularEnFinalizarControl() {
		
		token.signal();

		cargarPrimeraEvaluacion();
		
		existenTareasAbiertas();
		
		anular();
		
		noExistenTareasAbiertas();
	}		
	
	/**
	 * Anula el <strong>Seguimiento</strong> 
	 * en el task-node <i>Evaluar Autorización De Pago</i>.
	 */
	public void testAnularEnEvaluarAutorizacionDePago() {
		
		token.signal();

		cargarPrimeraEvaluacion();
		
		existenTareasAbiertas();
		
		processInstance.getContextInstance().setVariable(ES_FINANCIERO,TRUE);
		
		finalizarControl(EstadoSeguimiento.CONTROLADO);
		
		anular();
		
		noExistenTareasAbiertas();
	}	
	
	/**
	 * Anula el <strong>Seguimiento</strong> en el primer task-node 
	 * <i>Agregar Primera Evaluación</i> despues de haber bajado hasta
	 * el <code>Decision</code> <i>¿Autorizado?</i>.
	 */
	public void testAnularSeguimientoNoAutorizadoEnAgregarPrimeraEvaluacion() {
		
		token.signal();

		cargarPrimeraEvaluacion();
		
		processInstance.getContextInstance().setVariable(ES_FINANCIERO,TRUE);

		finalizarControl(EstadoSeguimiento.CONTROLADO);
		
		existenTareasAbiertas();
		
		evaluarAutorizacionPago(EstadoSeguimiento.NO_AUTORIZADO);
		
		existenTareasAbiertas();

		anular();
		
		noExistenTareasAbiertas();
	}
	
	/**
	 * Anula el <strong>Seguimiento</strong> en el task-node 
	 * <i>Finalizar Control</i> despues de haber bajado hasta
	 * el <code>Decision</code> <i>¿Autorizado?</i>.
	 */
	public void testAnularSeguimientoNoAutorizadoEnFinalizarControl() {
		
		token.signal();

		cargarPrimeraEvaluacion();
		
		processInstance.getContextInstance().setVariable(ES_FINANCIERO,TRUE);

		finalizarControl(EstadoSeguimiento.CONTROLADO);
		
		existenTareasAbiertas();
		
		evaluarAutorizacionPago(EstadoSeguimiento.NO_AUTORIZADO);
		
		existenTareasAbiertas();
		
		cargarPrimeraEvaluacion();

		existenTareasAbiertas();

		anular();

		noExistenTareasAbiertas();
	}	
}

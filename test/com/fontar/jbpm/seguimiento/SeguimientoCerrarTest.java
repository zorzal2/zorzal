package com.fontar.jbpm.seguimiento;

import com.fontar.data.impl.domain.codes.seguimiento.EstadoSeguimiento;

/**
 * Unit test de cerrado de <code>Seguimiento</code>.<br> 
 * @author ssanchez
 */
public class SeguimientoCerrarTest extends BaseSeguimientoTest {

	/**
	 * Cierra el <strong>Seguimiento</strong> en el primer task-node 
	 * <i>Agregar Primera Evaluación</i>.
	 */
	public void testCerrarEnAgregarPrimeraEvaluacion() {
		
		token.signal();
		
		existenTareasAbiertas();
		
		cerrar();
		
		noExistenTareasAbiertas();
	}
	
	/**
	 * Cierra el <strong>Seguimiento</strong> 
	 * en el task-node <i>Finalización de Control</i>.
	 */
	public void testCerrarEnFinalizarControl() {
		
		token.signal();

		cargarPrimeraEvaluacion();
		
		existenTareasAbiertas();
		
		cerrar();
		
		noExistenTareasAbiertas();
	}		
	
	/**
	 * Cierra el <strong>Seguimiento</strong> 
	 * en el task-node <i>Evaluar Autorización De Pago</i>.
	 */
	public void testCerrarEnEvaluarAutorizacionDePago() {
		
		token.signal();

		cargarPrimeraEvaluacion();
		
		existenTareasAbiertas();
		
		processInstance.getContextInstance().setVariable(ES_FINANCIERO,TRUE);
		
		finalizarControl(EstadoSeguimiento.CONTROLADO);
		
		cerrar();
		
		noExistenTareasAbiertas();
	}	
	
	/**
	 * Cierra el <strong>Seguimiento</strong> en el primer task-node 
	 * <i>Agregar Primera Evaluación</i> despues de haber bajado hasta
	 * el <code>Decision</code> <i>¿Autorizado?</i>.
	 */
	public void testCerrarSeguimientoNoAutorizadoEnAgregarPrimeraEvaluacion() {
		
		token.signal();

		cargarPrimeraEvaluacion();
		
		processInstance.getContextInstance().setVariable(ES_FINANCIERO,TRUE);

		finalizarControl(EstadoSeguimiento.CONTROLADO);
		
		existenTareasAbiertas();
		
		evaluarAutorizacionPago(EstadoSeguimiento.NO_AUTORIZADO);
		
		existenTareasAbiertas();

		cerrar();
		
		noExistenTareasAbiertas();
	}
	
	/**
	 * Cierra el <strong>Seguimiento</strong> en el task-node 
	 * <i>Finalizar Control</i> despues de haber bajado hasta
	 * el <code>Decision</code> <i>¿Autorizado?</i>.
	 */
	public void testCerrarSeguimientoNoAutorizadoEnFinalizarControl() {
		
		token.signal();

		cargarPrimeraEvaluacion();
		
		processInstance.getContextInstance().setVariable(ES_FINANCIERO,TRUE);

		finalizarControl(EstadoSeguimiento.CONTROLADO);
		
		existenTareasAbiertas();
		
		evaluarAutorizacionPago(EstadoSeguimiento.NO_AUTORIZADO);
		
		existenTareasAbiertas();
		
		cargarPrimeraEvaluacion();

		existenTareasAbiertas();

		cerrar();

		noExistenTareasAbiertas();
	}	
	
	/**
	 * Cierra el <strong>Seguimiento</strong> en el task-node 
	 * <i>Evaluar Gestión De Pago</i>.
	 */
	public void testCerrarSeguimientoEvaluarGestionPago() {
		
		token.signal();

		cargarPrimeraEvaluacion();
		
		processInstance.getContextInstance().setVariable(ES_FINANCIERO,TRUE);

		finalizarControl(EstadoSeguimiento.CONTROLADO);
		
		existenTareasAbiertas();
		
		evaluarAutorizacionPago(EstadoSeguimiento.AUTORIZADO);
		
		existenTareasAbiertas();
		
		cerrar();

		noExistenTareasAbiertas();
	}	
}

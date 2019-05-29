package com.fontar.jbpm.seguimiento;

import com.fontar.data.impl.domain.codes.seguimiento.EstadoSeguimiento;

/**
 * Unit test de rechazo de <code>Seguimiento</code>.<br> 
 * @author ssanchez
 */
public class SeguimientoRechazarTest extends BaseSeguimientoTest {

	/**
	 * Rechaza el <strong>Seguimiento</strong>
	 * en la tarea <i>Finalizar Control</i>, 
	 * el workflow finaliza.
	 */
	public void testRechazarSeguimiento() {
		
		token.signal();

		cargarPrimeraEvaluacion();
		
		existenTareasAbiertas();
		
		finalizarControl(EstadoSeguimiento.RECHAZADO);

		noExistenTareasAbiertas();
	}	
	
	/**
	 * Rechaza el <strong>Seguimiento</strong>
	 * en la tarea <i>Finalizar Control</i>.<br>
	 * Anteriormente bajo hasta el task-node
	 * <i>Cerrar</i>, se termino la tarea <i>Agregar Evaluación</i>
	 * y en la tarea <i>Finalizar Control</i> se rechazo. 
	 */
	public void testRechazarSeguimientoSinAutorizacion() {
		
		token.signal();

		cargarPrimeraEvaluacion();
		
		processInstance.getContextInstance().setVariable(ES_FINANCIERO,TRUE);

		finalizarControl(EstadoSeguimiento.CONTROLADO);
		
		existenTareasAbiertas();
		
		evaluarAutorizacionPago(EstadoSeguimiento.NO_AUTORIZADO);
		
		existenTareasAbiertas();
		
		cargarPrimeraEvaluacion();

		existenTareasAbiertas();

		finalizarControl(EstadoSeguimiento.RECHAZADO);

		noExistenTareasAbiertas();
	}	
}

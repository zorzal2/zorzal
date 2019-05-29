package com.fontar.jbpm.seguimiento.evaluacion;

import org.jbpm.taskmgmt.exe.TaskInstance;

/**
 * 
 * @author ssanchez
 */
public class ConfirmarResultadoEvaluacionSeguimientoTest extends BaseEvaluacionSeguimientoTest {
	
	/**
	 * Carga primer resultado y luego ejecuta 10 veces la tarea repetitiva de Cargar Resultado
	 *
	 */
	public void testConfirmarResultado(){
		token.signal();
		
		assertEquals(2,this.getUnfinishedTask().size());
		
		TaskInstance cargarResultado = this.findTaskInstanceByNameFromUnfinished(CARGAR_RESULTADO);
		assertNotNull(cargarResultado);
		cargarResultado.end();
		
		assertEquals(2,this.getUnfinishedTask().size());
		assertNotNull(this.findTaskInstanceByNameFromUnfinished(CARGAR_RESULTADO));
		assertNotNull(this.findTaskInstanceByNameFromUnfinished(CONFIRMAR_RESULTADO));

		TaskInstance confirmarResultado = this.findTaskInstanceByNameFromUnfinished(CONFIRMAR_RESULTADO);
		assertNotNull(confirmarResultado);
		confirmarResultado.end();
		
		assertEquals(0,this.getUnfinishedTask().size());
		assertEquals(0,token.getActiveChildren().keySet().size());
		assertTrue(processInstance.hasEnded());
	}
}
package com.fontar.jbpm.seguimiento.evaluacion;

import org.jbpm.graph.def.Node;
import org.jbpm.taskmgmt.exe.TaskInstance;

/**
 * Carga un resultado de evaluacion y comprueba el estado de
 * las tareas existentes abiertas.<br>
 * @author ssanchez
 */
public class CargarResultadoEvaluacionSeguimientoTest extends BaseEvaluacionSeguimientoTest {

	private static Node NODE_CARGAR_RESULTADO = processDefinition.getNode("Cargar Resultado");
	
	/**
	 * Carga el primer resultado desde el nodo 
	 * <code>Pendiente de Resultado</code> y verifica
	 * las tareas abiertas.<br>
	 */
	public void testCargarResultado(){
		
		token.signal();
		
		assertEquals(2,this.getUnfinishedTask().size());
		
		TaskInstance cargarResultado = this.findTaskInstanceByNameFromUnfinished(CARGAR_RESULTADO);
		assertNotNull(cargarResultado);
		cargarResultado.end();
		
		assertEquals(2,this.getUnfinishedTask().size());
		assertNotNull(this.findTaskInstanceByNameFromUnfinished(CARGAR_RESULTADO));
		assertNotNull(this.findTaskInstanceByNameFromUnfinished(CONFIRMAR_RESULTADO));
	}
	
	/**
	 * Carga varias veces el resultado desde el nodo
	 * <code>Cargar Resultado</code> y verifica
	 * las tareas abiertas.
	 */
	public void testLoopCargarResultado(){
		
		token.signal();
		
		assertEquals(2,this.getUnfinishedTask().size());
		
		TaskInstance cargarResultado = this.findTaskInstanceByNameFromUnfinished(CARGAR_RESULTADO);
		assertNotNull(cargarResultado);
		cargarResultado.end();
		
		assertEquals(2,this.getUnfinishedTask().size());
		assertNotNull(this.findTaskInstanceByNameFromUnfinished(CARGAR_RESULTADO));
		assertNotNull(this.findTaskInstanceByNameFromUnfinished(CONFIRMAR_RESULTADO));
		
		for(int i=0; i<10 ; i++){
			TaskInstance cargarResultadoLoop = this.findTaskInstanceByNameFromUnfinished(CARGAR_RESULTADO);
			assertNotNull(cargarResultadoLoop);
			assertEquals(cargarResultadoLoop.getToken().getNode(), NODE_CARGAR_RESULTADO);
			cargarResultadoLoop.end();
			
			assertEquals(2,this.getUnfinishedTask().size());
			assertNotNull(this.findTaskInstanceByNameFromUnfinished(CARGAR_RESULTADO));
			assertNotNull(this.findTaskInstanceByNameFromUnfinished(CONFIRMAR_RESULTADO));
		}

		assertEquals(2,this.getUnfinishedTask().size());
		assertNotNull(this.findTaskInstanceByNameFromUnfinished(CARGAR_RESULTADO));
		assertNotNull(this.findTaskInstanceByNameFromUnfinished(CONFIRMAR_RESULTADO));
	}	
	
}

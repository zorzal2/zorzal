package com.fontar.jbpm.seguimiento.evaluacion;

import org.jbpm.graph.def.ProcessDefinition;

import com.fontar.jbpm.BaseJbpmTest;

/**
 * Test base para los test de unidad de <code>Evaluacion de Seguimiento</code>.<br> 
 * @author ssanchez
 */
public class BaseEvaluacionSeguimientoTest extends BaseJbpmTest {
	
	protected static String CARGAR_RESULTADO = "Cargar Resultado";
	protected static String CONFIRMAR_RESULTADO = "Confirmar resultado";
	protected static String ANULAR = "Anular";
	
	protected static String NOMBRE_NODO_FINAL_ANULADA = "Anulada";
	protected static String NOMBRE_NODO_FINAL_CONFIRMADA = "Confirmada";
	
	static {
		processDefinition = ProcessDefinition.parseXmlResource("com/fontar/jbpm/process/EvaluacionSeguimiento.par/processdefinition.xml");
	}
}

package com.fontar.jbpm.seguimiento;

import java.util.Collection;

import org.jbpm.graph.def.Node;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.taskmgmt.exe.TaskInstance;

import com.fontar.data.impl.domain.codes.seguimiento.EstadoSeguimiento;
import com.fontar.jbpm.BaseJbpmTest;
import com.fontar.jbpm.util.JbpmConstants;

/**
 * Unit test base para <code>Seguimiento</code>.<br>
 * @author ssanchez
 */
public class BaseSeguimientoTest extends BaseJbpmTest {
	
	protected static String TASK_ANULAR = "Anular";	
	protected static String TASK_PRIMERA_EVALUACION = "Agregar Evaluación";
	protected static String TASK_EVALUACION = "Agregar Evaluación";
	protected static String TASK_FINALIZAR_CONTROL = "Finalizar Control";
	protected static String TASK_EVALUAR_AUTORIZACION_PAGO = "Evaluar Autorización de Pago";
	protected static String TASK_EVALUAR_GESTION_PAGO = "Evaluar Gestion de Pago";
	protected static String TASK_CERRAR = "Cerrar";
	
	protected static Node NODO_ANULAR;
	protected static Node NODO_AGREGAR_PRIMERA_EVALUACION;
	protected static Node NODO_AGREGAR_EVALUACION;
	protected static Node NODO_FINALIZAR_CONTROL;
	protected static Node NODO_EVALUAR_AUTORIZACION_PAGO;
	protected static Node NODO_EVALUAR_GESTION_PAGO;
	protected static Node NODO_CERRAR;
	
	protected static String ANULANDO_SEGUIMIENTO = "ANULANDO_SEGUIMIENTO";
	protected static String CERRANDO_SEGUIMIENTO = "CERRANDO_SEGUIMIENTO";
	protected static String SI = "SI";
	protected static String NO = "NO";
	protected static String ES_FINANCIERO = "ES_FINANCIERO";
	protected static String TRUE = "true";
	protected static String FALSE = "false";
	
	static {
		processDefinition = ProcessDefinition.parseXmlResource("com/fontar/jbpm/process/Seguimiento.par/processdefinition.xml");		

		NODO_ANULAR = processDefinition.getNode("Cerrar - Anular");
		NODO_AGREGAR_PRIMERA_EVALUACION = processDefinition.getNode("Agregar Primera Evaluación");
		NODO_FINALIZAR_CONTROL = processDefinition.getNode("Finalizar Control");
		NODO_AGREGAR_EVALUACION = processDefinition.getNode("Agregar Evaluación");
		NODO_EVALUAR_AUTORIZACION_PAGO = processDefinition.getNode("Evaluar Autorización De Pago");
		NODO_EVALUAR_GESTION_PAGO = processDefinition.getNode("Evaluar Gestión De Pago");
		NODO_CERRAR = processDefinition.getNode("Cerrar");
	}
	
	protected void existenTareasAbiertas() {
		
		assertFalse(processInstance.hasEnded());
		
		assertNotSame(this.getUnfinishedTask().size(), 0);
		
	}

	protected void noExistenTareasAbiertas() {
		
		assertTrue(processInstance.hasEnded());
		
		assertSame(this.getUnfinishedTask().size(), 0);
		
	}

	protected void tareasAbiertas(Collection listaTareas) {

		assertFalse(processInstance.hasEnded());

		Collection<TaskInstance> unfinished = this.getUnfinishedTask();
		
		assertNotSame(unfinished.size(), 0);
		
		for (TaskInstance tarea : unfinished) {
			assertTrue(listaTareas.contains(tarea.getName()));
		}		
		
	}
	
	protected void cerrar() {
		
		TaskInstance cerrar = findTaskInstanceByNameFromUnfinished(TASK_CERRAR);
		
		assertNotNull(cerrar);		

		assertSame(cerrar.getToken().getNode(), NODO_ANULAR);
		
		cerrar.setVariable(CERRANDO_SEGUIMIENTO,SI);
		
		cerrar.end();
	}
	
	protected void anular() {
		
		TaskInstance anular = findTaskInstanceByName(this.getUnfinishedTask(), TASK_ANULAR);

		assertNotNull(anular);

		assertSame(anular.getToken().getNode(), NODO_ANULAR);

		anular.setVariable(ANULANDO_SEGUIMIENTO, SI);
		
		anular.end();
	}

	protected void cargarPrimeraEvaluacion() {
		
		TaskInstance cargarPrimeraEvaluacion = findTaskInstanceByNameFromUnfinished(TASK_PRIMERA_EVALUACION);

		assertNotNull(cargarPrimeraEvaluacion);
		
		assertSame(cargarPrimeraEvaluacion.getToken().getNode(), NODO_AGREGAR_PRIMERA_EVALUACION);

		cargarPrimeraEvaluacion.end();

	}	
	
	protected void finalizarControl(EstadoSeguimiento estado) {
		
		TaskInstance finalizarControl = findTaskInstanceByName(this.getUnfinishedTask(), TASK_FINALIZAR_CONTROL);

		assertNotNull(finalizarControl);

		assertSame(finalizarControl.getToken().getNode(), NODO_FINALIZAR_CONTROL);
		
		finalizarControl.setVariable(JbpmConstants.VariableNames.ESTADO,estado);

		finalizarControl.end();
	}

	protected void evaluarAutorizacionPago(EstadoSeguimiento estado) {

		TaskInstance evaluarAutorizacionPago = findTaskInstanceByNameFromUnfinished(TASK_EVALUAR_AUTORIZACION_PAGO);

		assertNotNull(evaluarAutorizacionPago);
		
		assertSame(evaluarAutorizacionPago.getToken().getNode(), NODO_EVALUAR_AUTORIZACION_PAGO);

		evaluarAutorizacionPago.setVariable(JbpmConstants.VariableNames.ESTADO,estado);
		
		evaluarAutorizacionPago.end();
	}
	
	public void evaluarGestionPago(EstadoSeguimiento estado) {
		
		TaskInstance evaluarGestionPago = findTaskInstanceByNameFromUnfinished(TASK_EVALUAR_GESTION_PAGO);
		
		assertNotNull(evaluarGestionPago);

		assertSame(evaluarGestionPago.getToken().getNode(), NODO_EVALUAR_GESTION_PAGO);

		evaluarGestionPago.setVariable(JbpmConstants.VariableNames.ESTADO,estado);
		
		evaluarGestionPago.end();
	}
}

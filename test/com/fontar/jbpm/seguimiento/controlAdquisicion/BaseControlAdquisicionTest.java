package com.fontar.jbpm.seguimiento.controlAdquisicion;

import java.util.Collection;

import org.jbpm.graph.def.Node;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.taskmgmt.exe.TaskInstance;

import com.fontar.jbpm.BaseJbpmTest;
import com.fontar.jbpm.util.JbpmConstants;

/**
 * Unit test base para <code>ControlAdquisicion</code>.<br>
 * @author ssanchez
 */
public class BaseControlAdquisicionTest extends BaseJbpmTest {
	
	protected static String TASK_DESIGNAR_EVALUADOR_TECNICO = "Designar Evaluador Técnico";	
	protected static String TASK_CARGAR_FUNDAMENTACION_EVALUADOR = "Cargar Fundamentación Evaluador";
	protected static String TASK_CARGAR_RESULTADO = "Cargar Resultado";
	protected static String TASK_REMITIR_A_UFFA = "Remitir a UFFA";
	protected static String TASK_REMITIR_A_BID = "Remitir a BID";
	protected static String TASK_CARGAR_RESULTADO_UFFA = "Cargar Resultado UFFA";
	protected static String TASK_CARGAR_RESULTADO_BID = "Cargar Resultado BID";
	protected static String TASK_GENERAR_PEDIDO_AUTORIZACION = "Generar Pedido Autorización";
	
	protected static Node NODO_DESIGNAR_EVALUADOR_TECNICO;	
	protected static Node NODO_CARGAR_FUNDAMENTACIÓN_EVALUADOR;
	protected static Node NODO_CARGAR_RESULTADO;
	protected static Node NODO_REMITIR_A_UFFA;
	protected static Node NODO_REMITIR_A_BID;
	protected static Node NODO_CARGAR_RESULTADO_UFFA;
	protected static Node NODO_CARGAR_RESULTADO_BID;
	protected static Node NODO_GENERAR_PEDIDO_AUTORIZACION;
	
	protected static String SI = "SI";
	protected static String NO = "NO";
	protected static String TRUE = "true";
	protected static String FALSE = "false";
	
	static {
		processDefinition = ProcessDefinition.parseXmlResource("com/fontar/jbpm/process/ControlAdquisicion.par/processdefinition.xml");		

		NODO_DESIGNAR_EVALUADOR_TECNICO = processDefinition.getNode("Designar Evaluador Técnico");	
		NODO_CARGAR_FUNDAMENTACIÓN_EVALUADOR = processDefinition.getNode("Cargar Fundamentación Evaluador");
		NODO_CARGAR_RESULTADO = processDefinition.getNode("Cargar Resultado");
		NODO_REMITIR_A_UFFA = processDefinition.getNode("Remitir a UFFA");
		NODO_REMITIR_A_BID = processDefinition.getNode("Remitir a BID");
		NODO_CARGAR_RESULTADO_UFFA = processDefinition.getNode("Cargar Resultado UFFA");
		NODO_CARGAR_RESULTADO_BID = processDefinition.getNode("Cargar Resultado BID");
		NODO_GENERAR_PEDIDO_AUTORIZACION = processDefinition.getNode("Generar Pedido Autorización");
	}
	
	protected void validarHayTareasAbiertas() {
		
		assertFalse(processInstance.hasEnded());
		
		assertNotSame(this.getUnfinishedTask().size(), 0);
		
	}

	protected void validarNoHayTareasAbiertas() {
		
		assertTrue(processInstance.hasEnded());
		
		assertSame(this.getUnfinishedTask().size(), 0);
		
	}

	protected void validarListadoTareasAbiertas(Collection<String> listaTareas) {

		assertFalse(processInstance.hasEnded());

		Collection<TaskInstance> unfinished = this.getUnfinishedTask();
		
		assertNotSame(unfinished.size(), 0);
		
		for (TaskInstance tarea : unfinished) {
			assertTrue(listaTareas.contains(tarea.getName()));
		}		
		
	}

	protected void designarEvaluadorTecnico() {
		
		TaskInstance designarEvaluador = findTaskInstanceByNameFromUnfinished(TASK_DESIGNAR_EVALUADOR_TECNICO);

		assertNotNull(designarEvaluador);
		assertSame(designarEvaluador.getToken().getNode(), NODO_DESIGNAR_EVALUADOR_TECNICO);

		designarEvaluador.end();
	}	

	protected void cargarFundamentacionEvaluador() {
		
		TaskInstance cargarFundamentacionEvaluador = findTaskInstanceByNameFromUnfinished(TASK_CARGAR_FUNDAMENTACION_EVALUADOR);

		assertNotNull(cargarFundamentacionEvaluador);
		assertSame(cargarFundamentacionEvaluador.getToken().getNode(), NODO_CARGAR_FUNDAMENTACIÓN_EVALUADOR);

		cargarFundamentacionEvaluador.end();
	}	
	
	protected void cargarResultado(Boolean conItemsUffa, Boolean conItemsBid) {
		
		TaskInstance cargarResultado = findTaskInstanceByNameFromUnfinished(TASK_CARGAR_RESULTADO);

		assertNotNull(cargarResultado);
		assertSame(cargarResultado.getToken().getNode(), NODO_CARGAR_RESULTADO);

		cargarResultado.setVariable(JbpmConstants.VariableNames.CON_ITEMS_UFFA,conItemsUffa);
		cargarResultado.setVariable(JbpmConstants.VariableNames.CON_ITEMS_BID,conItemsBid);
		cargarResultado.setVariable(JbpmConstants.VariableNames.CON_ITEMS_PLIEGO_PRECLASIFICACION,false);
		
		cargarResultado.end();
	}	
	
	protected void remitirUffa() {
		
		TaskInstance remitirUffa = findTaskInstanceByNameFromUnfinished(TASK_REMITIR_A_UFFA);

		assertNotNull(remitirUffa);
		assertSame(remitirUffa.getToken().getNode(), NODO_REMITIR_A_UFFA);

		remitirUffa.end();
	}
	
	protected void remitirBid() {
		
		TaskInstance remitirBid = findTaskInstanceByNameFromUnfinished(TASK_REMITIR_A_BID);

		assertNotNull(remitirBid);
		assertSame(remitirBid.getToken().getNode(), NODO_REMITIR_A_BID);

		remitirBid.end();
	}	

	protected void remitirUffaYBid() {
		remitirBid();
		remitirUffa();
	}
	
	protected void cargarResultadoUffa(Boolean conItemsPliegoOPreClasificacion) {
		
		TaskInstance cargarResultadoUffa = findTaskInstanceByNameFromUnfinished(TASK_CARGAR_RESULTADO_UFFA);

		assertNotNull(cargarResultadoUffa);
		assertSame(cargarResultadoUffa.getToken().getNode(), NODO_CARGAR_RESULTADO_UFFA);
		
		cargarResultadoUffa.setVariable(JbpmConstants.VariableNames.CON_ITEMS_PLIEGO_PRECLASIFICACION,conItemsPliegoOPreClasificacion);

		cargarResultadoUffa.end();
	}	

	protected void cargarResultadoBid(Boolean conItemsPliegoOPreClasificacion) {
		
		TaskInstance cargarResultadoBid = findTaskInstanceByNameFromUnfinished(TASK_CARGAR_RESULTADO_BID);

		assertNotNull(cargarResultadoBid);
		assertSame(cargarResultadoBid.getToken().getNode(), NODO_CARGAR_RESULTADO_BID);
		
		cargarResultadoBid.setVariable(JbpmConstants.VariableNames.CON_ITEMS_PLIEGO_PRECLASIFICACION,conItemsPliegoOPreClasificacion);

		cargarResultadoBid.end();
	}
	
	protected void cargarResultadoUffaYBid(Boolean conItemsPliegoOPreClasificacion) {
		cargarResultadoUffa(conItemsPliegoOPreClasificacion);
		cargarResultadoBid(conItemsPliegoOPreClasificacion);
	}
	
	protected void generarPedidoAutorizacion() {
		
		TaskInstance generarPedidoAutorizacion = findTaskInstanceByNameFromUnfinished(TASK_GENERAR_PEDIDO_AUTORIZACION);

		assertNotNull(generarPedidoAutorizacion);
		assertSame(generarPedidoAutorizacion.getToken().getNode(), NODO_GENERAR_PEDIDO_AUTORIZACION);
		
		generarPedidoAutorizacion.end();
	}
}

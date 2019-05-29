package com.fontar.jbpm.paqueteDirectorio;

import java.util.ArrayList;

import org.jbpm.graph.def.Node;
import org.jbpm.graph.def.ProcessDefinition;

import com.fontar.jbpm.BaseJbpmTest;
import com.fontar.jbpm.util.JbpmConstants;

public class BasePaqueteTest extends BaseJbpmTest {
	
	protected static String TASK_ANULAR = "Anular Paquete";
	protected static String TASK_EVALUAR = "Evaluar Paquete";
	protected static String TASK_CONFIMAR = "Confirmar Paquete";
	protected static String TASK_EDITAR = "Modificar Paquete";
	protected static String TASK_CONTROLAR = "Controlar Paquete";
	
	protected static Node ANULAR;
	protected static Node CARGAR_EVALUACION;
	protected static Node CONFIRMAR;
	protected static Node CONTROLAR;
	
	static {
		processDefinition = ProcessDefinition.parseXmlResource("com/fontar/jbpm/process/PaqueteDirectorio.par/processdefinition.xml");
		
		ANULAR = processDefinition.getNode("Anular");
		CARGAR_EVALUACION = processDefinition.getNode("Cargar Evaluacion");
		CONFIRMAR = processDefinition.getNode("Confirmar Paquete");
		CONTROLAR = processDefinition.getNode("Controlar por Directorio");
	}
	
	@Override
	public void setUp() {
		// TODO Auto-generated method stub
		super.setUp();
		processInstance.getContextInstance().setVariable(JbpmConstants.VariableNames.ID_PROCESO_PROYECTOS, new ArrayList());
	}
}

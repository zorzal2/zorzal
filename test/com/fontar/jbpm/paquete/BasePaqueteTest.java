package com.fontar.jbpm.paquete;

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
	
	protected static Node ANULAR;
	protected static Node PENDIENTE_AUTORIZACION;
	
	static {
		processDefinition = ProcessDefinition.parseXmlResource("com/fontar/jbpm/process/Paquete.par/processdefinition.xml");
		ANULAR = processDefinition.getNode("Anular");
		PENDIENTE_AUTORIZACION = processDefinition.getNode("Pendiente Autorizacion");
	}

	@Override
	public void setUp() {
		// TODO Auto-generated method stub
		super.setUp();
		processInstance.getContextInstance().setVariable(JbpmConstants.VariableNames.ID_PROCESO_PROYECTOS, new ArrayList());
	}
	
	
}

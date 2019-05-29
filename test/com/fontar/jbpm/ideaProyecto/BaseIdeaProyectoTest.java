package com.fontar.jbpm.ideaProyecto;

import org.jbpm.graph.def.ProcessDefinition;

import com.fontar.jbpm.BaseJbpmTest;

public class BaseIdeaProyectoTest extends BaseJbpmTest {
	
	protected static String TASK_EVALUAR_PRIMERA = "Cargar Primera Evaluacion";
	protected static String TASK_JUNTA = "Evaluar Por Junta";
	protected static String TASK_EVALUAR = "Agregar Evaluacion";
	protected static String TASK_CERRAR = "Cerrar Proyecto";
	protected static String TASK_ANULAR = "Anular Proyecto";
	protected static String TASK_CARGAR_PROYECTO = "Cargar Proyecto";
	protected static String TASK_RECONSIDERAR = "Reconsiderar";
			
	static {
		processDefinition = ProcessDefinition.parseXmlResource("com/fontar/jbpm/process/IdeaProyecto.par/processdefinition.xml");
	}
}

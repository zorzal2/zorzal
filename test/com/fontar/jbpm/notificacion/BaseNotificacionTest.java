package com.fontar.jbpm.notificacion;

import org.jbpm.graph.def.ProcessDefinition;

import com.fontar.jbpm.BaseJbpmTest;

public class BaseNotificacionTest extends BaseJbpmTest {
	
	protected static String ENVIAR_NOTIFICACION = "Enviar Notificacion";
	protected static String CERRAR_PROYECTO = "Cerrar Proyecto";
	protected static String ANULAR_PROYECTO = "Anular Proyecto";
	protected static String RECIBIR_ACUSE = "Recibir Acuse";
			
	static {
		processDefinition = ProcessDefinition.parseXmlResource("com/fontar/jbpm/process/Notificacion.par/processdefinition.xml");
	}
}

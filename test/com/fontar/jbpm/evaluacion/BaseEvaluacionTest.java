package com.fontar.jbpm.evaluacion;

import org.jbpm.graph.def.ProcessDefinition;

import com.fontar.jbpm.BaseJbpmTest;

public abstract class BaseEvaluacionTest extends BaseJbpmTest {

	static {
		processDefinition = ProcessDefinition.parseXmlResource("com/fontar/jbpm/process/EvaluacionProyecto.par/processdefinition.xml");
	}
}

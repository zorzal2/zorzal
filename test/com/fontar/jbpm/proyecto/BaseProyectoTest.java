package com.fontar.jbpm.proyecto;

import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.taskmgmt.exe.TaskInstance;

import com.fontar.data.impl.domain.codes.proyecto.EstadoProyecto;
import com.fontar.jbpm.BaseJbpmTest;
import com.fontar.jbpm.util.JbpmConstants;

public abstract class BaseProyectoTest extends BaseJbpmTest {

	static {
		processDefinition = ProcessDefinition.parseXmlResource("com/fontar/jbpm/process/Proyecto.par/processdefinition.xml");
	}
	
	
	@Override
	public void setUp() {
		// TODO Auto-generated method stub
		super.setUp();
		this.processInstance.getContextInstance().setVariable(JbpmConstants.VariableNames.ES_VENTANILLA,"NO");
		this.processInstance.getContextInstance().setVariable(JbpmConstants.VariableNames.ID_INSTRUMENTO,1L);
	}

	protected void admitir() {
		TaskInstance admision = this.findTaskInstanceByNameFromUnfinished("Admision");
		assertNotNull(admision);
		admision.setVariable(JbpmConstants.VariableNames.ESTADO,EstadoProyecto.ADMITIDO);
		admision.end();
	}
	
	protected void noAdmitir() {
		TaskInstance admision = this.findTaskInstanceByNameFromUnfinished("Admision");
		assertNotNull(admision);
		admision.setVariable(JbpmConstants.VariableNames.ESTADO,EstadoProyecto.NO_ADMITIDO);
		admision.end();		
	}
	
}

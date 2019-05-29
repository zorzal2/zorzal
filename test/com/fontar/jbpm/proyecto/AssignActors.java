package com.fontar.jbpm.proyecto;

import java.util.List;

import org.jbpm.JbpmConfiguration;
import org.jbpm.taskmgmt.exe.TaskInstance;

/**
 * @author fferrara
 *
 */
public class AssignActors extends BaseProyectoTest {
	
	@Override
	public void setUp() {
		super.setUp();
		jbpmContext = JbpmConfiguration.getInstance().createJbpmContext();
		jbpmContext.getGraphSession().deployProcessDefinition(processDefinition);
		taskMgmtSession = jbpmContext.getTaskMgmtSession();		
		jbpmContext.save(processInstance);
	}	

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
		jbpmContext.close();
	}

	/**
	 * 
	 *
	 */
	public void testPooledAssignAdmision() {
		token.signal();
		List<TaskInstance> tasks = taskMgmtSession.findPooledTaskInstances("fferrara");
		assertTrue(tasks.size() > 0);
	}
	
	public void testEmptyPooled() {
		token.signal();
		List<TaskInstance> tasks = taskMgmtSession.findPooledTaskInstances("juancarlos");
		assertTrue(tasks.size() == 0);
	}
	
	
}

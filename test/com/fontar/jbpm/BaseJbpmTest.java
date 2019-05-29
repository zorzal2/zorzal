package com.fontar.jbpm;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbpm.JbpmContext;
import org.jbpm.db.TaskMgmtSession;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.graph.exe.Token;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.jbpm.taskmgmt.exe.TaskMgmtInstance;

public abstract class BaseJbpmTest extends TestCase {
	
	// parse the process definition
	protected static ProcessDefinition processDefinition; 
		
	protected TaskMgmtInstance taskMgmt;
	protected JbpmContext jbpmContext;
	
	protected TaskMgmtSession taskMgmtSession;
		
	// the process instance
	protected ProcessInstance processInstance;
	
	// the main path of execution
	protected Token token;
	protected Log log;
	
	
	public void setUp()
	{
		try{
						
			//jbpmContext = JbpmConfiguration.getInstance().createJbpmContext(); 
			//JbpmConfiguration.getInstance().createSchema();
			//jbpmContext.getGraphSession().deployProcessDefinition(auctionProcess);
			
			processInstance = new ProcessInstance(processDefinition);
			//jbpmContext.save(processInstance);
			
			taskMgmt = processInstance.getTaskMgmtInstance();
			token = processInstance.getRootToken();

			log =  LogFactory.getLog(this.getClass());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		
		Collection<TaskInstance> all = getAllTask();
		
		System.out.println("-- Resumen de Tareas --");
		System.out.println();
		for(TaskInstance ti:all)
		{
			System.out.println(ti.toString());
			System.out.println(" Create Date " + ti.getCreate());
			System.out.println(" Start  Date " + ti.getStart());
			System.out.println(" End    Date " + ti.getEnd());
			
			System.out.println(" Open?       " + ti.isOpen());
			System.out.println(" Cancelled?  " + ti.isCancelled());
			
			System.out.println();
		}
		System.out.println("-----------------------");
		
		//jbpmContext.save(processInstance);
	}

	protected TaskInstance findTaskInstanceByName(Collection<TaskInstance> tasks,String name)
	{
		TaskInstance task = null;
		
		for(TaskInstance ti: tasks) {
			if (ti.getName().equalsIgnoreCase(name)){
				task = ti;
				return task;
			}
		}
		return task;
	}
	
	protected TaskInstance findTaskInstanceByNameFromUnfinished(String name)
	{
		Collection<TaskInstance> tasks = getUnfinishedTask();
		return this.findTaskInstanceByName(tasks,name);
	}


	protected Collection<TaskInstance> getUnfinishedTask()
	{
		//return this.getUnfinishedTask(token);
		Collection<TaskInstance> allTask = this.getAllTask();
		Collection<TaskInstance> unfinishedTask = new ArrayList<TaskInstance>();
		
		for(TaskInstance ti: allTask){
			if (ti.isOpen() && !ti.isCancelled()) {
				unfinishedTask.add(ti);
			}
		}
		return unfinishedTask;
	}
	
	@SuppressWarnings("unchecked")
	/**
	 * Devuelve las tareas sin finalizar para el token
	 */
	private Collection<TaskInstance> getUnfinishedTask(Token t)
	{
		Collection<TaskInstance> unfinished = taskMgmt.getUnfinishedTasks(t);
		
		if (token.hasActiveChildren())
		{
			Collection<Token> tokens = token.getActiveChildren().values();
			
			for(Token child:tokens)	{	
				unfinished.addAll(taskMgmt.getUnfinishedTasks(child));
			}
		}
		
		return unfinished;
	}
	
	/**
	 * Devuelve todas las tareas, no interesa si estan abiertas
	 * @return
	 */
	protected Collection<TaskInstance> getAllTask()
	{
		Collection<TaskInstance> all = new ArrayList<TaskInstance>();
		if (taskMgmt.getTaskInstances()!=null) all.addAll(taskMgmt.getTaskInstances());			
		return all;
	}	
}

package com.fontar.bus.impl.domain.junit;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class ServiceBaseTest extends
		AbstractDependencyInjectionSpringContextTests {
	
	@Override
	  protected String[] getConfigLocations() {
	    // TODO Auto-generated method stub
		
	    return new String[] {
	    		"file:"+System.getProperty("user.dir")+ "/webroot/WEB-INF/conf/beans-context-app.xml"
	           };
	    
	  }  

	protected Object getBean(String name) {
		
		return this.applicationContext.getBean(name);
	}

}

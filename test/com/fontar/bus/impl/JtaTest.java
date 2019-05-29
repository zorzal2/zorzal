package com.fontar.bus.impl;

import java.util.List;

import com.fontar.bus.impl.domain.junit.ServiceBaseTest;
import com.fontar.data.api.dao.InstrumentoDAO;

public class JtaTest extends ServiceBaseTest {

	@Override
	protected String[] getConfigLocations() {
	    return new String[] {
	    		"file:"+System.getProperty("user.dir")+ "/webroot/WEB-INF/conf/beans-context-web.xml"
	           };	
	}
	
	public void testDao(){
		InstrumentoDAO instrumentoDao = (InstrumentoDAO)getBean("instrumentoDao");
		List activos = instrumentoDao.findAllActivos();
		assertTrue(true);
		
	}
	
}

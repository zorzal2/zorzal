package com.fontar.bean;

import org.hibernate.Session;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.pragma.util.hibernate.HibernateUtil;

public class CiiuTest extends AbstractDependencyInjectionSpringContextTests {

	
	
	public void testCiiuQuery(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.createQuery("from CiiuBean o where o not in (select c.padre from CiiuBean c and c.padre is not null )");
	}

	 protected String[] getConfigLocations() {
		    // TODO Auto-generated method stub
		    return new String[] {
		    		"C:\\Documents and Settings\\mrouaux\\workspace_fontar\\fontar-web\\webroot" + "\\WEB-INF\\conf\\junit\\applicationContext-hibernate-junit.xml",		   
		    		"C:/Documents and Settings/mrouaux/workspace_fontar/fontar-web/webroot" + "/WEB-INF/conf/junit/services-config-junit.xml", 
		    		"C:/Documents and Settings/mrouaux/workspace_fontar/fontar-web/webroot" + "/WEB-INF/conf/dao-config.xml"
		           };
		  }  
}

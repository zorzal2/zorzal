package com.fontar.seguridad.ldap;

import com.fontar.BaseSpringTest;

public class BaseLdapTest extends BaseSpringTest{

	@Override
	protected String[] getConfigLocations() {
	    return new String[] {
	    		"file:"+System.getProperty("user.dir")+ "/webroot/WEB-INF/conf/seguridad/applicationContext-spring-ldap.xml"
	           };
	}

	
}

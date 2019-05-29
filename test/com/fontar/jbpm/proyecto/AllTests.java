package com.fontar.jbpm.proyecto;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.fontar.jbpm.proyecto");
		//$JUnit-BEGIN$
		suite.addTestSuite(MultipleTaskNodeTest.class);
		suite.addTestSuite(CancelarProyectoTest.class);
		suite.addTestSuite(EnPaqueteTest.class);
		suite.addTestSuite(AnularProyectoTest.class);		
		//$JUnit-END$
		return suite;
	}

}

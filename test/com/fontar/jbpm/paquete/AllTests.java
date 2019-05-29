package com.fontar.jbpm.paquete;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.fontar.jbpm.paquete");
		//$JUnit-BEGIN$
		suite.addTestSuite(AnularPaqueteTest.class);
		suite.addTestSuite(TareasTest.class);
		//$JUnit-END$
		return suite;
	}

}

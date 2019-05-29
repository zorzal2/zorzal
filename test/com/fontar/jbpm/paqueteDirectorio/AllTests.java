package com.fontar.jbpm.paqueteDirectorio;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.fontar.jbpm.paquete.LiberarProyectosTest;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.fontar.jbpm.paqueteDirectorio");
		//$JUnit-BEGIN$
		suite.addTestSuite(AnularPaqueteTest.class);
		suite.addTestSuite(TareasTest.class);
		suite.addTestSuite(LiberarProyectosTest.class);		
		//$JUnit-END$
		return suite;
	}

}

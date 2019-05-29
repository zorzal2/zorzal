package com.fontar.jbpm.ideaProyecto;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.fontar.jbpm.ideaProyecto");
		//$JUnit-BEGIN$
		suite.addTestSuite(AnularIdeaProyectoTest.class);
		suite.addTestSuite(CerrarIdeaProyectoTest.class);
		suite.addTestSuite(EvaluarPorJuntaTest.class);
		suite.addTestSuite(ReconsiderarTest.class);
		suite.addTestSuite(CargarProyectoTest.class);
		//$JUnit-END$
		return suite;
	}

}

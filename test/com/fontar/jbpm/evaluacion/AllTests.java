package com.fontar.jbpm.evaluacion;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.fontar.jbpm.evaluacion");
		//$JUnit-BEGIN$
		suite.addTestSuite(ConfirmarEvaluacionTest.class);
		suite.addTestSuite(AnularEvaluacionTest.class);
		//$JUnit-END$
		return suite;
	}

}

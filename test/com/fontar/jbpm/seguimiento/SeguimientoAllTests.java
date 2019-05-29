package com.fontar.jbpm.seguimiento;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Test suit <code>Seguimiento</code>
 * @author ssanchez
 */
public class SeguimientoAllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.fontar.jbpm.seguimiento");
		suite.addTestSuite(SeguimientoAnularTest.class);
		suite.addTestSuite(SeguimientoCerrarTest.class);
		suite.addTestSuite(SeguimientoEvaluacionesTest.class);
		suite.addTestSuite(SeguimientoRechazarTest.class);
		return suite;
	}

}

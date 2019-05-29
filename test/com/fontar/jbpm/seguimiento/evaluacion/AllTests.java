package com.fontar.jbpm.seguimiento.evaluacion;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.fontar.jbpm.evaluacionSeguimiento");
		suite.addTestSuite(AnularEvaluacionSeguimientoTest.class);
		suite.addTestSuite(CargarResultadoEvaluacionSeguimientoTest.class);
		suite.addTestSuite(ConfirmarResultadoEvaluacionSeguimientoTest.class);
		return suite;
	}

}

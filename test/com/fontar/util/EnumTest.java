package com.fontar.util;

import junit.framework.TestCase;

import com.fontar.data.impl.domain.codes.paquete.TipoPaquete;

public class EnumTest extends TestCase {

	
	public void testValueOfNull(){
		TipoPaquete tp = TipoPaquete.valueOf("COMISION");
		assertNull(tp);
	}
}

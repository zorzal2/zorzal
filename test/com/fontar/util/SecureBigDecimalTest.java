package com.fontar.util;

import java.math.BigDecimal;

import junit.framework.TestCase;

import com.fontar.seguridad.EncryptedObject;
import com.fontar.seguridad.cripto.BigDecimalDecorator;

public class SecureBigDecimalTest extends TestCase {

	
	public void testProxy(){
		BigDecimal bigDecimal = new BigDecimal(100);
		EncryptedObject encryptedObject = new EncryptedObject( bigDecimal, null, false);
		BigDecimal wrapper = new BigDecimalDecorator( encryptedObject );
		System.out.println(wrapper.toString());
	}
}

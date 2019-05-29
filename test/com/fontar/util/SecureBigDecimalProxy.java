package com.fontar.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import com.fontar.seguridad.EncryptedObject;

public class SecureBigDecimalProxy extends BigDecimal implements InvocationHandler {

		private static final long serialVersionUID = 1L;
		
		private EncryptedObject encryptedObject;
		

		private SecureBigDecimalProxy(EncryptedObject object) {
			super(1); //No va a ser usado
			this.encryptedObject = object;
		}


		public static Object newInstance(EncryptedObject object) {
		     
			 return java.lang.reflect.Proxy.newProxyInstance(
		             object.getClass().getClassLoader(),
		             object.getClass().getInterfaces(),
		             new SecureBigDecimalProxy(object));
        }

		
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

			return method.invoke(this.encryptedObject,args);
			
		}
		
		
}
	
	

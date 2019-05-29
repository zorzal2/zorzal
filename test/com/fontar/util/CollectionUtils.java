package com.fontar.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import junit.framework.TestCase;

public class CollectionUtils extends TestCase {

	
	static String [] values  = {"1", "2"};
	
	
	static public String[] getValues(){
			return values;
	}
	
	public void testBuildCollection(){
		Class clazz = CollectionUtils.class;
		try {
			Method method = clazz.getMethod("getValues",new Class[]{});
			String [] values = (String[]) method.invoke(CollectionUtils.class, new Object[]{});
			System.out.println(values);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	} 
}

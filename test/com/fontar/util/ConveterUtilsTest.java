package com.fontar.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import com.fontar.util.bean.DateConverter;

public class ConveterUtilsTest extends TestCase {

	
	public void testString2DateConversion(){
		//Registra el conversot String -> Date
		ConvertUtils.register(new DateConverter(),Date.class);
		
		//Bean con un setter para Date
		DateContainerBean containerBean = new DateContainerBean();
		
		//String correspondiente al date que vamos a setear al bean
		Map properties = new HashMap();
		properties.put("date","1/02/2006");
		
		//Copia la propiedad a containerBean haciendo una conversion del String a Date
		try {
			
			BeanUtils.populate(containerBean,properties);
			Calendar calendar = Calendar.getInstance();
			calendar.set(2007,2,1,0,0,0);
			//Comprobamos que el date se haya seteado correctamente con una comporacion
			TestCase.assertTrue(calendar.getTime().after(containerBean.getDate()));
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public class DateContainerBean {
		
		private Date date;

		public Date getDate() {
			return this.date;
		}

		public void setDate(Date date) {
			this.date = date;
		}
		
	}
}

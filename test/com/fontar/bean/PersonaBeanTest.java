package com.fontar.bean;

import com.fontar.data.Constant;
import com.fontar.data.impl.domain.bean.PersonaBean;


public class PersonaBeanTest extends AbstractBeanTest {

	public PersonaBeanTest() {
		
		super("personaDaoService",new Long(1));		
	}
	
	@Override
	public Object getBeanToSave() {
		
		PersonaBean bean = new PersonaBean();
		bean.setActivo(true);
		bean.setCuit("27-25984444-3");
	    bean.setNombre("perez, ramiro");
	    bean.setEsEvaluador(false);
	    bean.setSexo(Constant.PersonaSexo.FEMENINO);
	    return bean;
	}

	@Override
	public Object modifyBeanToUpdate(Object object) {
		PersonaBean bean = (PersonaBean)object;
		bean.setActivo(false);
		return bean;
	}

}

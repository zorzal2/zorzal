package com.fontar.bean;

import com.fontar.data.impl.domain.bean.EntidadBean;


public class EntidadBeanTest extends AbstractBeanTest {

	public EntidadBeanTest() {
		
		super("entidadDaoService",new Long(1));		
	}
	
	@Override
	public Object getBeanToSave() {
		
		EntidadBean bean = new EntidadBean();
		bean.setActivo(true);
		bean.setCuit("27-25984444-4");
		bean.setDenominacion("Entidad1");
		bean.setEvaluadora(false);
		bean.setBancaria(false);
		bean.setBeneficiaria(false);
		
	    bean.setDenominacion("denominacion");
	    bean.setContacto("contacto: laura pierda");
	    bean.setDescripcion("una descripcion");
	    bean.setIdLocalizacion(new Long(1));
		
		return bean;
	}

	@Override
	public Object modifyBeanToUpdate(Object object) {
		EntidadBean bean = (EntidadBean)object;
		bean.setActivo(false);
		return bean;
	}

}

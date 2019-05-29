package com.fontar.bean;

import com.fontar.data.impl.domain.bean.EntidadBancariaBean;
import com.fontar.data.impl.domain.bean.EntidadBean;

public class EntidadBancariaBeanTest extends AbstractBeanTest {

	private static final int NEW_ID = 6;

	public EntidadBancariaBeanTest() {
		
		super("entidadBancariaDaoService",new Long(NEW_ID));		
	}
	
	@Override
	public Object getBeanToSave() {
		
		EntidadBancariaBean bean = new EntidadBancariaBean();
		
	    EntidadBean entidad = bean.getEntidad();
	    entidad.setIdLocalizacion(new Long(1));
	    entidad.setDenominacion("denominacion BANCARIA");
	    entidad.setCuit("12123456786");
	    System.out.println(entidad.getCuit());
	    entidad.setContacto("contacto: laura pierda");
	    entidad.setActivo(true);
	    entidad.setEvaluadora(false);
	    entidad.setBancaria(true);
	    entidad.setBeneficiaria(false);
	    entidad.setDescripcion("una descripcion");
	    return bean;
	}

	@Override
	public Object modifyBeanToUpdate(Object object) {
		EntidadBancariaBean bean = (EntidadBancariaBean)object;
		return bean;
	}

}

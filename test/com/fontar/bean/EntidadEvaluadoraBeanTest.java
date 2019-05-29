package com.fontar.bean;

import com.fontar.data.impl.domain.bean.EntidadBean;
import com.fontar.data.impl.domain.bean.EntidadEvaluadoraBean;
public class EntidadEvaluadoraBeanTest extends AbstractBeanTest {

	private static final int NEW_ID = 6;

	public EntidadEvaluadoraBeanTest() {
		
		super("entidadEvaluadoraDaoService",new Long(NEW_ID));		
	}
	
	@Override
	public Object getBeanToSave() {
		
		EntidadEvaluadoraBean bean = new EntidadEvaluadoraBean();
		bean.setIdEntidadBancaria(new Long(5));
		bean.setNombreBeneficiario("nombre entidad benef");
		bean.setNroCBU("456465499");
		bean.setNroCuenta("15646-v86");
	    
	    EntidadBean entidad = new EntidadBean();
	    entidad.setDenominacion("denominacion");
	    entidad.setEvaluadora(false);
	    entidad.setBeneficiaria(false);
	    entidad.setBancaria(false);
	    entidad.setActivo(true);
	    entidad.setCuit("11-12398753-3");
	    entidad.setContacto("contacto: laura pierda");
	    entidad.setDescripcion("una descripcion");
	    entidad.setIdLocalizacion(new Long(28));

//	    bean.setEntidad(entidad);
	    return bean;
	}

	@Override
	public Object modifyBeanToUpdate(Object object) {
		EntidadEvaluadoraBean bean = (EntidadEvaluadoraBean)object;
		bean.setNroCBU("123456");
		
		return bean;
	}

}

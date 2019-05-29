package com.fontar.bean;

import com.fontar.data.impl.domain.bean.FuenteFinanciamientoBean;

public class FuenteFinanciamientoBeanTest extends AbstractBeanTest {

	private static final int NEW_ID = 1;
	
	public FuenteFinanciamientoBeanTest() {
		
		super("fuenteFinanciamientoDaoService",new Long(NEW_ID));		
	}
	
	@Override
	public Object getBeanToSave() {

		FuenteFinanciamientoBean bean = new FuenteFinanciamientoBean();
		bean.setIdentificador("ident7");
		bean.setDenominacion("denomin7");
		bean.setActivo(true);
	    return bean;
	}

	@Override
	public Object modifyBeanToUpdate(Object object) {
		FuenteFinanciamientoBean bean = (FuenteFinanciamientoBean)object;
		return bean;
	}

}

package com.fontar.bean;

import com.fontar.data.impl.domain.bean.InstrumentoVersionBean;
import com.pragma.util.DateTimeUtil;

public class InstrumentoVersionBeanTest extends AbstractBeanTest {

	public InstrumentoVersionBeanTest() {
		
		super("instrumentoVersionDaoService",new Long(1));		
	}
	
	@Override
	public Object getBeanToSave() {
		
		InstrumentoVersionBean bean = new InstrumentoVersionBean();
		bean.setCodigo("codigo");
		bean.setDescripcion("descripcion");
		bean.setFecha(DateTimeUtil.getDate());
		bean.setVersion(new Long(1));
		bean.setIdInstrumento(new Long(50));
		
		
		return bean;
	}

	@Override
	public Object modifyBeanToUpdate(Object object) {
		InstrumentoVersionBean bean = (InstrumentoVersionBean)object;
		bean.setCodigo("dd");
		return bean;
	}

}

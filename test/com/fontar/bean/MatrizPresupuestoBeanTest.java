package com.fontar.bean;

import com.fontar.data.Constant;
import com.fontar.data.impl.domain.bean.MatrizPresupuestoBean;

public class MatrizPresupuestoBeanTest extends AbstractBeanTest {

	public MatrizPresupuestoBeanTest() {
		
		super("matrizPresupuestoDaoService",new Long(1));		
	}
	
	@Override
	public Object getBeanToSave() {
		
		MatrizPresupuestoBean bean = new MatrizPresupuestoBean();
		bean.setActivo(true);
		bean.setNombre("matriz8");
		bean.setTipo(Constant.MatrizPresupuestoTipo.CF);
		
		return bean;
	}

	@Override
	public Object modifyBeanToUpdate(Object object) {
		MatrizPresupuestoBean bean = (MatrizPresupuestoBean)object;
		bean.setActivo(false);
		return bean;
	}

}

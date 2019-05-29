package com.fontar.bean;

import com.fontar.data.impl.domain.bean.PaqueteBean;
import com.fontar.data.impl.domain.codes.paquete.EstadoPaquete;
import com.fontar.data.impl.domain.codes.paquete.TipoPaquete;
import com.fontar.data.impl.domain.codes.paquete.TratamientoPaquete;

public class PaqueteBeanTest extends AbstractBeanTest {

	public PaqueteBeanTest(String daoName, Long idBean) {
		super("paqueteDaoService", new Long(1));
		// TODO Auto-generated constructor stub
	}
	public PaqueteBeanTest() {
		
		super("paqueteDaoService", new Long(1));
	}

	@Override
	public Object getBeanToSave() {
		PaqueteBean bean = new PaqueteBean();
		bean.setIdComision(new Long(1));
		bean.setIdInstrumento(new Long(50));
		bean.setTipo(TipoPaquete.COMISION);
		bean.setEstado(EstadoPaquete.CONTROLADO);
		bean.setObservacion("ddd");
		bean.setTratamiento(TratamientoPaquete.ADJUDICACION);
		bean.setCodigoActa("codigo acta");
		return bean;
	}

	@Override
	public Object modifyBeanToUpdate(Object object) {
		// TODO Auto-generated method stub
		return object;
	}

}

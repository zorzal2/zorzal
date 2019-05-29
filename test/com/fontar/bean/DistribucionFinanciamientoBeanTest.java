package com.fontar.bean;

import java.math.BigDecimal;

import com.fontar.data.impl.domain.bean.DistribucionFinanciamientoBean;

public class DistribucionFinanciamientoBeanTest extends AbstractBeanTest {

	public DistribucionFinanciamientoBeanTest() {
		super("distribucionFinanciamientoDaoService", new Long(1));
	}

	@Override
	public Object getBeanToSave() {
		DistribucionFinanciamientoBean d = new DistribucionFinanciamientoBean();
		d.setIdRegion(new Long(1));
		d.setIdJurisdiccion(new Long(1));
		d.setIdInstrumento(new Long(9));
		d.setMonto(new BigDecimal(10));
		d.setPorcentaje(new BigDecimal(20));
		return d;
	}

	@Override
	public Object modifyBeanToUpdate(Object object) {
		DistribucionFinanciamientoBean d = (DistribucionFinanciamientoBean)object;
		d.setPorcentaje(new BigDecimal(30));
		return d;
	}
}
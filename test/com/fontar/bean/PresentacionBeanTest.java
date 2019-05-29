package com.fontar.bean;

import static com.fontar.data.impl.domain.codes.presentacionConvocatoria.EstadoPresentacion.ANULADA;

import com.fontar.data.impl.domain.bean.PresentacionConvocatoriaBean;
import com.fontar.data.impl.domain.codes.presentacionConvocatoria.EstadoPresentacion;
import com.pragma.util.DateTimeUtil;

public class PresentacionBeanTest extends AbstractBeanTest {

	private final static String ID_INSTRUMENTO = "41";
	private final static String ID_JURISDICCION = "1";
	
	public PresentacionBeanTest() {
		
		super("presentacionDaoService",new Long(1));		
	}
	
	@Override
	public Object getBeanToSave() {
		
		
		
		PresentacionConvocatoriaBean bean = new PresentacionConvocatoriaBean();
		bean.setEstado(EstadoPresentacion.INICIADA);
		bean.setCodigo("codigo");
		bean.setFechaIngreso(DateTimeUtil.getDate());
		bean.setIdInstrumento(new Long(ID_INSTRUMENTO));
		bean.setIdJurisdiccion(new Long(ID_JURISDICCION));
		bean.setNombreEntidad("nombre entidad");
		bean.setObservaciones("observaciones");

		return bean;
	}

	@Override
	public Object modifyBeanToUpdate(Object object) {
		PresentacionConvocatoriaBean bean = (PresentacionConvocatoriaBean)object;
		bean.setEstado(ANULADA);
		return bean;
	}

}

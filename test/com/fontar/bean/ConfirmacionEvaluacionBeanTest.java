package com.fontar.bean;

import com.fontar.data.impl.domain.bean.BitacoraBean;
import com.fontar.data.impl.domain.codes.bitacora.TipoBitacora;
import com.pragma.util.DateTimeUtil;

public class ConfirmacionEvaluacionBeanTest extends AbstractBeanTest {

	public ConfirmacionEvaluacionBeanTest() {
		
		super("bitacoraDaoService",new Long(1));		
	}
	
	@Override
	public Object getBeanToSave() {
		BitacoraBean bitacora = new BitacoraBean();
		bitacora.setIdProyecto(new Long(123));
		bitacora.setFechaRegistro(DateTimeUtil.getDate());
		bitacora.setFechaAsunto(DateTimeUtil.getDate());
		bitacora.setIdUsuario("asdasd");
		bitacora.setTipo(TipoBitacora.BASICO);
		bitacora.setTema("Confirmación del Resultado de Evaluación");
		bitacora.setIdEvaluacion(new Long(345));
		return bitacora;
	}

	@Override
	public Object modifyBeanToUpdate(Object object) {
		BitacoraBean bean = (BitacoraBean)object;
		bean.setDescripcion("algo");
		return bean;
	}

}

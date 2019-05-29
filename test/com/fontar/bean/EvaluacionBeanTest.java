package com.fontar.bean;

import com.fontar.data.impl.domain.bean.BitacoraBean;
import com.fontar.data.impl.domain.bean.EvaluacionBean;
import com.fontar.data.impl.domain.codes.bitacora.TipoBitacora;
import com.fontar.data.impl.domain.codes.evaluacion.EstadoEvaluacion;
import com.fontar.data.impl.domain.codes.evaluacion.TipoEvaluacion;
import com.pragma.util.DateTimeUtil;

public class EvaluacionBeanTest extends AbstractBeanTest {

	public EvaluacionBeanTest() {
		
		super("evaluacionDaoService",new Long(1));		
	}
	
	@Override
	public Object getBeanToSave() {
		EvaluacionBean bean = new EvaluacionBean();

		bean.setId(new Long(346));
		bean.setEstado(EstadoEvaluacion.PEND_RESULT);
		bean.setFecha(DateTimeUtil.getDate());
		bean.setRecomendacion("instrumento anr");
		bean.setFechaInicial(DateTimeUtil.getDate());
		bean.setTipo(TipoEvaluacion.EVAL_GEN);
		bean.setObservacion("Observacion");

//		bean.setResultado(Constant.ResultadoEvaluacion.A_EVALUAR);
		
		BitacoraBean bitacora = bean.getBitacora();		
		bitacora.setIdProyecto(new Long(123));
		bitacora.setIdUsuario("asdasd");
		bitacora.setTipo(TipoBitacora.EVALUACION);
		bitacora.setTema("Test");
		bitacora.setFechaAsunto(DateTimeUtil.getDate());
		bitacora.setFechaRegistro(DateTimeUtil.getDate());
//		bitacora.setIdSeguimiento(new Long(1));

		return bean;
	}

	@Override
	public Object modifyBeanToUpdate(Object object) {
		EvaluacionBean bean = (EvaluacionBean)object;
		bean.setEstado(EstadoEvaluacion.ANULADA);
		return bean;
	}

}

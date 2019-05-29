package com.fontar.bean;

import com.fontar.data.impl.domain.bean.BitacoraBean;
import com.fontar.data.impl.domain.bean.EvaluacionGeneralBean;
import com.fontar.data.impl.domain.codes.evaluacion.EstadoEvaluacion;
import com.fontar.data.impl.domain.codes.evaluacion.TipoEvaluacion;
import com.fontar.data.impl.domain.codes.evaluacion.TipoEvaluacionFinanciera;
import com.pragma.util.DateTimeUtil;

public class EvaluacionGeneralBeanTest extends AbstractBeanTest {

	public EvaluacionGeneralBeanTest() {
		
		super("evaluacionGeneralDaoService",new Long(1));		
	}
	
	@Override
	public Object getBeanToSave() {
		
		EvaluacionGeneralBean bean = new EvaluacionGeneralBean();
		bean.setFechaInicial(DateTimeUtil.getDate());
		bean.setFecha(DateTimeUtil.getDate());
		//bean.setResultado(Constant.ResultadoEvaluacion.A_EVALUAR);
		bean.setEstado(EstadoEvaluacion.PEND_RESULT);
		bean.setRecomendacion("instrumento anr");
		//bean.setFundamentacion("Fundamentacion");
		bean.setTipo(TipoEvaluacion.EVAL_GEN);
		bean.setObservacion("Observacion");
		bean.setFechaEntregaComprometida(DateTimeUtil.getDate());
		bean.setEsAuditoriaContable(false);
		bean.setEsContable(true);
		bean.setEsEconomica(false);
		bean.setEsFinanciera(false);
		bean.setEsTecnica(false);
		bean.setEsVisitaTecnica(false);
		
		bean.setFechaEntregaComprometida(DateTimeUtil.getDate());
		bean.setTipoEvaluacionFinanciera(TipoEvaluacionFinanciera.BANCO);		
		
		BitacoraBean bitacora = bean.getBitacora();		
		bitacora.setIdProyecto(new Long(123));
		bitacora.setTema("Test");
		bitacora.setIdUsuario("asd");
		
		return bean;
	}

	@Override
	public Object modifyBeanToUpdate(Object object) {
		EvaluacionGeneralBean bean = (EvaluacionGeneralBean)object;
		bean.setEstado(EstadoEvaluacion.PEND_RESULT);
		return bean;
	}

}

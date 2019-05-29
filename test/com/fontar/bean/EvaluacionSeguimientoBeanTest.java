package com.fontar.bean;

import com.fontar.data.impl.domain.bean.BitacoraBean;
import com.fontar.data.impl.domain.bean.EvaluacionSeguimientoBean;
import com.fontar.data.impl.domain.codes.bitacora.TipoBitacora;
import com.fontar.data.impl.domain.codes.evaluacion.EstadoEvaluacion;
import com.fontar.data.impl.domain.codes.evaluacion.ResultadoEvaluacion;
import com.fontar.data.impl.domain.codes.evaluacion.TipoEvaluacion;
import com.fontar.data.impl.domain.codes.evaluacion.TipoEvaluacionFinanciera;
import com.pragma.util.DateTimeUtil;

public class EvaluacionSeguimientoBeanTest extends AbstractBeanTest {

	public EvaluacionSeguimientoBeanTest() {
		
		super("evaluacionSeguimientoDaoService",new Long(1));		
	}
	
	@Override
	public Object getBeanToSave() {
		
		EvaluacionSeguimientoBean bean = new EvaluacionSeguimientoBean();
		bean.setFechaInicial(DateTimeUtil.getDate());
		bean.setFecha(DateTimeUtil.getDate());
		bean.setResultado(ResultadoEvaluacion.A_DEFINIR);
		bean.setEstado(EstadoEvaluacion.PEND_RESULT);
		bean.setRecomendacion("instrumento anr");
		bean.setFundamentacion("Fundamentacion");
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
		bitacora.setTema("Test");
		bitacora.setIdUsuario("asd");
		bitacora.setTipo(TipoBitacora.ADMISION);
		bitacora.setIdProyecto(749L);
		
		return bean;
	}

	@Override
	public Object modifyBeanToUpdate(Object object) {
		EvaluacionSeguimientoBean bean = (EvaluacionSeguimientoBean)object;
		bean.setEstado(EstadoEvaluacion.PEND_RESULT);
		return bean;
	}

}

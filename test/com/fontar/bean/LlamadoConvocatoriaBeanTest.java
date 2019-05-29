package com.fontar.bean;

import java.math.BigDecimal;

import com.fontar.data.Constant;
import com.fontar.data.impl.domain.bean.InstrumentoBean;
import com.fontar.data.impl.domain.bean.LlamadoConvocatoriaBean;
import com.fontar.data.impl.domain.codes.instrumento.TipoFinanciamientoAsignacionInstrumento;
import com.fontar.data.impl.domain.codes.instrumento.TipoFinanciamientoInstrumento;
import com.fontar.data.impl.domain.codes.llamadoConvocatoria.EstadoLlamadoConvocatoria;
import com.pragma.util.DateTimeUtil;

public class LlamadoConvocatoriaBeanTest extends AbstractBeanTest {

	public LlamadoConvocatoriaBeanTest() {
		
		super("llamadoConvocatoriaDaoService",new Long(1));		
	}
	
	@Override
	public Object getBeanToSave() {
		
		LlamadoConvocatoriaBean bean = new LlamadoConvocatoriaBean();
				
		bean.setDenominacion("APORTES NO RETORNABLES");
		bean.setEsIdeaProyectoPitec(false);
		bean.setEstado(EstadoLlamadoConvocatoria.ACTIVO);
		bean.setFechaApertura(DateTimeUtil.getDate());
		bean.setFechaCierre(DateTimeUtil.getDate());
		bean.setFechaReconocimientoGastos(DateTimeUtil.getDate());
		bean.setFirmaContrato(new Integer(12));
		bean.setGarantia("ANR 300");
		bean.setIdComision(new Long(1));
		bean.setIdentificador("ANR 300");
		bean.setIdInstrumentoDef(new Long(1));
		bean.setIdInstrumentoVersion(new Long(1));
		bean.setIdMatrizPresupuesto(new Long(1));
		bean.setModalidad("Modalidad");
		bean.setMontoFinanciamiento(new BigDecimal(10000));
		bean.setMontoFinanciamientoTotal(new BigDecimal(10000));
		bean.setObservaciones("observaciones");
		bean.setPeriodoGracia("periodo de gracias");
		bean.setPermiteAdjudicacion(true);
		bean.setPermiteComision(true);
		bean.setPermiteFinanciamientoBancario(false);
		bean.setPermiteMultipleJurisdiccion(false);
		bean.setPermitePropiciado(false);
		bean.setPermiteSecretaria(false);
		bean.setPlazoAmortizacion("plazo amortizacion");
		bean.setPlazoEjecucion("plazo ejecucion");
		bean.setPlazoReadmision(new Integer(12));
		bean.setPlazoReconsideracion(new Integer(12));
		bean.setProporcionApoyo(new BigDecimal(12));
		bean.setTasaInteres("tasa de interesa");
		bean.setTipoDistribucionFinanciamiento(Constant.InstrumentoTipoDistribFinan.GLOBAL);
		bean.setTipoFinanciamiento(TipoFinanciamientoInstrumento.POR_BENEFICIARIO);
		bean.setTipoFinanciamientoAsignacion(TipoFinanciamientoAsignacionInstrumento.MONTO);
		return bean;
	}

	@Override
	public Object modifyBeanToUpdate(Object object) {
		InstrumentoBean bean = (InstrumentoBean)object;
		bean.setEstado(EstadoLlamadoConvocatoria.ANULADO);
		return bean;
	}

}

package com.fontar.adjunto;

import java.util.List;

import com.fontar.bus.api.convocatoria.LlamadoConvocatoriaServicio;
import com.fontar.bus.impl.domain.junit.ServiceBaseTest;

public class LlamadoConvocatoriaBeanTest extends ServiceBaseTest {

	public LlamadoConvocatoriaBeanTest() {
	}
	
	/*
	@Override
	public Object getBeanToSave() {
		
		LlamadoConvocatoriaBean bean = new LlamadoConvocatoriaBean();
				
		bean.setDenominacion("APORTES NO RETORNABLES");
		bean.setEsIdeaProyectoPitec(false);
		bean.setEstado(Constant.EstadoConvocatoria.ACTIVO);
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
		bean.setProporcionApoyo(new Integer(12));
		bean.setTasaInteres("tasa de interesa");
		bean.setTipoDistribucionFinanciamiento(Constant.InstrumentoTipoDistribFinan.GLOBAL);
		bean.setTipoFinanciamiento(Constant.InstrumentoTipoLimFinan.POR_BENEFICIARIO);
		bean.setTipoFinanciamientoAsignacion(Constant.TipoFinanciamientoAsignacion.MONTO);
		return bean;
	}

	@Override
	public Object modifyBeanToUpdate(Object object) {
		InstrumentoBean bean = (InstrumentoBean)object;
		bean.setEstado(Constant.EstadoConvocatoria.ANULADO);
		return bean;
	}
	*/
	public void testList() throws Exception {
		LlamadoConvocatoriaServicio llamadoConvocatoriaServicio = (LlamadoConvocatoriaServicio) getBean("llamadoConvocatoriaService");
		List lista = (List) llamadoConvocatoriaServicio.getAll();
		lista.isEmpty();
	}	

}

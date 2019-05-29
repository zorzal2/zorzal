package com.fontar.bean;

import static com.fontar.data.impl.domain.codes.ventanillaPermanente.EstadoVentanillaPermanente.ANULADO;

import java.math.BigDecimal;

import com.fontar.data.Constant;
import com.fontar.data.impl.domain.bean.InstrumentoBean;
import com.fontar.data.impl.domain.bean.VentanillaPermanenteBean;
import com.fontar.data.impl.domain.codes.instrumento.TipoFinanciamientoAsignacionInstrumento;
import com.fontar.data.impl.domain.codes.instrumento.TipoFinanciamientoInstrumento;
import com.fontar.data.impl.domain.codes.ventanillaPermanente.EstadoVentanillaPermanente;
import com.pragma.util.DateTimeUtil;

public class VentanillaPermanenteBeanTest extends AbstractBeanTest {

	public VentanillaPermanenteBeanTest() {
		
		super("ventanillaPermanenteDaoService",new Long(1));		
	}
	
	@Override
	public Object getBeanToSave() {
		
		VentanillaPermanenteBean bean = new VentanillaPermanenteBean();
		bean.setDenominacion("APORTES NO RETORNABLES");
		bean.setEstado(EstadoVentanillaPermanente.ABIERTO);
		bean.setFechaReconocimientoGastos(DateTimeUtil.getDate());
		bean.setFirmaContrato(new Integer(12));
		bean.setGarantia("ANR 300");
		bean.setIdComision(new Long(1));
		bean.setIdentificador("ANR 300");
		bean.setIdInstrumentoDef(new Long(1));
		bean.setIdMatrizPresupuesto(new Long(1));
		bean.setModalidad("Modalidad");
		bean.setMontoFinanciamiento(new BigDecimal(10000));
		bean.setMontoFinanciamientoTotal(new BigDecimal(10000));
		bean.setObservaciones("observaciones");
		bean.setPeriodoGracia("periodo de gracias");
		bean.setPermiteComision(true);
		bean.setPermiteFinanciamientoBancario(false);
		bean.setPermiteMultipleJurisdiccion(false);
		bean.setPermitePropiciado(false);
		bean.setPermiteSecretaria(false);
		bean.setPlazoAmortizacion("plazo amortizacion");
		bean.setPlazoEjecucion("plazo ejecucion");
		bean.setPlazoReconsideracion(new Integer(12));
		bean.setProporcionApoyo(new BigDecimal(12));
		bean.setTasaInteres("tasa de interesa");
		bean.setTipoDistribucionFinanciamiento(Constant.TipoDistribucionFinanciamiento.GLOBAL);
		bean.setTipoFinanciamiento(TipoFinanciamientoInstrumento.POR_BENEFICIARIO);
		bean.setTipoFinanciamientoAsignacion(TipoFinanciamientoAsignacionInstrumento.MONTO);

		return bean;
	}

	@Override
	public Object modifyBeanToUpdate(Object object) {
		InstrumentoBean bean = (InstrumentoBean)object;
		bean.setEstado(ANULADO);
		return bean;
	}

}

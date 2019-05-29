package com.fontar.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fontar.data.impl.domain.bean.EntidadBean;
import com.fontar.data.impl.domain.bean.ProyectoPresupuestoBean;
import com.fontar.data.impl.domain.bean.proyecto.presupuesto.plan.ActividadBean;
import com.fontar.data.impl.domain.bean.proyecto.presupuesto.plan.EtapaBean;


public class ProyectoPresupuestoBeanTest extends AbstractBeanTest {

	public ProyectoPresupuestoBeanTest() {
		
		super("proyectoPresupuestoDaoService",new Long(1));		
	}
	
	@Override
	public Object getBeanToSave() {
		
		ProyectoPresupuestoBean bean = new ProyectoPresupuestoBean();
		bean.setFundamentacion("Esto es la fundamentacion");
		bean.setMontoTotal(new BigDecimal(12345));
		bean.setMontoSolicitado(new BigDecimal(123456));
		
		Set<ActividadBean> actividades = new HashSet<ActividadBean>();
		ActividadBean actividad;
		Set<EtapaBean> etapas = new HashSet<EtapaBean>();
		EtapaBean etapa;
		
		etapa = new EtapaBean();
		etapa.setDescripcion("Una etapa");
		etapa.setNombre("A");
		etapa.setInicio(new Date());
		etapa.setFin(new Date());
		
		actividad = new ActividadBean();
		actividad.setDescripcion("Primera actividad");
		actividad.setNombre("A");
		actividad.setInicio(new Date());
		actividad.setFin(new Date());
		actividad.setEtapa(etapa);
		
		actividades.add(actividad);

		actividad = new ActividadBean();
		actividad.setDescripcion("Segunda actividad");
		actividad.setNombre("B");
		actividad.setInicio(new Date());
		actividad.setFin(new Date());
		actividad.setEtapa(etapa);
		
		actividades.add(actividad);
		
		etapa.setActividades(actividades);
		
		etapas.add(etapa);
		
		bean.setEtapas(etapas);
		
		return bean;
	}

	@Override
	public Object modifyBeanToUpdate(Object object) {
		EntidadBean bean = (EntidadBean)object;
		bean.setActivo(false);
		return bean;
	}

}

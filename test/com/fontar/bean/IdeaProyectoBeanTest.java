package com.fontar.bean;

import com.fontar.data.impl.domain.bean.IdeaProyectoBean;
import com.fontar.data.impl.domain.codes.ideaProyecto.EstadoIdeaProyecto;

public class IdeaProyectoBeanTest extends AbstractBeanTest {

	//private final static String ID_INSTRUMENTO = "41";
	//private final static String ID_JURISDICCION = "1";
	
	public IdeaProyectoBeanTest() {
		
		super("ideaProyectoDaoService",new Long(1));		
	}
	@Override
	public Object getBeanToSave() {
		IdeaProyectoBean bean = new IdeaProyectoBean();
		
		bean.setEstado(EstadoIdeaProyecto.INICIADO);
		bean.setCodigo("ANR 300 567/06");
		bean.setIdDatos(new Long(2889));
		bean.setIdEmpleoPermanente(new Long(121));
		bean.setIdInstrumento(new Long(194));
		bean.setIdPresupuesto(new Long(2915));
		bean.setIdPresupuestoOriginal(new Long(2919));
		bean.setIdProyectoJurisdiccion(new Long(2920));
	
      return bean;
	}
	@Override
	public Object modifyBeanToUpdate(Object object) {
		IdeaProyectoBean bean = (IdeaProyectoBean)object;
		bean.setEstado(EstadoIdeaProyecto.EVALUACION);
		return bean;
	}
}
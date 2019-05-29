package com.fontar.bean;

import static com.fontar.data.impl.domain.codes.proyecto.EstadoProyecto.ADMITIDO;

import com.fontar.data.impl.domain.bean.ProyectoBean;


public class ProyectoBeanTest extends AbstractBeanTest {

	private static final String CODIGO = "COD";

	public ProyectoBeanTest() {
		
		super("proyectoDaoService",new Long(1));		
	}
	
	@Override
	public Object getBeanToSave() {

		ProyectoBean bean = new ProyectoBean();
		bean.setCodigo(CODIGO);
		bean.setEstado(ADMITIDO);
		bean.setIdInstrumento(new Long(194));
		bean.setEstadoEnPaquete(true);
		
		return bean;
	}
	
	public Object modifyBeanToUpdate(Object bean)
	{
		ProyectoBean proyectoBean = (ProyectoBean)bean;
		proyectoBean.setCodigo(CODIGO + "1");
		return proyectoBean;
	}
}

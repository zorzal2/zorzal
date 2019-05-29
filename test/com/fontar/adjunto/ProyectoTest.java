package com.fontar.adjunto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fontar.bus.api.convocatoria.ProyectoServicio;
import com.fontar.bus.impl.domain.junit.ServiceBaseTest;
import com.fontar.data.impl.domain.bean.AdjuntoBean;
import com.fontar.data.impl.domain.bean.ProyectoBean;

public class ProyectoTest extends ServiceBaseTest {

	public void testList() throws Exception {
		ProyectoServicio proyectoServicio = (ProyectoServicio) getBean("proyectoServicio");
		
		ProyectoBean proyectoBean = (ProyectoBean) proyectoServicio.load(817L);
		
		List listaAdjuntos = new ArrayList();
		listaAdjuntos.addAll(proyectoBean.getAdjuntos());
		for (Iterator iter = listaAdjuntos.iterator(); iter.hasNext();) {
			AdjuntoBean adjunto= (AdjuntoBean) iter.next();
			
			System.out.println(adjunto.getNombre());
		}
	}	

}

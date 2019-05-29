package com.fontar.adjunto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fontar.bus.api.configuracion.InstrumentoDefServicio;
import com.fontar.bus.impl.domain.junit.ServiceBaseTest;
import com.fontar.data.impl.domain.bean.AdjuntoBean;
import com.fontar.data.impl.domain.bean.InstrumentoDefBean;

public class InstrumentoDefTest extends ServiceBaseTest {

	public void testList() throws Exception {
		InstrumentoDefServicio instrumentoDefServicio = (InstrumentoDefServicio) getBean("instrumentoDefServicio");
		List lista = (List) instrumentoDefServicio.listaInstrumentosDef();
		
		List listaAdjuntos = new ArrayList();
		for (Iterator iter = lista.iterator(); iter.hasNext();) {
			InstrumentoDefBean element = (InstrumentoDefBean) iter.next();
			listaAdjuntos.addAll(element.getAdjuntos());
			
		}
		for (Iterator iter = listaAdjuntos.iterator(); iter.hasNext();) {
			AdjuntoBean adjunto= (AdjuntoBean) iter.next();
			
			System.out.println(adjunto.getNombre());
		}
	}	

}

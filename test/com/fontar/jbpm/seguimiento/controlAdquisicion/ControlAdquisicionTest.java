package com.fontar.jbpm.seguimiento.controlAdquisicion;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Unit test del circuito de <code>Control Adquisición</code>.<br> 
 * @author ssanchez
 */
public class ControlAdquisicionTest extends BaseControlAdquisicionTest {

	public void testDesignarEvaluadorTecnico() {
		
		token.signal();

		designarEvaluadorTecnico();
		validarHayTareasAbiertas();
	}	
	
	public void testCargarFundamentacionEvaluador() {
		
		token.signal();

		designarEvaluadorTecnico();
		
		cargarFundamentacionEvaluador();
		validarHayTareasAbiertas();
	}	

	public void testCargarResultadosItemsUffa() {
		
		token.signal();

		designarEvaluadorTecnico();
		
		cargarFundamentacionEvaluador();
		
		cargarResultado(true,false);
		
		Collection<String> lista = new ArrayList<String>();
		lista.add(TASK_REMITIR_A_UFFA);
		validarListadoTareasAbiertas(lista);
	}	

	public void testCargarResultadosItemsBid() {
		
		token.signal();

		designarEvaluadorTecnico();
		
		cargarFundamentacionEvaluador();
		
		cargarResultado(false,true);
		
		Collection<String> lista = new ArrayList<String>();
		lista.add(TASK_REMITIR_A_BID);
		validarListadoTareasAbiertas(lista);
	}	
	
	public void testCargarResultadosItemsUffayBid() {
		
		token.signal();

		designarEvaluadorTecnico();
		
		cargarFundamentacionEvaluador();
		
		cargarResultado(true,true);
		
		Collection<String> lista = new ArrayList<String>();
		lista.add(TASK_REMITIR_A_BID);
		lista.add(TASK_REMITIR_A_UFFA);
		validarListadoTareasAbiertas(lista);
	}	
	
	public void testCargarResultadosSinItemsUffaOBid() {
		
		token.signal();

		designarEvaluadorTecnico();
		
		cargarFundamentacionEvaluador();
		
		cargarResultado(false,false);
		validarNoHayTareasAbiertas();
	}	

	public void testRemitirUffa() {
		
		token.signal();

		designarEvaluadorTecnico();
		
		cargarFundamentacionEvaluador();
		
		cargarResultado(true,false);
		
		remitirUffa();

		Collection<String> lista = new ArrayList<String>();
		lista.add(TASK_CARGAR_RESULTADO_UFFA);
		validarListadoTareasAbiertas(lista);
	}	

	public void testRemitirBid() {
		
		token.signal();

		designarEvaluadorTecnico();
		
		cargarFundamentacionEvaluador();
		
		cargarResultado(false,true);
		
		remitirBid();

		Collection<String> lista = new ArrayList<String>();
		lista.add(TASK_CARGAR_RESULTADO_BID);
		validarListadoTareasAbiertas(lista);
	}	
	
	public void testCargarResultadoUffa() {
		
		token.signal();

		designarEvaluadorTecnico();
		
		cargarFundamentacionEvaluador();
		
		cargarResultado(true,false);
		
		remitirUffa();

		cargarResultadoUffa(false);
		validarNoHayTareasAbiertas();
	}	

	public void testCargarResultadoBid() {
		
		token.signal();

		designarEvaluadorTecnico();
		
		cargarFundamentacionEvaluador();
		
		cargarResultado(false,true);
		
		remitirBid();

		cargarResultadoBid(false);
		validarNoHayTareasAbiertas();
	}	
	
	public void testCargarResultadoUffaYBid() {

		token.signal();

		designarEvaluadorTecnico();
		
		cargarFundamentacionEvaluador();
		
		cargarResultado(true,true);
		Collection<String> lista = new ArrayList<String>();
		lista.add(TASK_REMITIR_A_BID);
		lista.add(TASK_REMITIR_A_UFFA);
		validarListadoTareasAbiertas(lista);
		
		remitirUffaYBid();
		lista = new ArrayList<String>();
		lista.add(TASK_CARGAR_RESULTADO_BID);
		lista.add(TASK_CARGAR_RESULTADO_UFFA);
		validarListadoTareasAbiertas(lista);

		cargarResultadoUffaYBid(false);
		validarNoHayTareasAbiertas();
	}
	
	public void testCargarResultadoUffaYNoCargarResultadoBid() {

		token.signal();

		designarEvaluadorTecnico();
		
		cargarFundamentacionEvaluador();
		
		cargarResultado(true,true);
		Collection<String> lista = new ArrayList<String>();
		lista.add(TASK_REMITIR_A_BID);
		lista.add(TASK_REMITIR_A_UFFA);
		validarListadoTareasAbiertas(lista);
		
		remitirUffaYBid();
		lista = new ArrayList<String>();
		lista.add(TASK_CARGAR_RESULTADO_BID);
		lista.add(TASK_CARGAR_RESULTADO_UFFA);
		validarListadoTareasAbiertas(lista);

		cargarResultadoUffa(false);
		lista = new ArrayList<String>();
		lista.add(TASK_CARGAR_RESULTADO_BID);
		validarListadoTareasAbiertas(lista);
	}
	
	public void testCargarResultadoBidYNoCargarResultadoUffa() {

		token.signal();

		designarEvaluadorTecnico();
		
		cargarFundamentacionEvaluador();
		
		cargarResultado(true,true);
		Collection<String> lista = new ArrayList<String>();
		lista.add(TASK_REMITIR_A_BID);
		lista.add(TASK_REMITIR_A_UFFA);
		validarListadoTareasAbiertas(lista);
		
		remitirUffaYBid();
		lista = new ArrayList<String>();
		lista.add(TASK_CARGAR_RESULTADO_BID);
		lista.add(TASK_CARGAR_RESULTADO_UFFA);
		validarListadoTareasAbiertas(lista);

		cargarResultadoBid(false);
		lista = new ArrayList<String>();
		lista.add(TASK_CARGAR_RESULTADO_UFFA);
		validarListadoTareasAbiertas(lista);
	}

	
	public void testGenerarPedidoAutorizacion() {
		
		token.signal();

		designarEvaluadorTecnico();
		
		cargarFundamentacionEvaluador();
		
		cargarResultado(true,true);
		Collection<String> lista = new ArrayList<String>();
		lista.add(TASK_REMITIR_A_BID);
		lista.add(TASK_REMITIR_A_UFFA);
		validarListadoTareasAbiertas(lista);
		
		remitirUffaYBid();
		lista = new ArrayList<String>();
		lista.add(TASK_CARGAR_RESULTADO_BID);
		lista.add(TASK_CARGAR_RESULTADO_UFFA);
		validarListadoTareasAbiertas(lista);

		cargarResultadoUffaYBid(true);

		generarPedidoAutorizacion();
		validarNoHayTareasAbiertas();
	}	
}

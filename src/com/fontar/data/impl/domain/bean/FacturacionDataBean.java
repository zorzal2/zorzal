package com.fontar.data.impl.domain.bean;

/**
 * Estos objetos registran información información relacionada con la facturación de las Entidades Beneficiarias. 
 * @see EntidadBeneficariaBean
 */
public class FacturacionDataBean {

	private Long id;

	private Integer numeroPeriodico;

	private Long numeroFacturacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeroFacturacion() {
		return numeroFacturacion;
	}

	public void setNumeroFacturacion(Long numeroFacturacion) {
		this.numeroFacturacion = numeroFacturacion;
	}

	public Integer getNumeroPeriodico() {
		return numeroPeriodico;
	}

	public void setNumeroPeriodico(Integer numeroPeriodico) {
		this.numeroPeriodico = numeroPeriodico;
	}

}

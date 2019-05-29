package com.fontar.data.impl.domain.bean;

// Generated 16/08/2006 11:51:51 by Hibernate Tools 3.1.0 beta3

import java.math.BigDecimal;

/**
 * ProyectoEvalId generated by hbm2java
 */

public class ProyectoEvalId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Fields

	private BigDecimal idProyecto;

	private BigDecimal idEval;

	// Constructors

	/** default constructor */
	public ProyectoEvalId() {
	}

	/** full constructor */
	public ProyectoEvalId(BigDecimal idProyecto, BigDecimal idEval) {
		this.idProyecto = idProyecto;
		this.idEval = idEval;
	}

	// Property accessors

	public BigDecimal getIdProyecto() {
		return this.idProyecto;
	}

	public void setIdProyecto(BigDecimal idProyecto) {
		this.idProyecto = idProyecto;
	}

	public BigDecimal getIdEval() {
		return this.idEval;
	}

	public void setIdEval(BigDecimal idEval) {
		this.idEval = idEval;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProyectoEvalId))
			return false;
		ProyectoEvalId castOther = (ProyectoEvalId) other;

		return ((this.getIdProyecto() == castOther.getIdProyecto()) || (this.getIdProyecto() != null
				&& castOther.getIdProyecto() != null && this.getIdProyecto().equals(castOther.getIdProyecto())))
				&& ((this.getIdEval() == castOther.getIdEval()) || (this.getIdEval() != null
						&& castOther.getIdEval() != null && this.getIdEval().equals(castOther.getIdEval())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdProyecto() == null ? 0 : this.getIdProyecto().hashCode());
		result = 37 * result + (getIdEval() == null ? 0 : this.getIdEval().hashCode());
		return result;
	}

}
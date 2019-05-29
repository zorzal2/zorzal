package com.fontar.bean;

import com.fontar.data.impl.domain.bean.EntidadBean;
import com.fontar.data.impl.domain.bean.EntidadBeneficiariaBean;
import com.fontar.data.impl.domain.codes.entidad.Categorizacion;
import com.fontar.data.impl.domain.codes.entidad.TipoEmpresa;
import com.fontar.data.impl.domain.codes.entidad.TipoEntidad;
import com.pragma.util.DateTimeUtil;
public class EntidadBeneficiariaBeanTest extends AbstractBeanTest {

	private static final int NEW_ID = 6;

	public EntidadBeneficiariaBeanTest() {
		
		super("entidadBeneficiariaDaoService",new Long(NEW_ID));		
	}
	
	@Override
	public Object getBeanToSave() {
		
		EntidadBeneficiariaBean bean = new EntidadBeneficiariaBean();
		bean.setIdCiiu(new Long(10));
		bean.setTipo(TipoEntidad.EMPRESA.getName());
	    bean.setTipoEmpresa(TipoEmpresa.SRL.getName());
	    bean.setCodigoCategorizacion(Categorizacion.GRANDE.getName());
	    //bean.setIdEmpleoPermanente(new Long(1));
	    bean.setFechaInicioActividad(DateTimeUtil.getDate());
	    bean.setIdLocalizacionEconomica(new Long(1));
	    bean.setNumeroConstitucion(new Integer(1999));
	    bean.setDescEmpresa("Empresa reruda");
	    
	    EntidadBean entidad = bean.getEntidad();
	    entidad.setDenominacion("denominacion");
	    entidad.setEvaluadora(false);
	    entidad.setBeneficiaria(false);
	    entidad.setBancaria(false);
	    entidad.setActivo(true);
	    entidad.setCuit("99995654");
	    entidad.setContacto("contacto: laura pierda");
	    entidad.setDescripcion("una descripcion");
	    entidad.setIdLocalizacion(new Long(1));
	    return bean;
	}

	@Override
	public Object modifyBeanToUpdate(Object object) {
		EntidadBeneficiariaBean bean = (EntidadBeneficiariaBean)object;
		bean.setDescEmpresa("empresa desc");
		return bean;
	}

}

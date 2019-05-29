package com.fontar.bean;

import com.fontar.data.Constant;
import com.fontar.data.impl.domain.bean.EvaluadorBean;
import com.fontar.data.impl.domain.bean.PersonaBean;
import com.pragma.util.DateTimeUtil;
public class EvaluadorBeanTest extends AbstractBeanTest {

	private static final int NEW_ID = 6;

	public EvaluadorBeanTest() {
		
		super("evaluadorDaoService",new Long(NEW_ID));		
	}
	
	@Override
	public Object getBeanToSave() {
		
		EvaluadorBean bean = new EvaluadorBean();
//		bean.setId(new Long(NEW_ID));
		bean.setFechaIngreso(DateTimeUtil.getDate());
		bean.setIdEspecialidadPrimaria(new Long(1));
		
		
	    PersonaBean persona = bean.getPersona();
	    persona.setNombre("persona evaluadora");
	    persona.setEsEvaluador(true);
	    persona.setCuit("1131");
	    persona.setSexo(Constant.PersonaSexo.FEMENINO);
	    persona.setActivo(true);
	    return bean;
	}

	@Override
	public Object modifyBeanToUpdate(Object object) {
		EvaluadorBean bean = (EvaluadorBean)object;
		return bean;
	}

}

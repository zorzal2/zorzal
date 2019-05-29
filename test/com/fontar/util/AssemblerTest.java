package com.fontar.util;

import junit.framework.TestCase;

import com.fontar.data.impl.assembler.EvaluacionAssembler;
import com.fontar.data.impl.domain.bean.EvaluacionBean;
import com.fontar.data.impl.domain.dto.EvaluacionDTO;

public class AssemblerTest extends TestCase {

	
	public void testBuildBeanWithNull()
	{
		EvaluacionAssembler assembler = EvaluacionAssembler.getInstance();
		EvaluacionDTO dto = new EvaluacionDTO();
		
		dto.setObservacion("Prueba de valor nulo en id");
		dto.setId(2L);
		
		EvaluacionBean bean = assembler.buildBean(dto);
		
		assertEquals(bean.getId(),new Long(3));
		
	}
}

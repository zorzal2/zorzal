package com.fontar.data.impl.dao.hibernate;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fontar.data.impl.domain.bean.CriptoTestBean;

public class CriptoTestDAOImpl extends HibernateDaoSupport {
	
	public CriptoTestDAOImpl(){
		super();
	}

	public CriptoTestBean guardarNuevoCriptoTest(CriptoTestBean criptoTestBean)
	{
		this.getHibernateTemplate().save(criptoTestBean);
		
		return criptoTestBean;
	}
	
	public CriptoTestBean modificarCriptoTest(CriptoTestBean criptoTestBean)
	{
		if (criptoTestBean.getId() != 0)
		{
			this.getHibernateTemplate().update(criptoTestBean);
		}
		
		return criptoTestBean;
	}

	public CriptoTestBean leerCriptoTest(long id)
	{
		CriptoTestBean criptoTestBean = (CriptoTestBean) getSession(true).load(CriptoTestBean.class, new Long(id));
		
		return criptoTestBean;
	}
	
}

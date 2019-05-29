package com.fontar.data.impl.dao.hibernate;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fontar.data.impl.domain.bean.CriptoTestPassBean;

public class CriptoTestPassDAOImpl extends HibernateDaoSupport {
	
	public CriptoTestPassDAOImpl(){
		super();
	}

	public CriptoTestPassBean guardarNuevoCriptoTestPass(CriptoTestPassBean criptoTestPassBean)
	{
		this.getHibernateTemplate().save(criptoTestPassBean);
		
		return criptoTestPassBean;
	}
	
	public CriptoTestPassBean modificarCriptoTestPass(CriptoTestPassBean criptoTestPassBean)
	{
		if (criptoTestPassBean.getId() != 0)
		{
			this.getHibernateTemplate().update(criptoTestPassBean);
		}
		
		return criptoTestPassBean;
	}

	public CriptoTestPassBean leerCriptoTestPass(long id)
	{
		//TODO: ojo con el get(0)
		CriptoTestPassBean criptoTestPassBean = (CriptoTestPassBean) this.getHibernateTemplate().find("from CriptoTestPassBean b where b.idUsuario = " + id).get(0);
		//CriptoTestPassBean criptoTestPassBean = (CriptoTestPassBean) getSession(true).load(CriptoTestPassBean.class, new Long(id));
		return criptoTestPassBean;
	}
	
}

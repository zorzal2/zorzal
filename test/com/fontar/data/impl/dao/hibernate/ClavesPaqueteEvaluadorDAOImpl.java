package com.fontar.data.impl.dao.hibernate;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fontar.data.impl.domain.bean.ClavesPaqueteEvaluador;



public class ClavesPaqueteEvaluadorDAOImpl extends HibernateDaoSupport {
	
	public ClavesPaqueteEvaluadorDAOImpl(){
		super();
	}

	public ClavesPaqueteEvaluador guardarClavesPaqueteEvaluador(ClavesPaqueteEvaluador clavesPaqueteEvaluador)
	{
		this.getHibernateTemplate().save(clavesPaqueteEvaluador);
		
		return clavesPaqueteEvaluador;
	}
	
	public ClavesPaqueteEvaluador modificarClavesPaqueteEvaluador(ClavesPaqueteEvaluador clavesPaqueteEvaluador)
	{
		if (clavesPaqueteEvaluador.getIdUsuario() != 0)
		{
			this.getHibernateTemplate().update(clavesPaqueteEvaluador);
		}
		
		return clavesPaqueteEvaluador;
	}
	
	public ClavesPaqueteEvaluador leerClavesPaqueteEvaluador(long id)
	{
		ClavesPaqueteEvaluador clavesPaqueteEvaluador = (ClavesPaqueteEvaluador) getSession(true).load(ClavesPaqueteEvaluador.class, new Long(id));
		
		return clavesPaqueteEvaluador;
	}
	
}

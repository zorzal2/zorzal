package com.fontar.workshop;

import java.sql.SQLException;

import junit.framework.TestCase;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.fontar.data.impl.domain.bean.PresentacionConvocatoriaBean;

public class HibernateTestCase extends TestCase {

	XmlBeanFactory factory;
	
	protected void setUp() throws Exception {
		System.out.println("res");
		FileSystemResource res = new FileSystemResource("c:/Eclipse-JBossIDE-GA/workspace-spring/fontar-web/webroot/WEB-INF/applicationContext-hibernate.xml");
		System.out.println("xml");
		factory = new XmlBeanFactory(res);
	}
	
	public void testHibernateTemplate() {
		HibernateTemplate template = (HibernateTemplate)factory.getBean("hibernateTemplate");
		
		// template
		System.out.println("loading thru template");
		template.load(PresentacionConvocatoriaBean.class,new Long(1));

		
		System.out.println("loading thru callback");
		// template with callback
		
				template.execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						return session.load(PresentacionConvocatoriaBean.class,new Long(1));
						//template.find()
					}
				}
				);
		
		
		// TEMPLATE EXXCEPTION
		try {
			System.out.println("exception with template method");
			template.find("whatever wrong typed query...");
		}
		catch (DataAccessException t ) {
			System.out.println("caught dataaccess exception");
			t.printStackTrace();
		}
		
		// TEMPLATE W/CALLBACK EXXCEPTION
		try {
			System.out.println("exception with hibernatecallback");
			template.execute(
					new HibernateCallback() {
						public Object doInHibernate(Session session) throws HibernateException, SQLException {
							return session.createQuery("whatever wrong typed query").list();
						}
					}
					);
		}
		catch (DataAccessException t ) {
			System.out.println("caught dataaccess exception");
			t.printStackTrace();
		}
		
		
		// HIBERNATE EXEPTION
		try {
			System.out.println("hibernate runtime exception");
			template.getSessionFactory().openSession().createQuery("whatever wrong typed query").list();
		}
		catch (HibernateException he) {
			throw template.convertHibernateAccessException(he);
		}
		catch (Throwable t ) {
			t.printStackTrace();
			
			//throw template.convertHibernateAccessException(t);
		}
		
		
	}
	
	

	protected void tearDown() throws Exception {
		
	}

}

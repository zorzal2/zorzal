package com.fontar.bean;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.fontar.data.Constant;
import com.pragma.data.genericdao.GenericDao;

public abstract class AbstractBeanTest extends AbstractDependencyInjectionSpringContextTests {

	//private static final String SESSION_FACTORY = "sessionFactory";
	private static final String GET_ID = "getId";
	private String serviceName;
	private Long idBean;
	
	public AbstractBeanTest(String daoName, Long idBean) {
		
		this.serviceName = daoName;
		this.idBean = idBean;	
	}
	
	/************************************************************************************************************/
	
	  /**
	   * Levanta el contexto necesario
	   *
	   * @return Array con listado de archivos de configuración de Spring
	   */
	  protected String[] getConfigLocations() {
	    // TODO Auto-generated method stub
	    return new String[] {
	             Constant.FONTAR_HOME + "/WEB-INF/conf/junit/applicationContext-hibernate-junit.xml",
	             Constant.FONTAR_HOME + "/WEB-INF/conf/junit/services-config-junit.xml", 
	             Constant.FONTAR_HOME + "/WEB-INF/conf/dao-config.xml"
	           };
	  }  
	  
	/************************************************************************************************************/	
	
	public abstract Object getBeanToSave();
	public abstract Object modifyBeanToUpdate(Object object);
	
	
	
	public String GetMethodId() {
		
		return GET_ID;		
	}
	
	private GenericDao getDao() {

		return (GenericDao)getBean(serviceName);
	}
	
	private Object getBean(String name) {
		
		return this.applicationContext.getBean(name);
	}
	
	public Object getBean() {
		GenericDao dao = getDao();
		Object bean = null;
		if (idBean != null) {
			bean = dao.read(idBean);
		}
		return bean;
	}
	
	public void setBean() throws Exception {
		setBean(false);
	}
	
	@SuppressWarnings("unchecked")
	public Object setBean(boolean replaceId) throws Exception {
		try {
			GenericDao dao = (GenericDao) getDao();
			Object bean = dao.save(getBeanToSave());
			if (replaceId) {
				idBean = (Long) bean.getClass().getMethod(GetMethodId(), null).invoke(bean, null);
			}
			return bean;
		}
		catch(Exception ex) {
			
			throw ex;		
		}
	}
	
	@SuppressWarnings("unchecked")
	
	public void deleteBean(Object bean) {
		GenericDao dao = getDao();
		dao.delete(bean);
		
	}
	
	public void testBean() throws Exception {
		
		Object bean1 = null;
		Object bean2 = null;
		bean1 = setBean(true);
		bean2 = getBean();
		
		assertEquals("ERROR: Los ID deberían ser iguales", bean1.getClass().getMethod(GetMethodId(), null).invoke(bean1, null), bean2.getClass().getMethod(GetMethodId(), null).invoke(bean2, null));
		
		bean1 = modifyBeanToUpdate(bean1);
		
		deleteBean(bean1);
		
		bean1 = getBean();
	
		assertNull("ERROR: El datos debería ser NULO ya que fue borrado",bean1);		
	}	
}

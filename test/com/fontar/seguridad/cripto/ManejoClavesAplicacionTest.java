//package com.fontar.seguridad.cripto;
//
//import java.security.KeyPair;
//import java.security.PrivateKey;
//import java.security.PublicKey;
//
//import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
//
//import com.fontar.data.impl.dao.hibernate.ClavesPaqueteEvaluadorDAOImpl;
//import com.fontar.data.impl.dao.hibernate.CriptoTestPassDAOImpl;
//import com.fontar.data.impl.dao.hibernate.PaqueteDAOImpl;
//import com.fontar.data.impl.dao.hibernate.UsuarioDAOImpl;
//import com.fontar.data.impl.domain.bean.ClavesPaqueteEvaluador;
//import com.fontar.data.impl.domain.bean.CriptoTestPassBean;
//import com.fontar.data.impl.domain.bean.Paquete;
//import com.fontar.data.impl.domain.bean.Usuario;
//
//public class ManejoClavesAplicacionTest 
//	extends AbstractDependencyInjectionSpringContextTests {
//		  //~ Instance fields ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//
//		  CriptoSistema                 criptoSistema;
//		  UsuarioDAOImpl                usuarioDAOImpl;
//		  Usuario                       usuario;
//		  ClavesPaqueteEvaluadorDAOImpl clavesPaqueteEvaluadorDAOImpl;
//		  ClavesPaqueteEvaluador        clavesPaqueteEvaluador;
//		  PaqueteDAOImpl                paqueteDAOImpl;
//		  Paquete                       paquete;
//		  CriptoTestPassBean            criptoTestPassBean;
//		  CriptoTestPassDAOImpl         criptoTestPassDAOImpl;
//
//		  //~ Methods ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//
//		  /**
//		   * Levanta el contexto necesario
//		   *
//		   * @return Documentar el valor de retorno!
//		   */
//		  protected String[] getConfigLocations() {
//		    // TODO Auto-generated method stub
//		    return new String[] {
//		             "file:c:/Eclipse-JBossIDE-GA/workspace-jBPM/fontar-web/webroot/WEB-INF/applicationContext-hibernate.xml",
//		             "file:c:/Eclipse-JBossIDE-GA/workspace-jBPM/fontar-web/webroot/WEB-INF/action-servlet-test.xml", "file:c:/Eclipse-JBossIDE-GA/workspace-jBPM/fontar-web/webroot/WEB-INF/dao-config.xml"
//		           };
//		  }
//		  
//		  /**
//		   * Documentar el objetivo del metodo!
//		   *
//		   * @param criptoTestPassDAOImpl Documentar el parametro!
//		   */
//		  public void setCriptoTestPassDAOImpl(CriptoTestPassDAOImpl criptoTestPassDAOImpl) {
//		    this.criptoTestPassDAOImpl = criptoTestPassDAOImpl;
//		  }
//
//		  /**
//		   * Documentar el objetivo del metodo!
//		   *
//		   * @param usuarioDAOImpl Documentar el parametro!
//		   */
//		  public void setUsuarioDAOImpl(UsuarioDAOImpl usuarioDAOImpl) {
//		    this.usuarioDAOImpl = usuarioDAOImpl;
//		  }
//
//		  /**
//		   * Documentar el objetivo del metodo!
//		   *
//		   * @param criptoSistema Documentar el parametro!
//		   */
//		  public void setCriptoSistema(CriptoSistema criptoSistema) {
//		    this.criptoSistema = criptoSistema;
//		  }
//
//		  /**
//		   * Documentar el objetivo del metodo!
//		   *
//		   * @param clavesPaqueteEvaluadorDAOImpl Documentar el parametro!
//		   */
//		  public void setClavesPaqueteEvaluadorDAOImpl(ClavesPaqueteEvaluadorDAOImpl clavesPaqueteEvaluadorDAOImpl) {
//		    this.clavesPaqueteEvaluadorDAOImpl = clavesPaqueteEvaluadorDAOImpl;
//		  }
//
//		  /**
//		   * Documentar el objetivo del metodo!
//		   *
//		   * @param paqueteDAOImpl Documentar el parametro!
//		   */
//		  public void setPaqueteDAOImpl(PaqueteDAOImpl paqueteDAOImpl) {
//		    this.paqueteDAOImpl = paqueteDAOImpl;
//		  }
//		  
//		  /**
//		   * Genera el par de claves de aplicación
//		   * Guarda y lee la clave privada de la aplicación desde archivo previa encriptación/desencriptación
//		   * Guarda y lee la clave publica de la aplicación desde archivo 
//		   */
//		  public void testManejoClavesAplicacion() throws Exception{
//			  // Genero claves de aplicación
//			  KeyPair appKeyPair = criptoSistema.generarClavesAplicacion();
//			  
//			  // Creo el usuario Aplicación
//			  Usuario usuario = new Usuario();
//			  usuario.setNombre("app");
//			  
//			  // Obtengo la contraseña de la aplicación para guardar la clave privada
//			  char[] appContrasenia = criptoSistema.obtenerContraseniaAplicacion();
//			  
//			  // Encripto y guardo la clave privada de la aplicación en archivo
//			  criptoSistema.guardarClavePrivadaDeAplicacion(appKeyPair.getPrivate(), appContrasenia);
//
//			  // Guardo la clave publica de la aplicación en archivo
//			  criptoSistema.guardarClavePublicaDeAplicacion(appKeyPair.getPublic());
//			  
//			  // Leo la clave privada y publica de la aplicación desde archivo
//			  PrivateKey appPrivateKey = criptoSistema.obtenerClavePrivadaAplicacion(appContrasenia);
//			  PublicKey appPublicKey = criptoSistema.obtenerClavePublicaAplicacion();
//			  
//			  // Comparo las claves para verificar si la clave leida es igual a la previa
//			  assertEquals(appKeyPair.getPrivate(), appPrivateKey);
//			  assertEquals(appKeyPair.getPublic(), appPublicKey);
//		  }		  
//}

//package com.fontar.seguridad.cripto;
//
//import java.security.KeyPair;
//import java.security.PrivateKey;
//
//import javax.crypto.SecretKey;
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
///**
// * 
// * @author ssanchez
// */
//public class CriptoTest
//extends AbstractDependencyInjectionSpringContextTests {
//  //~ Instance fields ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//
//  CriptoSistema                 criptoSistema;
//  UsuarioDAOImpl                usuarioDAOImpl;
//  Usuario                       usuario;
//  ClavesPaqueteEvaluadorDAOImpl clavesPaqueteEvaluadorDAOImpl;
//  ClavesPaqueteEvaluador        clavesPaqueteEvaluador;
//  PaqueteDAOImpl                paqueteDAOImpl;
//  Paquete                       paquete;
//  CriptoTestPassBean            criptoTestPassBean;
//  CriptoTestPassDAOImpl         criptoTestPassDAOImpl;
//  KeyPair appKeyPair;
//
//  //~ Methods ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//
//  /**
//   * Levanta el contexto necesario
//   *
//   * @return Documentar el valor de retorno!
//   */
//  protected String[] getConfigLocations() {
//    // TODO Auto-generated method stub
//    return new String[] {
//             "file:c:/Eclipse-JBossIDE-GA/workspace-jBPM/fontar-web/webroot/WEB-INF/applicationContext-hibernate.xml",
//             "file:c:/Eclipse-JBossIDE-GA/workspace-jBPM/fontar-web/webroot/WEB-INF/action-servlet-test.xml", 
//             "file:c:/Eclipse-JBossIDE-GA/workspace-jBPM/fontar-web/webroot/WEB-INF/dao-config.xml"
//           };
//  }
//  
//  /**
//   * Documentar el objetivo del metodo!
//   *
//   * @param criptoTestPassDAOImpl Documentar el parametro!
//   */
//  public void setCriptoTestPassDAOImpl(CriptoTestPassDAOImpl criptoTestPassDAOImpl) {
//    this.criptoTestPassDAOImpl = criptoTestPassDAOImpl;
//  }
//
//  /**
//   * Documentar el objetivo del metodo!
//   *
//   * @param usuarioDAOImpl Documentar el parametro!
//   */
//  public void setUsuarioDAOImpl(UsuarioDAOImpl usuarioDAOImpl) {
//    this.usuarioDAOImpl = usuarioDAOImpl;
//  }
//
//  /**
//   * Documentar el objetivo del metodo!
//   *
//   * @param criptoSistema Documentar el parametro!
//   */
//  public void setCriptoSistema(CriptoSistema criptoSistema) {
//    this.criptoSistema = criptoSistema;
//  }
//
//  /**
//   * Documentar el objetivo del metodo!
//   *
//   * @param clavesPaqueteEvaluadorDAOImpl Documentar el parametro!
//   */
//  public void setClavesPaqueteEvaluadorDAOImpl(ClavesPaqueteEvaluadorDAOImpl clavesPaqueteEvaluadorDAOImpl) {
//    this.clavesPaqueteEvaluadorDAOImpl = clavesPaqueteEvaluadorDAOImpl;
//  }
//
//  /**
//   * Documentar el objetivo del metodo!
//   *
//   * @param paqueteDAOImpl Documentar el parametro!
//   */
//  public void setPaqueteDAOImpl(PaqueteDAOImpl paqueteDAOImpl) {
//    this.paqueteDAOImpl = paqueteDAOImpl;
//  }
//
//  /**
//   * Crea la estructura de datos para poder encriptar/desencriptar datos de la tabla paquetes
//   * Crea un usuario con permisos para acceder a datos encriptados de la tabla paquetes
//   * Guarda un dato encriptado usando la infraestructura criptográfica
//   * Lee un dato encriptado usando la infra
//   * Compara que el dato leido/desencriptado de DB sea igual al dato sin encriptar
//   */
//  /*
//  public void testCampoEncriptado()
//  throws Exception {
//    // Crea infraestructura de claves para poder encriptar dato
//    //usuario = inicializarInfraestructura();
//    usuario = usuarioDAOImpl.leerUsuario(2);
//  
//    // Cargo los datos del paquete que seran guardados en DB
//    paquete = cargarDatosPaquete();
//  
//    // Obtengo el evaluador sin encriptar para comparar con el dato desencriptado
//    byte[] evaluadorRaw = paquete.getEvaluador();
//  
//    // Guarda el paquete previo encriptación del campo evaluador
//    guardarPaqueteParaUsuario(usuario, paquete);
//  
//    // Lee de DB el paquete y obtiene el campo evaluador desencriptado
//    long   idPaquete              = 1;
//    byte[] evaluadorDesencriptado = leerDesencriptarCampoEncriptado(usuario, idPaquete);
//  
//    assertEquals(new String(evaluadorRaw), new String(evaluadorDesencriptado));
//  }
//  /*
//
//  /**
//   * Valida que la password de encriptación ingresada por usuario sea valida 
//   */
//  /*
//  public void testValidarPassword() throws PasswordInvalidaException{
//  
//      usuario = usuarioDAOImpl.leerUsuario(2);
//  
//      PrivateKey userPrivateKey = leerPrivateKeyUsuario(usuario);
//  
//      PrivateKey passPrivateKey;
//  
//      passPrivateKey = validarPassword(usuario);
//  
//      assertEquals(userPrivateKey, passPrivateKey);
//  }
//  */
//
//  /**
//   * Crea usuarios con permisos de lectura de datos encriptados para la tabla cripto_test
//   */
//  /*
//  public void testAltasUsuarios()
//  throws Exception {
//	inicializarClavesDatosAplicacion(); 
//	  
//    // Creo primer usuario para con permiso de lectura en cripto_test
//    Usuario usuario = altaUsuario("fferrara");
//    crearPermisoDeLecturaCampo(usuario);
//
//    // Creo primer usuario para con permiso de lectura en cripto_test
//    usuario = altaUsuario("sperez");
//    crearPermisoDeLecturaCampo(usuario);
//    
//    // Creo primer usuario para con permiso de lectura en cripto_test
//    usuario = altaUsuario("sguaymare");
//    crearPermisoDeLecturaCampo(usuario);
//  }
//  */
//  
//  /**
//   * Genera el par de claves de aplicación
//   * Guarda y lee la clave privada de la aplicación desde archivo previa encriptación/desencriptación
//   * Guarda y lee la clave publica de la aplicación desde archivo 
//   */
//  public void testManejoClavesAplicacion() throws Exception{
//	  // Genero claves de aplicación
//	  KeyPair appKeyPair = criptoSistema.generarClavesAplicacion();
//	  
//	  // Creo el usuario Aplicación
//	  Usuario usuario = new Usuario();
//	  usuario.setNombre("app");
//	  
//	  // Obtengo la contraseña de la aplicación para guardar la clave privada
//	  char[] appContrasenia = criptoSistema.obtenerContraseniaAplicacion();
//	  
//	  // Encripto y guardo la clave privada de la aplicación en disco
//	  criptoSistema.guardarClavePrivadaDeAplicacion(appKeyPair.getPrivate(), appContrasenia);
//	  
//	  // Leo la clave privada de la aplicación desde archivo
//	  PrivateKey appPrivateKey = criptoSistema.obtenerClavePrivadaAplicacion(appContrasenia);
//	  
//	  // Comparo las claves para verificar si la clave privada leida es igual a la previa
//	  assertEquals(appKeyPair.getPrivate(), appPrivateKey);
//  }
//  
//
//  /**
//   * Creo Usuario Aplicación y clave simetrica para la tabla Cripto_test
//   *
//   * @throws Exception
//   */
//  private Usuario inicializarClavesDatosAplicacion()
//  throws Exception {
//    // Crea el usuario applicacion en el sistema. 
//    Usuario usuarioApli = altaUsuarioAplicacion();
//
//    // Genera par claves de aplicacion
//    appKeyPair = criptoSistema.generarClavesAplicacion();
//    
//    // Generar clave simétrica para la tabla con datos a encriptar para el usuario aplicación
//    byte[] dataKey = criptoSistema.generarClaveInicial(appKeyPair.getPublic());
//
//    // Cargo los datos para guardar la clave simétrica inicial de la tabla CriptoTest
//    criptoTestPassBean = new CriptoTestPassBean();
//    criptoTestPassBean.setIdUsuario(usuarioApli.getId());
//    criptoTestPassBean.setClave(dataKey);
//    criptoTestPassBean.setTabla("InstrumentoDefBean");
//    // Guardo la clave simetrica de la tabla criptotest para el 1º usuario Aplicación
//    criptoTestPassDAOImpl.guardarNuevoCriptoTestPass(criptoTestPassBean);
//    
//    return usuarioApli;
//  }
//  
//  /**
//   * Doy al usuario permiso de lectura a datos encriptados para la tabla cripto_test
//   * @param usuario
//   * @throws Exception
//   */
//  private void crearPermisoDeLecturaCampo(Usuario usuario)
//  throws Exception {
//
//    // Obtener clave simetrica de datos para la tabla paquetes
//    Usuario usuarioApli = usuarioDAOImpl.leerUsuario(1);
//
//    CriptoTestPassBean criptoTestPassBean = criptoTestPassDAOImpl.leerCriptoTestPass(usuarioApli.getId());
//
//    SecretKey secretKey = criptoSistema.desencriptarCrearClaveSimetricaConClavePrivadaAplicacion(criptoTestPassBean.getClave(), null);
//    
//    // Encripto SecretKey con la clave publica del usuario
//    byte[] encriptSecretKey = criptoSistema.encriptarClaveSimetricaConClavePublicaDeUsuario(secretKey.getEncoded(), usuario);
//
//    // Cargo los datos para guardar la clave simétrica inicial de la tabla CriptoTest
//    criptoTestPassBean = new CriptoTestPassBean();
//    criptoTestPassBean.setIdUsuario(usuario.getId());
//    criptoTestPassBean.setClave(encriptSecretKey);
//    criptoTestPassBean.setTabla("InstrumentoDefBean");
//    
//    // Guardo la clave simetrica de la tabla criptotest para el 1º usuario Aplicación
//    criptoTestPassDAOImpl.guardarNuevoCriptoTestPass(criptoTestPassBean);
//  }
//  
//  
//  /**
//   * Documentar el objetivo del metodo!
//   *
//   * @return Documentar el valor de retorno!
//   *
//   * @throws Exception Documentar la excepcion!
//   */
//  private Usuario inicializarInfraestructura()
//  throws Exception {
//    // Crea la clave simetrica para la tabla paquete y la almacena en DB
//    inicializaClave();
//
//    // Creo un usuario nuevo con su par de claves las guardo
//    Usuario usuario = altaUsuario("fferrara");
//
//    // Le doy permiso al usuario para acceder a un campo encriptado de una tabla 
//    crearPermisoDeLecturaCampoAUsuario(usuario);
//
//    return usuario;
//  }
//
//  /**
//   * Documentar el objetivo del metodo!
//   *
//   * @param usuario Documentar el parametro!
//   * @param paquete Documentar el parametro!
//   *
//   * @throws Exception Documentar la excepcion!
//   */
//  private void guardarPaqueteParaUsuario(Usuario usuario, Paquete paquete)
//  throws Exception {
//    // Obtengo los datos del usuario desde DB
//    Usuario us = new Usuario();
//    us = usuarioDAOImpl.leerUsuario(usuario.getId());
//
//    // Obtengo la contrasenia del usuario
//    char[] contrasenia = criptoSistema.obtenerContraseniaUsuario();
//
//    // Obtengo la clave privada del usuario para poder desencriptar la SecretKey correspondiente al campo/tabla que se quiere encriptar
//    PrivateKey userPrivateKey = criptoSistema.obtenerClavePrivadaDeUsuario(us, contrasenia);
//
//    // Obtengo la Key del usuario para el campo/tabla a encriptar
//    SecretKey secretKey = obtenerSecretKeyDeCampoTabla(userPrivateKey);
//
//    // Guardo paquete con los el campo evaluador encriptado
//    guardarPaqueteConCampoEncriptado(secretKey, paquete);
//  }
//
//  /**
//   * Documentar el objetivo del metodo!
//   *
//   * @param usuario Documentar el parametro!
//   * @param idPaquete Documentar el parametro!
//   *
//   * @return Documentar el valor de retorno!
//   *
//   * @throws Exception Documentar la excepcion!
//   */
//  private byte[] leerDesencriptarCampoEncriptado(Usuario usuario, long idPaquete)
//  throws Exception {
//    byte[] evaluadorDesencriptado = null;
//
//    // Obtengo los datos del usuario desde DB
//    Usuario us = new Usuario();
//    us = usuarioDAOImpl.leerUsuario(usuario.getId());
//
//    // Obtengo la contrasenia del usuario
//    char[] contrasenia = criptoSistema.obtenerContraseniaUsuario();
//
//    // Obtengo la clave privada del usuario para poder desencriptar la SecretKey correspondiente al campo/tabla que se quiere encriptar
//    PrivateKey userPrivateKey = criptoSistema.obtenerClavePrivadaDeUsuario(us, contrasenia);
//
//    // Obtengo la Key del usuario para el campo/tabla a encriptar
//    SecretKey secretKey = obtenerSecretKeyDeCampoTabla(userPrivateKey);
//
//    Paquete   paquete2 = new Paquete();
//
//    paquete2 = paqueteDAOImpl.leerPaquete(idPaquete);
//
//    evaluadorDesencriptado = criptoSistema.desencriptarDatosConClaveSimetrica(paquete2.getEvaluador(), secretKey);
//
//    return evaluadorDesencriptado;
//  }
//
//  /**
//   * Documentar el objetivo del metodo!
//   *
//   * @return Documentar el valor de retorno!
//   *
//   * @throws Exception Documentar la excepcion!
//   */
//  private Usuario altaUsuario(String nombre)
//  throws Exception {
//    // Genero par de claves para el usuario nuevo
//    KeyPair userKeyPair = criptoSistema.generarClavesUsuario();
//
//    // Certifico UserPublicKey 
//    byte[] certifiedUserPublicKey = criptoSistema.certificarClavePublica(userKeyPair.getPublic(), null);
//
//    byte[] publicKey = userKeyPair.getPublic().getEncoded();
//
//    // Cargo los datos del usuario
//    Usuario usuario = new Usuario();
//    usuario.setNombre(nombre);
//    usuario.setClavePublica(publicKey);
//    usuario.setClavePublicaCertificada(certifiedUserPublicKey);
//
//    // Guardo el nuevo usuario en DB
//    usuarioDAOImpl.guardarNuevoUsuario(usuario);
//
//    // Obtengo la contraseña del usuario para blindar UserPrivatekey
//    // TODO: obtener la contraseña desde el usuario
//    char[] contrasenia = criptoSistema.obtenerContraseniaUsuario();
//
//    // Blindo la UserPrivatekey con la Contrasenia del usuario y lo guardo en archivo
//    // TODO: crear esquema xml que permita encontrar un usuario y obtener la clave, el campo, etc. Se puede usar ObjectOutputStream para almacenar objetos de PrivateKey  
//    criptoSistema.guardarClavePrivadaDeUsuario(usuario, userKeyPair.getPrivate(), contrasenia);
//
//    return usuario;
//  }
//
//  /**
//   * Documentar el objetivo del metodo!
//   *
//   * @param usuario Documentar el parametro!
//   *
//   * @throws Exception Documentar la excepcion!
//   */
//  private void crearPermisoDeLecturaCampoAUsuario(Usuario usuario)
//  throws Exception {
//    // Leo los datos del usuario
//    usuario = usuarioDAOImpl.leerUsuario(usuario.getId());
//
//    // Obtener clave simetrica de datos para la tabla paquetes
//    SecretKey secretKey = obtenerClaveDatos();
//
//    // Encripto SecretKey con la clave publica del usuario
//    byte[] encriptSecretKey = criptoSistema.encriptarClaveSimetricaConClavePublicaDeUsuario(secretKey.getEncoded(), usuario);
//
//    clavesPaqueteEvaluador = new ClavesPaqueteEvaluador();
//    clavesPaqueteEvaluador.setIdUsuario(usuario.getId());
//    clavesPaqueteEvaluador.setClave(encriptSecretKey);
//
//    clavesPaqueteEvaluadorDAOImpl.guardarClavesPaqueteEvaluador(clavesPaqueteEvaluador);
//  }
//
//  /**
//   * Documentar el objetivo del metodo!
//   *
//   * @param privateKey Documentar el parametro!
//   *
//   * @return Documentar el valor de retorno!
//   *
//   * @throws Exception Documentar la excepcion!
//   */
//  private SecretKey obtenerSecretKeyDeCampoTabla(PrivateKey privateKey)
//  throws Exception {
//    clavesPaqueteEvaluador = clavesPaqueteEvaluadorDAOImpl.leerClavesPaqueteEvaluador(usuario.getId());
//
//    byte[] encriptSecretKey = clavesPaqueteEvaluador.getClave();
//
//    SecretKey secretKey = criptoSistema.desencriptarCrearClaveSimetricaConClavePrivada(encriptSecretKey, privateKey);
//
//    return secretKey;
//  }
//
//  /**
//   * Documentar el objetivo del metodo!
//   *
//   * @return Documentar el valor de retorno!
//   *
//   * @throws Exception Documentar la excepcion!
//   */
//  private Paquete cargarDatosPaquete()
//  throws Exception {
//    // Encripto el dato del campo a guardar
//    byte[] evaluador = new String("Pedro Suarez").getBytes();
//    byte[] resultado = new String("alguno").getBytes();
//
//    // Cargo datos del objeto a guardar en DB
//    Paquete paquete = new Paquete();
//    paquete.setNombre("Pragma");
//    paquete.setEvaluador(evaluador);
//    paquete.setResultado(resultado);
//
//    return paquete;
//  }
//
//  /**
//   * Documentar el objetivo del metodo!
//   *
//   * @param secretKey Documentar el parametro!
//   * @param paquete Documentar el parametro!
//   *
//   * @throws Exception Documentar la excepcion!
//   */
//  private void guardarPaqueteConCampoEncriptado(SecretKey secretKey, Paquete paquete)
//  throws Exception {
//    byte[] encriptEvaluador = criptoSistema.encriptarDatosConClaveSimetrica(paquete.getEvaluador(), secretKey);
//    byte[] resultado        = "Esta super correcto".getBytes();
//
//    // Cargo datos del objeto a guardar en DB
//    paquete = new Paquete();
//    paquete.setNombre("Pragma");
//    paquete.setEvaluador(encriptEvaluador);
//    paquete.setResultado(resultado);
//
//    paqueteDAOImpl.guardarPaquete(paquete);
//  }
//
//  /**
//   * Documentar el objetivo del metodo!
//   *
//   * @throws Exception Documentar la excepcion!
//   */
//  private void inicializaClave()
//  throws Exception {
//    // Crea el usuario applicacion en el sistema. 
//    Usuario usuarioApli = altaUsuarioAplicacion();
//
//    // Generar clave simétrica para la tabla con datos a encriptar para el usuario aplicación
//    byte[] dataKey = criptoSistema.generarClaveInicial(appKeyPair.getPublic());
//
//    // Cargo los datos para guardar la clave simétrica inicial de la tabla paquetes
//    clavesPaqueteEvaluador = new ClavesPaqueteEvaluador();
//    clavesPaqueteEvaluador.setIdUsuario(usuarioApli.getId());
//    clavesPaqueteEvaluador.setClave(dataKey);
//
//    clavesPaqueteEvaluadorDAOImpl.guardarClavesPaqueteEvaluador(clavesPaqueteEvaluador);
//  }
//
//  /**
//   * Documentar el objetivo del metodo!
//   *
//   * @return Documentar el valor de retorno!
//   *
//   * @throws Exception Documentar la excepcion!
//   */
//  private Usuario altaUsuarioAplicacion()
//  throws Exception {
//    // Cargo los datos del usuario
//    Usuario usuario = new Usuario();
//    usuario.setNombre("Aplicacion");
//
//    // Guardo el nuevo usuario en DB
//    usuarioDAOImpl.guardarNuevoUsuario(usuario);
//
//    return usuario;
//  }
//
//  /**
//   * Documentar el objetivo del metodo!
//   *
//   * @return Documentar el valor de retorno!
//   *
//   * @throws Exception Documentar la excepcion!
//   */
//  private SecretKey obtenerClaveDatos()
//  throws Exception {
//    // TODO: Implementar esquema para saber cual es el primer usuario aplicacion que contiene la clave simétrica
//    Usuario usuarioApli = usuarioDAOImpl.leerUsuario(1);
//
//    ClavesPaqueteEvaluador clavesPaqueteEvaluador = clavesPaqueteEvaluadorDAOImpl.leerClavesPaqueteEvaluador(usuarioApli.getId());
//
//    SecretKey secretKey = criptoSistema.desencriptarCrearClaveSimetricaConClavePrivadaAplicacion(clavesPaqueteEvaluador.getClave(), null);
//
//    return secretKey;
//  }
//
//  /**
//   * Documentar el objetivo del metodo!
//   *
//   * @return Documentar el valor de retorno!
//   *
//   * @throws Exception Documentar la excepcion!
//   */
//  public PrivateKey validarPassword(Usuario usuario)
//  throws PasswordInvalidaException {
//    PrivateKey privateKey = null;
//
//    // Obtengo los datos del usuario desde DB
//    Usuario us = new Usuario();
//    us = usuarioDAOImpl.leerUsuario(usuario.getId());
//
//    char[] contrasenia = "cualquiera".toCharArray();
//
//    // Obtengo la clave privada del usuario para poder desencriptar la SecretKey correspondiente al campo/tabla que se quiere encriptar
//    privateKey = criptoSistema.validarPasswordEncriptacion(us, contrasenia);
//
//    return privateKey;
//  }
//
//  /**
//   * Documentar el objetivo del metodo!
//   *
//   * @param usuario Documentar el parametro!
//   *
//   * @return Documentar el valor de retorno!
//   */
//  public PrivateKey leerPrivateKeyUsuario(Usuario usuario) {
//    PrivateKey privateKey = null;
//    try {
//      // Obtengo los datos del usuario desde DB
//      Usuario us = new Usuario();
//      us = usuarioDAOImpl.leerUsuario(usuario.getId());
//
//      // Obtengo la contrasenia del usuario
//      char[] contrasenia = criptoSistema.obtenerContraseniaUsuario();
//
//      // Obtengo la clave privada del usuario para poder desencriptar la SecretKey correspondiente al campo/tabla que se quiere encriptar
//      privateKey = criptoSistema.obtenerClavePrivadaDeUsuario(us, contrasenia);
//    } catch(Exception e) {
//      System.out.println(e.getMessage());
//    }
//
//    return privateKey;
//  }
//
//}
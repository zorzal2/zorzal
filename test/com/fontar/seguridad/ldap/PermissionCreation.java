package com.fontar.seguridad.ldap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fontar.data.impl.domain.ldap.Permiso;

public class PermissionCreation extends PermisoCrudTest {

	static protected Map<String, List<String> > permissions;
	
	static protected final String CONFIGURACION = "Configuración";
	static protected final String ADMINISTACION = "Administración";
	static protected final String INSTRUMENTO = "Instrumento";
	static protected final String ENCRIPTACION = "Encriptacion";
	
	
	static {
		permissions = new HashMap<String,List<String> >();
		
		//Llamados a convocatoris
		
		//Configuracion
		List<String> permissionNames = new LinkedList<String>();

		/*
		permissionNames.add("COMISIONES-AGREGAR");
		permissionNames.add("COMISIONES-EDITAR");
		permissionNames.add("COMISIONES-INVENTARIO");
		
		permissionNames.add("ENTIDADES-AGREGAR");
		permissionNames.add("ENTIDADES-EDITAR");
		permissionNames.add("ENTIDADES-INVENTARIO");

		permissionNames.add("ESPECIALIDADESEVALUADOR-AGREGAR");
		permissionNames.add("ESPECIALIDADESEVALUADOR-EDITAR");
		permissionNames.add("ESPECIALIDADESEVALUADOR-INVENTARIO");
		
		permissionNames.add("FUENTESFINANCIAMIENTO-AGREGAR");
		permissionNames.add("FUENTESFINANCIAMIENTO-EDITAR");
		permissionNames.add("FUENTESFINANCIAMIENTO-INVENTARIO");

		permissionNames.add("INSTRUMENTOS-AGREGAR");
		permissionNames.add("INSTRUMENTOS-EDITAR");
		permissionNames.add("INSTRUMENTOS-INVENTARIO");
		
		permissionNames.add("JURISDICCIONES-AGREGAR");
		permissionNames.add("JURISDICCIONES-EDITAR");
		permissionNames.add("JURISDICCIONES-INVENTARIO");
		
		permissionNames.add("PERSONAS-AGREGAR");
		permissionNames.add("PERSONAS-EDITAR");
		permissionNames.add("PERSONAS-INVENTARIO");
		
		permissionNames.add("REGIONES-AGREGAR");
		permissionNames.add("REGIONES-EDITAR");
		permissionNames.add("REGIONES-INVENTARIO");

		permissionNames.add("TIPOSPROYECTO-AGREGAR");
		permissionNames.add("TIPOSPROYECTO-EDITAR");
		permissionNames.add("TIPOSPROYECTO-INVENTARIO");
		*/		
		
		//Usuarios
		permissionNames.add("USUARIOS-INVENTARIO");
		permissionNames.add("USUARIOS-EDITAR");
		permissionNames.add("USUARIOS-AGREGAR");
		permissionNames.add("USUARIOS-ELIMINAR");
		
		//Grupos
		permissionNames.add("GRUPOS-INVENTARIO");
		permissionNames.add("GRUPOS-EDITAR");
		permissionNames.add("GRUPOS-AGREGAR");
		permissionNames.add("GRUPOS-ELIMINAR");
		
		
	

		//Administracion/Evaluacion
		List<String> permissionAdmNames = new LinkedList<String>();
		
		//Proyecto
		//permissionAdmNames.add("PROYECTOS-INVENTARIO");
		permissionAdmNames.add("PROYECTOS-BITACORA");
		//permissionAdmNames.add("PROYECTOS-AGREGAR");
		//permissionAdmNames.add("PROYECTOS-VISUALIZAR");
		
		//Paquete
		/*
		permissionAdmNames.add("PAQUETES-INVENTARIO");
		permissionAdmNames.add("PAQUETES-EDITAR");
		permissionAdmNames.add("PAQUETES-AGREGAR");
		permissionAdmNames.add("PAQUETES-VISUALIZAR");
		*/
		
		//Evalaucion
		/*
		permissionAdmNames.add("EVALUACIONES-INVENTARIO");
		permissionAdmNames.add("EVALUACIONES-VISUALIZAR");
		*/
		
		List<String> permissionInstrumentoNames = new LinkedList<String>();
	
		permissionInstrumentoNames.add("LLAMADOSCONVOCATORIA-INVENTARIO");
		permissionInstrumentoNames.add("LLAMADOSCONVOCATORIA-VISUALIZAR");
		permissionInstrumentoNames.add("LLAMADOSCONVOCATORIA-AGREGAR");
		permissionInstrumentoNames.add("LLAMADOSCONVOCATORIA-EDITAR");
		permissionInstrumentoNames.add("LLAMADOSCONVOCATORIA-ELIMINAR");

		permissionInstrumentoNames.add("PRESENTACIONCONVOCATORIA-INVENTARIO");
		permissionInstrumentoNames.add("PRESENTACIONCONVOCATORIA-VISUALIZAR");
		permissionInstrumentoNames.add("PRESENTACIONCONVOCATORIA-AGREGAR");
		permissionInstrumentoNames.add("PRESENTACIONCONVOCATORIA-EDITAR");
		permissionInstrumentoNames.add("PRESENTACIONCONVOCATORIA-ELIMINAR");

		permissionInstrumentoNames.add("VENTANILLAPERMANENTE-INVENTARIO");
		permissionInstrumentoNames.add("VENTANILLAPERMANENTE-VISUALIZAR");
		permissionInstrumentoNames.add("VENTANILLAPERMANENTE-AGREGAR");
		permissionInstrumentoNames.add("VENTANILLAPERMANENTE-EDITAR");
		permissionInstrumentoNames.add("VENTANILLAPERMANENTE-ELIMINAR");
		
		permissionInstrumentoNames.add("IDEASPROYECTO-INVENTARIO");
		permissionInstrumentoNames.add("IDEASPROYECTO-VISUALIZAR");
		permissionInstrumentoNames.add("IDEASPROYECTO-AGREGAR");
		permissionInstrumentoNames.add("IDEASPROYECTO-EDITAR");
		permissionInstrumentoNames.add("IDEASPROYECTO-ELIMINAR");
		
		permissionInstrumentoNames.add("IDEASPROYECTOPITEC-INVENTARIO");
		permissionInstrumentoNames.add("IDEASPROYECTOPITEC-VISUALIZAR");
		permissionInstrumentoNames.add("IDEASPROYECTOPITEC-AGREGAR");
		permissionInstrumentoNames.add("IDEASPROYECTOPITEC-EDITAR");
		permissionInstrumentoNames.add("IDEASPROYECTOPITEC-ELIMINAR");
		
		List<String> permissionEncryptacionNames = new LinkedList<String>();
		permissionEncryptacionNames.add("ENCRIPTACION");
				
		permissions.put(CONFIGURACION, permissionNames);
		permissions.put(ADMINISTACION, permissionAdmNames);
		permissions.put(INSTRUMENTO, permissionInstrumentoNames);
		permissions.put(ENCRIPTACION, permissionEncryptacionNames);		
	}
	
	
	
	private Collection<String> getPermissions(String moduleName){
		return permissions.get(moduleName);
	}
	
	
	
	
	
	public void testCreate(){
		this.createPermission( ENCRIPTACION );
	}
	
	
	public void createPermission(String moduleName){
		Collection<String> permissions = this.getPermissions( moduleName );
		Iterator<String> iterator = permissions.iterator();
		while(iterator.hasNext()){
			String permissionName = iterator.next();
			Permiso permission = new Permiso();
			permission.setIdPermiso( permissionName);
			permission.setModulo( moduleName );
			try {
				permisoDao.create(permission);
			} catch (Exception ex) {
				assertSame(ex.getClass(),org.springframework.ldap.UncategorizedLdapException.class);
			}
		}
	}
	
}

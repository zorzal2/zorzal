package com.fontar.seguridad.ldap;

import java.util.List;

import org.springframework.ldap.EntryNotFoundException;

import com.fontar.data.impl.dao.ldap.PermisoDao;
import com.fontar.data.impl.domain.ldap.Permiso;

public class PermisoCrudTest extends BaseLdapTest {

	PermisoDao permisoDao;
	
	@Override
	protected void onSetUp() throws Exception {
		permisoDao = (PermisoDao)getBean("permisoLdapDao");
	}
	
	@Override
	protected void onTearDown() throws Exception {
		// TODO Auto-generated method stub
		super.onTearDown();
	}

	/**
	 * 
	 *
	 */
	public void _testFindAll(){
		List permisos =  permisoDao.findAll();
		assertTrue(permisos.size() > 0);
	}

	/**
	 * 
	 *
	 */
	public void testCreate(){
		
		Permiso permiso = new Permiso();
		permiso.setIdPermiso("BANDEJAENTRADA-INVENTARIO");
		permiso.setModulo("MENU-WORKFLOW");

		try {
			permisoDao.create(permiso);
		} catch (Exception ex) {
			assertSame(ex.getClass(),org.springframework.ldap.UncategorizedLdapException.class);
		}
	}
	
	/*public void _testFindByPrimaryKey(){
	
		try {
			//Grupo grupo = permisoDao.findByPrimaryKey(null);
			//Grupo grupo = permisoDao.findByPrimaryKey("");
			//Grupo grupo = permisoDao.findByPrimaryKey("pp");
			Grupo grupo = permisoDao.findByPrimaryKey("PruebaJose");
			System.out.println("Nombre Grupo: "+ grupo.getNombre());
			System.out.println("IdGrupo: "+ grupo.getIdGrupo());
			System.out.println("IdInstrumento: "+ grupo.getIdInstrumento());
		} catch (EntryNotFoundException ex) {
			//JC: Entra si no existe entrada con ese nombre
			assertSame(ex.getClass(),EntryNotFoundException.class);
		} catch (IllegalArgumentException ex) {
			//JC: Entra si viene en null o ""
			assertSame(ex.getClass(),IllegalArgumentException.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			assertTrue(false);
		}
	}
	
	public void testModify(){
		
		try {
			//Grupo grupo = permisoDao.findByPrimaryKey(null);
			//Grupo grupo = permisoDao.findByPrimaryKey("");
			//Grupo grupo = permisoDao.findByPrimaryKey("pp");
			Grupo grupo = permisoDao.findByPrimaryKey("PruebaJose6");
			System.out.println("Nombre Grupo: "+ grupo.getNombre());
			System.out.println("IdGrupo: "+ grupo.getIdGrupo());
			System.out.println("IdInstrumento: "+ grupo.getIdInstrumento());
			int i= 0;
			String aRemover= "";
			for (Iterator iter = grupo.getPermisos().iterator(); iter.hasNext();) {
				String element = (String) iter.next();
				System.out.println("permiso "+ i+": "+element);
				if(i==0){aRemover=element;}
				i++;
			}
			grupo.getPermisos().remove(aRemover);
			for (Iterator iter = grupo.getPermisos().iterator(); iter.hasNext();) {
				String element = (String) iter.next();
				System.out.println("permiso "+ i+": "+element);
			}
			
			grupo.setIdGrupo("999");
			grupo.setIdInstrumento("999");
			//grupo.setPermisos(new TreeSet());
			//grupo.setPermisos(null);
			//grupo.setUsuarios(null);
			permisoDao.update(grupo);
			Grupo grupo2 = permisoDao.findByPrimaryKey("PruebaJose");
			System.out.println("Nombre Grupo: "+ grupo2.getNombre());
			System.out.println("IdGrupo: "+ grupo2.getIdGrupo());
			System.out.println("IdInstrumento: "+ grupo2.getIdInstrumento());
						
		} catch (EntryNotFoundException ex) {
			//JC: Entra si no existe entrada con ese nombre
			assertSame(ex.getClass(),EntryNotFoundException.class);
		} catch (IllegalArgumentException ex) {
			//JC: Entra si viene en null o ""
			assertSame(ex.getClass(),IllegalArgumentException.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			assertTrue(false);
		}
	}*/
	
	public void _testDelete(){
		
		try {
			
			Permiso permiso = new Permiso();
			//grupo.setIdGrupo("6");
			//grupo.setIdInstrumento("kk");	
			permiso.setIdPermiso("7");
			//permisoDao.create(grupo);
			
			//Grupo grupo = permisoDao.findByPrimaryKey("PruebaJose");
			permisoDao.delete(permiso);
						
		} catch (EntryNotFoundException ex) {
			//JC: Entra si no existe entrada con ese nombre
			assertSame(ex.getClass(),EntryNotFoundException.class);
		} catch (IllegalArgumentException ex) {
			//JC: Entra si viene en null o ""
			assertSame(ex.getClass(),IllegalArgumentException.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			assertTrue(false);
		}
	}
	

}


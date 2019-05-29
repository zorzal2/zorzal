package com.fontar.seguridad.ldap;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.ldap.EntryNotFoundException;

import com.fontar.data.impl.dao.ldap.GrupoInstrumentableDao;
import com.fontar.data.impl.domain.ldap.GrupoInstrumentable;

public class GrupoInstrumentableCrudTest extends BaseLdapTest {

	GrupoInstrumentableDao grupoInstrumentableDao;
	
	@Override
	protected void onSetUp() throws Exception {
		grupoInstrumentableDao = (GrupoInstrumentableDao)getBean("grupoInstrumentableLdapDao");
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
		List grupos =  grupoInstrumentableDao.findAll();
		assertTrue(grupos.size() > 0);
	}

	/**
	 * 
	 *
	 */
	public void testCreate(){
		
		Set usuarios = new TreeSet();
		usuarios.add("uid=jcacherosky,ou=People,o=fontar,dc=org");

		Set permisos = new TreeSet();
		permisos.add("ou=ITaccounts,o=fontar,dc=org");
		permisos.add("uid=gboaglio,ou=People,o=fontar,dc=org");
		
		GrupoInstrumentable grupoInstrumentable = new GrupoInstrumentable();
		grupoInstrumentable.setIdGrupo("9");
		//grupoInstrumentable.setIdInstrumento("4");	
		grupoInstrumentable.setNombre("PruebaJose6");
		grupoInstrumentable.setUsuarios(usuarios);
		grupoInstrumentable.setPermisos(permisos);		
		
		try {
			grupoInstrumentableDao.create(grupoInstrumentable);
		} catch (Exception ex) {
			assertSame(ex.getClass(),org.springframework.ldap.UncategorizedLdapException.class);
		}
	}
	
	public void _testFindByPrimaryKey(){
	
		try {
			//GrupoInstrumentable grupo = grupoDao.findByPrimaryKey(null);
			//GrupoInstrumentable grupo = grupoDao.findByPrimaryKey("");
			//GrupoInstrumentable grupo = grupoDao.findByPrimaryKey("pp");
			GrupoInstrumentable grupo = grupoInstrumentableDao.findByPrimaryKey("PruebaJose");
			System.out.println("Nombre GrupoInstrumentable: "+ grupo.getNombre());
			System.out.println("IdGrupo: "+ grupo.getIdGrupo());
			//System.out.println("IdInstrumento: "+ grupo.getIdInstrumento());
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
	
	public void _testModify(){
		
		try {
			//GrupoInstrumentable grupo = grupoDao.findByPrimaryKey(null);
			//GrupoInstrumentable grupo = grupoDao.findByPrimaryKey("");
			//GrupoInstrumentable grupo = grupoDao.findByPrimaryKey("pp");
			GrupoInstrumentable grupo = grupoInstrumentableDao.findByPrimaryKey("PruebaJose6");
			System.out.println("Nombre GrupoInstrumentable: "+ grupo.getNombre());
			System.out.println("IdGrupo: "+ grupo.getIdGrupo());
			//System.out.println("IdInstrumento: "+ grupo.getIdInstrumento());
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
			//grupo.setIdInstrumento("999");
			//grupo.setPermisos(new TreeSet());
			//grupo.setPermisos(null);
			//grupo.setUsuarios(null);
			grupoInstrumentableDao.update(grupo);
			GrupoInstrumentable grupo2 = grupoInstrumentableDao.findByPrimaryKey("PruebaJose");
			System.out.println("Nombre GrupoInstrumentable: "+ grupo2.getNombre());
			System.out.println("IdGrupo: "+ grupo2.getIdGrupo());
			//System.out.println("IdInstrumento: "+ grupo2.getIdInstrumento());
						
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
	
	public void _testDelete(){
		
		try {
			
			GrupoInstrumentable grupo = new GrupoInstrumentable();
			//grupo.setIdGrupo("6");
			//grupo.setIdInstrumento("kk");	
			grupo.setNombre("PruebaJose6");
			//grupoDao.create(grupo);
			
			//GrupoInstrumentable grupo = grupoDao.findByPrimaryKey("PruebaJose");
			grupoInstrumentableDao.delete(grupo);
			/*GrupoInstrumentable grupo2 = grupoDao.findByPrimaryKey("PruebaJose");
			System.out.println("Nombre GrupoInstrumentable: "+ grupo2.getNombre());
			System.out.println("IdGrupoInstrumentable: "+ grupo2.getIdGrupoInstrumentable());
			System.out.println("IdInstrumento: "+ grupo2.getIdInstrumento());*/
						
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


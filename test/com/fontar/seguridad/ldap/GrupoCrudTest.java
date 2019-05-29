package com.fontar.seguridad.ldap;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.ldap.EntryNotFoundException;

import com.fontar.data.impl.dao.ldap.GrupoDao;
import com.fontar.data.impl.domain.ldap.Grupo;

public class GrupoCrudTest extends BaseLdapTest {

	GrupoDao grupoDao;
	
	@Override
	protected void onSetUp() throws Exception {
		grupoDao = (GrupoDao)getBean("grupoLdapDao");
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
		List grupos =  grupoDao.findAll();
		assertTrue(grupos.size() > 0);
	}

	/**
	 * 
	 *
	 */
	public void testCreate(){
		
		Set usuarios = new TreeSet();
		usuarios.add("uid=fferrara,ou=People,o=fontar,dc=org");
		usuarios.add("uid=gboaglio,ou=People,o=fontar,dc=org");

		Set permisos = new TreeSet();
		permisos.add("idPermiso=uid=gboaglio,ou=People,o=fontar,dc=org");
		
		Grupo grupo = new Grupo();
		grupo.setIdGrupo("6");
		//grupo.setIdInstrumento("4");	
		grupo.setNombre("PruebaJose6");
		grupo.setUsuarios(usuarios);
		grupo.setPermisos(permisos);		
		
		try {
			grupoDao.create(grupo);
		} catch (Exception ex) {
			assertSame(ex.getClass(),org.springframework.ldap.UncategorizedLdapException.class);
		}
	}
	
	public void _testFindByPrimaryKey(){
	
		try {
			//Grupo grupo = grupoDao.findByPrimaryKey(null);
			//Grupo grupo = grupoDao.findByPrimaryKey("");
			//Grupo grupo = grupoDao.findByPrimaryKey("pp");
			Grupo grupo = grupoDao.findByPrimaryKey("1");
			System.out.println("Nombre Grupo: "+ grupo.getNombre());
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
			//Grupo grupo = grupoDao.findByPrimaryKey(null);
			//Grupo grupo = grupoDao.findByPrimaryKey("");
			//Grupo grupo = grupoDao.findByPrimaryKey("pp");
			Grupo grupo = grupoDao.findByPrimaryKey("PruebaJose6");
			System.out.println("Nombre Grupo: "+ grupo.getNombre());
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
			grupoDao.update(grupo);
			Grupo grupo2 = grupoDao.findByPrimaryKey("PruebaJose");
			System.out.println("Nombre Grupo: "+ grupo2.getNombre());
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
			
			Grupo grupo = new Grupo();
			//grupo.setIdGrupo("6");
			//grupo.setIdInstrumento("kk");	
			grupo.setNombre("PruebaJose6");
			//grupoDao.create(grupo);
			
			//Grupo grupo = grupoDao.findByPrimaryKey("PruebaJose");
			grupoDao.delete(grupo);
			/*Grupo grupo2 = grupoDao.findByPrimaryKey("PruebaJose");
			System.out.println("Nombre Grupo: "+ grupo2.getNombre());
			System.out.println("IdGrupo: "+ grupo2.getIdGrupo());
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


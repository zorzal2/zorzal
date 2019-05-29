package com.fontar.seguridad.ldap;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.ldap.EntryNotFoundException;

import com.fontar.data.impl.dao.ldap.GrupoConInstrumentoDao;
import com.fontar.data.impl.domain.ldap.GrupoConInstrumento;

public class GrupoConInstrumentoCrudTest extends BaseLdapTest {

	GrupoConInstrumentoDao grupoConInstrumentoDao;
	
	@Override
	protected void onSetUp() throws Exception {
		grupoConInstrumentoDao = (GrupoConInstrumentoDao)getBean("grupoConInstrumentoLdapDao");
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
		List grupos =  grupoConInstrumentoDao.findAll();
		assertTrue(grupos.size() > 0);
	}

	
	public void testGrantedUsers(){
		Set<String> users = this.grupoConInstrumentoDao.usersGranted("WF-EVALUACION-PROYECTO-CARGAR-RESULTADO","195");
		assertTrue(users.size() > 0);
	}
	
	/**
	 * 
	 *
	 */
	public void _testCreate(){
		
		Set usuarios = new TreeSet();
		usuarios.add("uid=gboaglio,ou=People,o=fontar,dc=org");

		GrupoConInstrumento grupo = new GrupoConInstrumento();
		grupo.setIdGrupo("4");
		grupo.setIdInstrumento(204l);	
		grupo.setNombre("GRUPO INSTRMENTO 204");
		//grupo.setUsuarios(usuarios);
		//grupo.setPermisos(permisos);		
		
		try {
			grupoConInstrumentoDao.create(grupo);
		} catch (Exception ex) {
			assertSame(ex.getClass(),org.springframework.ldap.UncategorizedLdapException.class);
		}
	}
	
	public void _testFindByPrimaryKey(){
	
		try {
			//Grupo grupo = grupoDao.findByPrimaryKey(null);
			//Grupo grupo = grupoDao.findByPrimaryKey("");
			//Grupo grupo = grupoDao.findByPrimaryKey("pp");
			GrupoConInstrumento grupo = grupoConInstrumentoDao.findByPrimaryKey("PruebaJose");
			System.out.println("Nombre GrupoConInstrumento: "+ grupo.getNombre());
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
			//GrupoConInstrumento grupo = grupoDao.findByPrimaryKey(null);
			//GrupoConInstrumento grupo = grupoDao.findByPrimaryKey("");
			//GrupoConInstrumento grupo = grupoDao.findByPrimaryKey("pp");
			GrupoConInstrumento grupo = grupoConInstrumentoDao.findByPrimaryKey("PruebaJose6");
			System.out.println("Nombre GrupoConInstrumento: "+ grupo.getNombre());
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
			grupoConInstrumentoDao.update(grupo);
			GrupoConInstrumento grupo2 = grupoConInstrumentoDao.findByPrimaryKey("PruebaJose");
			System.out.println("Nombre GrupoConInstrumento: "+ grupo2.getNombre());
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
			
			GrupoConInstrumento grupo = new GrupoConInstrumento();
			//grupo.setIdGrupo("6");
			//grupo.setIdInstrumento("kk");	
			grupo.setNombre("PruebaJose6");
			//grupoDao.create(grupo);
			
			//GrupoConInstrumento grupo = grupoDao.findByPrimaryKey("PruebaJose");
			grupoConInstrumentoDao.delete(grupo);
			/*GrupoConInstrumento grupo2 = grupoDao.findByPrimaryKey("PruebaJose");
			System.out.println("Nombre GrupoConInstrumento: "+ grupo2.getNombre());
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


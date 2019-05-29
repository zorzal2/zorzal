package com.fontar.seguridad.ldap;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.ldap.EntryNotFoundException;

import com.fontar.data.impl.dao.ldap.UsuarioDao;
import com.fontar.data.impl.domain.ldap.Usuario;

public class UsuarioCrudTest extends BaseLdapTest {

	UsuarioDao usuarioDao;
	
	@Override
	protected void onSetUp() throws Exception {
		usuarioDao = (UsuarioDao)getBean("usuarioLdapDao");
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
		List usuarios =  usuarioDao.findAll();
		assertTrue(usuarios.size() > 0);
	}

	/**
	 * 
	 *
	 */
	public void testCreate(){
		
		Usuario usuario = new Usuario();
		usuario.setUserId("mberra2");
		usuario.setNombre("Marcelo");
		usuario.setApellido("Berra");
		usuario.setPassword("{MD5}SGF/hIlNCntSnXaZnUv3bA==");
		Set grupos = new TreeSet();
		grupos.add("1");
		grupos.add("2");
		usuario.setGrupos(grupos);

		try {
			usuarioDao.create(usuario);
		} catch (Exception ex) {
			assertSame(ex.getClass(),org.springframework.ldap.UncategorizedLdapException.class);
		}
	}
	
	public void testFindByDn(){
	
		try {
			//Grupo grupo = usuarioDao.findByPrimaryKey(null);
			//Grupo grupo = usuarioDao.findByPrimaryKey("");
			//Grupo grupo = usuarioDao.findByPrimaryKey("pp");
			Usuario usuario = usuarioDao.findByDn("uid=jcacherosky,ou=Usuarios,o=fontar,dc=org");
			//Usuario usuario = usuarioDao.findByPrimaryKey("jcacherosky");			
			/*System.out.println("Nombre Grupo: "+ grupo.getNombre());
			System.out.println("IdGrupo: "+ grupo.getIdGrupo());
			System.out.println("IdInstrumento: "+ grupo.getIdInstrumento());*/
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
			//Grupo grupo = usuarioDao.findByPrimaryKey(null);
			//Grupo grupo = usuarioDao.findByPrimaryKey("");
			//Grupo grupo = usuarioDao.findByPrimaryKey("pp");
			Usuario grupo = usuarioDao.findByPrimaryKey("PruebaJose6");
			/*
			grupo.setIdGrupo("999");
			grupo.setIdInstrumento("999");
			//grupo.setUsuarios(new TreeSet());
			//grupo.setUsuarios(null);
			//grupo.setUsuarios(null);
			usuarioDao.update(grupo);
			Grupo grupo2 = usuarioDao.findByPrimaryKey("PruebaJose");
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
	
	public void _testDelete(){
		
		try {
			
			Usuario usuario = new Usuario();
			//grupo.setIdGrupo("6");
			//grupo.setIdInstrumento("kk");	
			usuario.setUserId("7");
			//usuarioDao.create(grupo);
			
			//Grupo grupo = usuarioDao.findByPrimaryKey("PruebaJose");
			usuarioDao.delete(usuario);
						
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


package com.fontar.seguridad.cripto;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Collection;
import java.util.HashSet;

import junit.framework.TestCase;

public class FontarCryptoService extends TestCase {

	
	
	FontarCryptographicService service;

	PrivateKey privateKey = null;
	

	protected void setUp() throws Exception {
		this.service = new FontarCryptographicService();
		this.service.setPrivateKeysLocation("C:\\fontar\\claves\\");
		//this.service.setPrivateKeysSaltLocation("C:\\fontar\\claves\\appPrivKey.key");
		this.service.setApplicationPrivateKeyLocation("C:\\fontar\\claves\\appPrivKey.key");
		this.service.setApplicationPublicKeyLocation("C:\\fontar\\claves\\appPubKey.key");
		//this.service.setKeyGenerationMethod("RSA");
		Collection<String> encryptionData = new HashSet<String>();
		encryptionData.add("ProyectoBean");
	}


	/**
	 * Ejecuta los diferentes test
	 * Ver como ahcer el testsuite y especificar los metodos que se quieren correr
	 * **/
	public void test(){
	
		this.loadApplicationPublicKey();
	}

	private void initializeEncryptionData() {
		this.loadApplicationPublicKey();
		//this.service.initialiazeRequiredEncryptionData();
	}


	public void createPrivateKey(){
		KeyPair keyPair = this.service.generateUserKeyPar();
		this.service.saveUserTmpPrivateKey("martin2",keyPair.getPrivate());
	}
	
	public void loadTmpPrivateKey(){
		PrivateKey privateKey;
		try {
			privateKey = this.service.loadUserTmpPrivateKey("martin2");
			assertNotNull( privateKey);
		}
		catch (PasswordInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void encryptPrivateKey(){
		this.service.encryptTmpPrivateKey("martin2","tinchus");
	}
	
	public void loadPrivateKey(){
		PrivateKey privateKey;
		try {
			privateKey = this.service.loadUserPrivateKey("martin2","tinchus");
			assertNotNull( privateKey);
		}
		catch (PasswordInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void loadApplicationPublicKey(){
		PublicKey publicKey = this.service.getApplicationPublicKey();
		assertNotNull( publicKey );
	}


	
	
}

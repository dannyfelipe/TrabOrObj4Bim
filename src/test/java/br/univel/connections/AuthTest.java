package br.univel.connections;

import static org.junit.Assert.*;

import org.junit.Test;

public class AuthTest {

	@Test
	public void testSenhaCerta() {
		assertTrue(new Auth().usuarioValido("admin", "123") );
	}
	
	@Test
	public void testSenhaErrada() {
		assertFalse(new Auth().usuarioValido("admin", "1234") );
	}

}

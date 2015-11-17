package br.univel.connections;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConexaoBDTest {

	@Test
	public void testConOpen() {
		assertNotNull("Não foi possível conectar-se ao banco de dados.", ConexaoBD.getInstace().conOpen());
		ConexaoBD.getInstace().conClose();
	}

	@Test
	public void testConClose() {
		ConexaoBD.getInstace().conOpen();
		assertTrue("Não foi possível fechar a conexão com o banco de dados.", ConexaoBD.getInstace().conClose());
	}

}

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
		assertNotNull("N�o foi poss�vel conectar-se ao banco de dados.", ConexaoBD.getInstace().conOpen());
		ConexaoBD.getInstace().conClose();
	}

	@Test
	public void testConClose() {
		ConexaoBD.getInstace().conOpen();
		assertTrue("N�o foi poss�vel fechar a conex�o com o banco de dados.", ConexaoBD.getInstace().conClose());
	}

}

package br.univel.connections;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.univel.Venda;

public class DaoVendaTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsert() {
		assertEquals("Erro. Venda não cadastrada.", 1,
		
		new DaoVenda().insert(new Venda(1, 1, "teste", "teste", BigDecimal.valueOf(16.99), BigDecimal.valueOf(17.00), BigDecimal.valueOf(0.01), "12/11/2015", "09:31:41")));
		new Cleaner().resetar("VENDA");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		new DaoVenda().insert(new Venda(1, 1, "teste", "teste", BigDecimal.valueOf(16.99), BigDecimal.valueOf(17.00), BigDecimal.valueOf(0.01), "12/11/2015", "09:31:41"));
		assertEquals("Erro. VEnda não deletada.", 1, new DaoVenda().delete(1));
		
		new Cleaner().resetar("VENDA");
	}

	@Test
	public void testSearch() {
		new DaoVenda().insert(new Venda(1, 1, "teste", "teste", BigDecimal.valueOf(16.99), BigDecimal.valueOf(17.00), BigDecimal.valueOf(0.01), "12/11/2015", "09:31:41"));
		assertNotNull("Erro. Não foi possível buscar uma venda.", new DaoVenda().search(1));
		
		new Cleaner().resetar("VENDA");
	}

	@Test
	public void testListar() {
		new DaoVenda().insert(new Venda(1, 1, "teste", "teste", BigDecimal.valueOf(16.99), BigDecimal.valueOf(17.00), BigDecimal.valueOf(0.01), "12/11/2015", "09:31:41"));
		assertNotNull("Erro. Não foi possível listar as vendas.", new DaoVenda().listar());
		
		new Cleaner().resetar("VENDA");
	}

	@Test
	public void testGetCon() {
		assertNotNull("Erro. Não foi possível conectar ao banco.", new DaoVenda().getCon());
	}

}

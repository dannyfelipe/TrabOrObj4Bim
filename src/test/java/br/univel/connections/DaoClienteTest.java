package br.univel.connections;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.univel.Cliente;
import br.univel.Estado;
import br.univel.Genero;

public class DaoClienteTest {

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
		assertEquals("Erro. Cliente não cadastrado.", 1,
				new DaoCliente().insert(new Cliente("TEST NAME INSERT", "328472378427",
						"TESTE AVENUE", "TEST CITY", Estado.PR, "teste@teste.test",
						Genero.M)));
		new Cleaner().resetar("CLIENTE");
	}

	@Test
	public void testUpdate() {
		new DaoCliente().insert(new Cliente("TEST NAME UPDATE INSERT", "234724292423", "TEST AVENUE", "TEST CITY", Estado.PR, "teste@teste.com", Genero.M));
		assertEquals("Erro. Cliente não atualizado.", 1, 
		
		new DaoCliente().update(new Cliente(1, "TEST NAME UPDATE", "2384762864","TEST AVENUE", "TEST CITY", Estado.PR, "teste@teste.test", Genero.M)));
		new Cleaner().resetar("CLIENTE");
	}

	@Test
	public void testDelete() {
		new DaoCliente().insert(new Cliente("TEST NAME DELETE INSERT", "234748237", "TEST AVENUE", "TEST CITY", Estado.PR, "teste@teste.test",Genero.M));
		assertEquals("Erro. Cliente não deletado.", 1, new DaoCliente().delete(1));
		
		new Cleaner().resetar("CLIENTE");
	}

	@Test
	public void testSearch() {
		new DaoCliente().insert(new Cliente("TEST NAME SEARCH INSERT", "983432472324", "TEST AVENUE", "TEST CITY", Estado.PR, "teste@teste.test", Genero.M));
		assertNotNull("Erro. Não foi possível buscar um cliente.", new DaoCliente().search(1));
		
		new Cleaner().resetar("CLIENTE");
	}

	@Test
	public void testListar() {
		new DaoCliente().insert(new Cliente("TEST NAME LIST INSERT", "2432387468", "TEST AVENUE", "TEST CITY", Estado.PR, "teste@teste.test", Genero.M));
		assertNotNull("Erro. Não foi possível listar os clientes.", new DaoCliente().listar());
		
		new Cleaner().resetar("CLIENTE");
	}

	@Test
	public void testGetCon() {
		assertNotNull("Erro. Não foi possível conectar ao banco.", new DaoCliente().getCon());
	}

}

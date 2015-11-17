package br.univel.connections;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.univel.Cliente;
import br.univel.Estado;
import br.univel.Genero;
import br.univel.Produto;

public class DaoProdutoTest {

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
		assertEquals("Erro. Produto não cadastrado.", 1,
		
		new DaoProduto().insert(new Produto(1, 1123123123, "TEST PRODUCT", "TEST PRODUCT DESCRIPTION", 2, BigDecimal.valueOf(54.7), BigDecimal.valueOf(43.6))) );
		
		new Cleaner().resetar("PRODUTO");
	}

	@Test
	public void testUpdate() {
		new DaoProduto().insert(new Produto(1, 123123123, "TEST PRODUCT", "TEST PRODUCT DESCRIPTION", 2, BigDecimal.valueOf(67.4), BigDecimal.valueOf(56.4)));
		assertEquals("Erro. Produto não atualizado.", 1,
		
		new DaoProduto().update(new Produto(1, 1231231123, "TEST PRODUCT", "TEST PRODUCT DESCRIPTION", 2, BigDecimal.valueOf(57.7), BigDecimal.valueOf(34.6))) );
		
		new Cleaner().resetar("PRODUTO");
	}

	@Test
	public void testDelete() {
		new DaoProduto().insert(new Produto(1, 234234234, "TEST PRODUCT", "TEST PRODUCT DESCRIPTION", 2, BigDecimal.valueOf(34.4), BigDecimal.valueOf(45.3)));
		assertEquals("Erro. Produto não deletado.", 1, new DaoProduto().delete(1) );
		
		new Cleaner().resetar("PRODUTO");
	}

	@Test
	public void testSearch() {
		new DaoProduto().insert(new Produto(1, 234234234, "TEST PRODUCT", "TEST PRODUCT DESCRIPTION", 2, BigDecimal.valueOf(75.4), BigDecimal.valueOf(64.3)));
		assertNotNull("Erro. Não foi possível buscar um produto.", new DaoProduto().search(1));
		
		new Cleaner().resetar("PRODUTO");
	}

	@Test
	public void testListar() {
		new DaoProduto().insert(new Produto(1, 234234234, "TEST PRODUCT", "TEST PRODUCT DESCRIPTION", 2, BigDecimal.valueOf(78.4), BigDecimal.valueOf(57.3)));
		assertNotNull("Erro. Não foi possível listar os produtos.", new DaoProduto().listar());
		
		new Cleaner().resetar("PRODUTO");
	}

	@Test
	public void testGetCon() {
		assertNotNull("Erro. Não foi possível conectar ao banco.", new DaoCliente().getCon());
	}

}

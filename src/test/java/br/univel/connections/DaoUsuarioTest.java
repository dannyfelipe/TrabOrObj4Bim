package br.univel.connections;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.univel.Usuario;

public class DaoUsuarioTest {

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
		Usuario u = new Usuario();
		u.setId_u(2);
		u.setCliente_id(2);
		u.setCliente("teste");
		u.setPassword("teste");
		assertEquals("Erro. Usu�rio n�o cadastrado.", 1, new DaoUsuario().insert(u));
		new Cleaner().resetar("USUARIO");
	}

	@Test
	public void testUpdate() {
		Usuario u = new Usuario();
		u.setId_u(2);
		u.setCliente_id(2);
		u.setCliente("teste");
		u.setPassword("teste");
		
		new DaoUsuario().insert(u);
		u.setCliente("teste1");
		u.setPassword("teste1");
		assertEquals("Erro. Usu�rio n�o atualizado.", 1, new DaoUsuario().update(u));
		new Cleaner().resetar("USUARIO");
	}

	@Test
	public void testDelete() {
		Usuario u = new Usuario();
		u.setId_u(2);
		u.setCliente_id(2);
		u.setCliente("teste");
		u.setPassword("teste");
		new DaoUsuario().insert(u);
		assertEquals("Erro. Usu�rio n�o deletado.", 1, new DaoUsuario().delete(2));
		new Cleaner().resetar("USUARIO");
	}

	@Test
	public void testSearch() {
		assertNotNull("Erro. N�o foi poss�vel buscar um usu�rio.", new DaoUsuario().search(1));
	}

	@Test
	public void testListar() {
		assertNotNull("Erro. N�o foi poss�vel listar os usu�rios.", new DaoUsuario().listar());
	}

	@Test
	public void testGetCon() {
		assertNotNull("Erro. N�o foi poss�vel conectar ao banco.", new DaoUsuario().getCon());
	}

}

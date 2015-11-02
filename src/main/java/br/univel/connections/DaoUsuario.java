package br.univel.connections;

/**
 * @author Danny Felipe, 02/11/2015 - 00:53:47
 * 
 * Classe DaoCliente
 * Implementa todas as ações do CRUD para a classe Cliente
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.Usuario;

public class DaoUsuario {

	private PreparedStatement ps = null;
	private Statement st = null;
	private ResultSet rs = null;
	private Usuario u = null;
	private List<Usuario> lista = null;
	private Connection con = ConexaoBD.getInstace().conOpen();

	/*
	 * Método para inserir um novo cliente na base de dados
	 */
	public void insert(Usuario u) {
		try {
			ps = con.prepareStatement("INSERT INTO USUARIO (CLIENTE_ID, CLIENTE, PASSWORD) VALUES (?, ?, ?)");
			ps.setInt(1, u.getCliente_id());
			ps.setString(2, u.getCliente());
			ps.setString(3, u.getPassword());
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Método para atualizar os dados do usuário na base de dados
	 */
	public void update(Usuario u) {
		try {
			ps = con.prepareStatement("UPDATE USUARIO SET CLIENTE_ID = ?, CLIENTE = ?, PASSWORD =? " +
										"WHERE ID_U" + u.getId_u());
			ps.setInt(1, u.getCliente_id());
			ps.setString(2, u.getCliente());
			ps.setString(3, u.getPassword());
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Método para excluir um usuário da base de dados
	 */
	public void delete(int id_u) {
		try {
			ps = con.prepareStatement("DELETE FROM USUARIO WHERE ID_U = " + id_u);
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Método para buscar um usuario na base de dados
	 */
	public Usuario search(int id_u) {
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT CLIENTE_ID, CLIENTE, PASSWORD FROM USUARIO WHERE ID_U = " + id_u);
			rs.next();
			if (rs.getString("USUARIO") != null) {
				u = new Usuario();
				u.setId_u(id_u);
				u.setCliente_id(rs.getInt("CLIENTE_ID"));
				u.setCliente(rs.getString("CLIENTE"));
				u.setPassword(rs.getString("PASSWORD"));
				rs.close();
				st.close();
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * Método para listar todos os usuarios da base de dados
	 */
	public List<Usuario> listar() {
		lista = new ArrayList<Usuario>();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT ID_U, CLIENTE_ID, CLIENTE, PASSWORD FROM USUARIO");
			while (rs.next()) {				
				u = new Usuario();
				u.setId_u(rs.getInt("ID_U"));
				u.setCliente_id(rs.getInt("CLIENTE_ID"));
				u.setCliente(rs.getString("CLIENTE"));
				u.setPassword(rs.getString("PASSWORD"));
				lista.add(u);
			}
			rs.close();
			st.close();
			if (lista != null)
				return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 *  Método para retornar o tipo de conexão
	 */
	public Connection getCon() {
		return con;
	}

}

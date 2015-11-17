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

import br.univel.Cliente;
import br.univel.Estado;
import br.univel.Genero;

public class DaoCliente {

	private PreparedStatement ps = null;
	private Statement st = null;
	private ResultSet rs = null;
	private Cliente c = null;
	private List<Cliente> lista = null;
	private Connection con = ConexaoBD.getInstace().conOpen();

	/*
	 * Método para inserir um novo cliente na base de dados
	 */
	public int insert(Cliente c) {
		try {
			ps = con.prepareStatement("INSERT INTO CLIENTE (NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO) VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, c.getNome());
			ps.setString(2, c.getTelefone());
			ps.setString(3, c.getEndereco());
			ps.setString(4, c.getCidade());
			ps.setString(5, c.getEstado().name());
			ps.setString(6, c.getEmail());
			ps.setString(7, c.getGenero().name());
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso.");
			
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/*
	 * Método para atualizar os dados do cliente na base de dados
	 */
	public int update(Cliente c) {
		try {
			ps = con.prepareStatement("UPDATE CLIENTE SET NOME = ?,"
					+ " TELEFONE = ?, ENDERECO = ?, CIDADE = ?, ESTADO = ?,"
					+ " EMAIL = ?, GENERO = ? WHERE ID_C = " + c.getId_c());
			ps.setString(1, c.getNome());
			ps.setString(2, c.getTelefone());
			ps.setString(3, c.getEndereco());
			ps.setString(4, c.getCidade());
			ps.setString(5, c.getEstado().name());
			ps.setString(6, c.getEmail());
			ps.setString(7, c.getGenero().name());
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso.");
			
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/*
	 * Método para excluir um cliente da base de dados
	 */
	public int delete(int id_c) {
		try {
			ps = con.prepareStatement("DELETE FROM CLIENTE WHERE ID_C =" + id_c);
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso.");
			
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/*
	 * Método para buscar um cliente na base de dados
	 */
	public Cliente search(int id_c) {
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO "
					+ "FROM CLIENTE WHERE ID_C = " + id_c);
			rs.next();
			if (rs.getString("NOME") != null) {
				c = new Cliente(
						rs.getString("NOME"),
						rs.getString("TELEFONE"),
						rs.getString("ENDERECO"),
						rs.getString("CIDADE"),
						Estado.valueOf(Estado.class, rs.getString("ESTADO")),
						rs.getString("EMAIL"),
						Genero.valueOf(Genero.class, rs.getString("GENERO"))
						);
			}
			rs.close();
			st.close();
			
			if (c != null) {
				return c;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * Método para listar todos os clientes da base de dados
	 */
	public List<Cliente> listar() {
		lista = new ArrayList<Cliente>();
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT ID_C, NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO "
					+ "FROM CLIENTE");
			
			while (rs.next()) {
				lista.add(c = new Cliente(
						rs.getInt("ID_C"),
						rs.getString("NOME"),
						rs.getString("TELEFONE"),
						rs.getString("ENDERECO"),
						rs.getString("CIDADE"),
						Estado.valueOf(Estado.class, rs.getString("ESTADO")),
						rs.getString("EMAIL"),
						Genero.valueOf(Genero.class,
						rs.getString("GENERO")
						)
					)
				);
			}
			rs.close();
			st.close();
			
			if (lista != null) {
				return lista;
			}

		} catch (Exception e) {
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

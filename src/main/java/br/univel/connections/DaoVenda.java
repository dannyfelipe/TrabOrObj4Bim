package br.univel.connections;

/**
 * @author Danny Felipe, 02/11/2015 - 13:36:27
 * 
 * Classe DaoVenda
 * Implementa todas as ações do CRUD para a classe Venda
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.Venda;

public class DaoVenda {

	private PreparedStatement ps = null;
	private Statement st = null;
	private ResultSet rs = null;
	private Venda v = null;
	private List<Venda> lista = null;
	private Connection con = ConexaoBD.getInstace().conOpen();

	/*
	 * Método para efetuar uma nova venda na base de dados
	 */
	public int insert(Venda v) {
		try {
			ps = con.prepareStatement("INSERT INTO VENDA (CLIENTE_ID, CLIENTE, PRODUTO_ID, PRODUTO, VTOTAL, VPAGAMENTO, TROCO, DATA, HORA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, v.getCliente_id());
			ps.setString(2, v.getCliente());
			ps.setInt(3, v.getProduto_id());
			ps.setString(4, v.getProduto());
			ps.setBigDecimal(5, v.getVtotal());
			ps.setBigDecimal(6, v.getVpagamento());
			ps.setBigDecimal(7, v.getTroco());
			//ps.setDate(8, v.getData());
			ps.setString(8, v.getData());
			//ps.setTime(9, v.getHora());
			ps.setString(9, v.getHora());
			
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Venda efetuada com sucesso.");
			
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/*
	 * Método para atualizar os dados da venda na base de dados
	 */
	public int update(Venda v) {
		try {
			ps = con.prepareStatement("UPDATE VENDA SET CLIENTE_ID = ?, CLIENTE = ?"
					+ " PRODUTO_ID = ?, PRODUTO = ?, VTOTAL = ?, VPAGAMENTO = ?,"
					+ " TROCO = ?, DATA = ?, HORA = ? WHERE ID_V = " + v.getId_v());
			ps.setInt(1, v.getCliente_id());
			ps.setString(2, v.getCliente());
			ps.setInt(3, v.getProduto_id());
			ps.setString(4, v.getProduto());
			ps.setBigDecimal(5, v.getVtotal());
			ps.setBigDecimal(6, v.getVpagamento());
			ps.setBigDecimal(7, v.getTroco());
			//ps.setDate(8, v.getData());
			ps.setString(8, v.getData());
			//ps.setTime(9, v.getHora());
			ps.setString(9, v.getHora());
			
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Venda atualizada com sucesso.");
			
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/*
	 * Método para excluir uma venda da base de dados
	 */
	public int delete(int id_v) {
		try {
			ps = con.prepareStatement("DELETE FROM VENDA WHERE ID_V =" + id_v);
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Venda excluída com sucesso.");
			
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/*
	 * Método para buscar uma venda na base de dados
	 */
	public Venda search(int id_v) {
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT CLIENTE_ID, CLIENTE, PRODUTO_ID, PRODUTO, VTOTAL, VPAGAMENTO, TROCO, DATA, HORA "
					+ "FROM VENDA WHERE ID_V = " + id_v);
			rs.next();
			
			if (rs.getString("CLIENTE") != null) {
				v = new Venda(
						rs.getInt("CLIENTE_ID"),
						rs.getInt("PRODUTO_ID"),
						rs.getString("CLIENTE"),
						rs.getString("PRODUTO"),
						rs.getBigDecimal("VTOTAL"),
						rs.getBigDecimal("VPAGAMENTO"),
						rs.getBigDecimal("TROCO"),
						rs.getString("DATA"),
						rs.getString("HORA")
						);
			}
			
			rs.close();
			st.close();
			
			if (v != null) {
				return v;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * Método para listar todos as vendas da base de dados
	 */
	public List<Venda> listar() {
		lista = new ArrayList<Venda>();
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT ID_V, CLIENTE_ID, CLIENTE, PRODUTO_ID, PRODUTO, VTOTAL, VPAGAMENTO, TROCO, DATA, HORA "
					+ "FROM VENDA");

			while (rs.next()) {
				lista.add(v = new Venda(
						rs.getInt("ID_V"),
						rs.getInt("CLIENTE_ID"),
						rs.getInt("PRODUTO_ID"),
						rs.getString("CLIENTE"),
						rs.getString("PRODUTO"),
						rs.getBigDecimal("VTOTAL"),
						rs.getBigDecimal("VPAGAMENTO"),
						rs.getBigDecimal("TROCO"),
						rs.getString("DATA"),
						rs.getString("HORA")
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

package br.univel.connections;

/**
 * 
 * @author Danny Felipe, 02/11/2015 - 03:23:51
 * 
 * Classe DaoProduto
 * Implementa todas as a��es do CRUD para a classe Produto
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.Produto;

public class DaoProduto {

	private PreparedStatement ps = null;
	private Statement st = null;
	private ResultSet rs = null;
	private Produto p = null;
	private List<Produto> lista = null;
	private Connection con = ConexaoBD.getInstace().conOpen();
	
	/*
	 * M�todo para inserir um novo produto na base de dados
	 */
	public int insert(Produto p) {
		try {
			ps = con.prepareStatement("INSERT INTO PRODUTO (BARCODE, CATEGORIA, DESCRICAO, UNIDADE, CUSTO, MLUCRO) VALUES (?, ?, ?, ?, ?, ?)");
			ps.setInt(1, p.getBarcode());
			ps.setString(2, p.getCategoria());
			ps.setString(3, p.getDescricao());
			ps.setInt(4, p.getUnidade());
			ps.setBigDecimal(5, p.getCusto());
			ps.setBigDecimal(6, p.getMlucro());
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso.");
			
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/*
	 * M�todo para atualizar os dados do produto na base de dados
	 */
	public int update(Produto p) {
		try {
			ps = con.prepareStatement("UPDATE PRODUTO SET BARCODE = ?, CATEGORIA = ?, DESCRICAO = ?,"
					+ " UNIDADE = ?, CUSTO = ?, MLUCRO = ? WHERE ID_P = " + p.getId_p());
			ps.setInt(1, p.getBarcode());
			ps.setString(2, p.getCategoria());
			ps.setString(3, p.getDescricao());
			ps.setInt(4, p.getUnidade());
			ps.setBigDecimal(5, p.getCusto());
			ps.setBigDecimal(6, p.getMlucro());
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso.");
			
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}
	
	/*
	 * M�todo para excluir um produto da base de dados
	 */
	public int delete(int id_p) {
		try {
			ps = con.prepareStatement("DELETE FROM PRODUTO WHERE ID_P =" + id_p);
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Produto exclu�do com sucesso.");
			
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/*
	 * M�todo para buscar um produto na base de dados
	 */
	public Produto search(int id_p) {
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT BARCODE, CATEGORIA, DESCRICAO, UNIDADE, CUSTO, MLUCRO "
					+ "FROM PRODUTO WHERE ID_P = " + id_p);
			rs.next();
			if (rs.getString("BARCODE") != null) {
				p = new Produto(
						id_p,
						rs.getInt("BARCODE"),
						rs.getString("CATEGORIA"),
						rs.getString("DESCRICAO"),
						rs.getInt("UNIDADE"),
						rs.getBigDecimal("CUSTO"),
						rs.getBigDecimal("MLUCRO"));
			}
			rs.close();
			st.close();
			
			if (p != null) {
				return p;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * M�todo para listar todos os produtos da base de dados
	 */
	public List<Produto> listar() {
		lista = new ArrayList<Produto>();
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT ID_P, BARCODE, CATEGORIA, DESCRICAO, UNIDADE, CUSTO, MLUCRO "
					+ "FROM PRODUTO");
			
			while (rs.next()) {
				lista.add(p = new Produto(
						rs.getInt("ID_P"),
						rs.getInt("BARCODE"),
						rs.getString("CATEGORIA"),
						rs.getString("DESCRICAO"),
						rs.getInt("UNIDADE"),
						rs.getBigDecimal("CUSTO"),
						rs.getBigDecimal("MLUCRO")
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
	 *  M�todo para retornar o tipo de conex�o
	 */
	public Connection getCon() {
		return con;
	}

}

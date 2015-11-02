package br.univel.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.Produto;

/**
 * 
 * @author Danny Felipe, 02/11/2015 - 03:23:51
 * 
 * Classe DaoProduto
 * Implementa todas as ações do CRUD para a classe Produto
 */

public class DaoProduto {

	private PreparedStatement ps = null;
	private Statement st = null;
	private ResultSet rs = null;
	private Produto p = null;
	private List<Produto> lista = null;
	private Connection con = ConexaoBD.getInstace().conOpen();
	
	/*
	 * Método para inserir um novo produto na base de dados
	 */
	public void insert(Produto pd) {
		try {
			ps = con.prepareStatement("INSERT INTO PRODUTO (BARCODE, CATEGORIA, DESCRICAO, UNIDADE, CUSTO, MLUCRO) VALUES (?, ?, ?, ?, ?, ?)");
			ps.setInt(1, pd.getBarcode());
			ps.setString(2, pd.getCategoria());
			ps.setString(3, pd.getDescricao());
			ps.setString(4, pd.getUnidade());
			ps.setBigDecimal(5, pd.getCusto());
			ps.setBigDecimal(6, pd.getMlucro());
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Método para atualizar os dados do produto na base de dados
	 */
	public void update(Produto p) {
		try {
			ps = con.prepareStatement("UPDATE PRODUTO SET BARCODE = ?, CATEGORIA = ?, DESCRICAO = ?,"
					+ " UNIDADE = ?, CUSTO = ?, MLUCRO = ? WHERE ID_P = " + p.getId_p());
			ps.setInt(1, p.getBarcode());
			ps.setString(2, p.getCategoria());
			ps.setString(3, p.getDescricao());
			ps.setString(4, p.getUnidade());
			ps.setBigDecimal(5, p.getCusto());
			ps.setBigDecimal(6, p.getMlucro());
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/*
	 * Método para excluir um produto da base de dados
	 */
	public void delete(int id_p) {
		try {
			ps = con.prepareStatement("DELETE FROM PRODUTO WHERE ID_P =" + id_p);
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Produto excluído com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Método para buscar um produto na base de dados
	 */
	public Produto search(int id_p) {
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT BARCODE, CATEGORIA, DESCRICAO, UNIDADE, CUSTO, MLUCRO "
					+ "FROM PRODUTO WHERE COD_P = " + id_p);
			rs.next();
			if (rs.getString("NOME") != null) {
				p = new Produto(id_p, rs.getInt("BARCODE"),
						rs.getString("CATEGORIA"), rs.getString("DESCRICAO"),
						rs.getString("UNIDADE"), rs.getBigDecimal("CUSTO"),
						rs.getBigDecimal("MLUCRO"));
			}
			rs.close();
			st.close();
			return p;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * Método para listar todos os produtos da base de dados
	 */
	public List<Produto> listar() {
		lista = new ArrayList<Produto>();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT ID_P, BARCODE, CATEGORIA, DESCRICAO, UNIDADE, CUSTO, MLUCRO "
					+ "FROM PRODUTO");
			while (rs.next()) {
				lista.add(p = new Produto(rs.getInt("ID_P"), rs
						.getInt("BARCODE"), rs.getString("CATEGORIA"), rs
						.getString("DESCRICAO"), rs.getString("UNIDADE"), rs
						.getBigDecimal("CUSTO"), rs
						.getBigDecimal("MLUCRO")));
			}
			rs.close();
			st.close();
			if (lista != null)
				return lista;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 *  Método para retornar o tipo de coneção
	 */
	public Connection getCon() {
		return con;
	}

}

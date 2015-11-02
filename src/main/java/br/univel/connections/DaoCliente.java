package br.univel.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.Cliente;

public class DaoCliente {
	
	private PreparedStatement ps = null;
	private Statement st = null;
	private ResultSet rs = null;
	private Cliente c = null;
	private List<Cliente> lista = null;
	private Connection con = ConexaoBD.getInstace().conOpen();

	public void inserir(Cliente c) {
		try {
			ps = con.prepareStatement("INSERT INTO CLIENTE (NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO) VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, c.getNome());
			ps.setString(2, c.getTelefone());
			ps.setString(3, c.getEndereco());
			ps.setString(4, c.getCidade());
			ps.setString(5, c.getEstado().name());
			ps.setString(6, c.getEmail());
			ps.setString(7, c.getGenero().name());
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Cliente: " + c.getNome()
					+ "\n Cadastrado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package br.univel;

/**
 * @author Danny Felipe, 02/11/2015 - 01:20:39
 * 
 * Table model Cliente
 * Contém todas as informações para exibição dos dados do cliente
 * no formulário de cadastro
 */

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.connections.DaoCliente;

public class ClienteTable extends AbstractTableModel {

	List<Cliente> lista = new ArrayList<>();

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub

		Cliente o = lista.get(row);
		switch (col) {
		case 0:
			return o.getId_c();
		case 1:
			return o.getNome();
		case 2:
			return o.getTelefone();
		case 3:
			return o.getEndereco();
		case 4:
			return o.getCidade();
		case 5:
			return o.getEstado().getNome();
		case 6:
			return o.getEmail();
		case 7:
			return o.getGenero();
		default:
			return "";
		}
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "CÓD.";
		case 1:
			return "NOME";
		case 2:
			return "TELEFONE";
		case 3:
			return "ENDEREÇO";
		case 4:
			return "CIDADE";
		case 5:
			return "ESTADO";
		case 6:
			return "E-MAIL";
		case 7:
			return "GÊNERO";
		default:
			return "";
		}
	}
	
	/*
	 * Lista todos os clientes através do método Listar da classe DaoCliente
	 */
	public List<Cliente> listar(){
		DaoCliente c = new DaoCliente();
		return lista = c.listar();
	}
	
	/*
	 * Adiciona um cliente na lista e atualiza a tabela
	 */
	public void addList(Cliente c){
		this.lista.add(c);
		this.fireTableStructureChanged();
	}
	
	/*
	 * Atualiza um cliente na lista e atualiza a tabela
	 */
	public void updateList(int index, Cliente c){
		lista.set(index, c);
		this.fireTableStructureChanged();
	}
	
	/*
	 * Deleta um cliente na lista e atualiza a tabela
	 */
	public void delete(int index){
		lista.remove(index);
		this.fireTableStructureChanged();
	}

}

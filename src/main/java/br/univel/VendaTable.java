package br.univel;

/**
 * @author Danny Felipe, 02/11/2015 - 13:35:15
 * 
 * Table model venda
 * Contém todas as informações para exibição dos dados da venda
 * no formulário de cadastro
 */

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.connections.DaoVenda;

public class VendaTable extends AbstractTableModel {

	List<Venda> lista = new ArrayList<>();

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub

		Venda v = lista.get(row);
		switch (col) {
		case 0:
			return v.getId_v();
		case 1:
			return v.getCliente_id();
		case 2:
			return v.getCliente();
		case 3:
			return v.getProduto_id();
		case 4:
			return v.getProduto();
		case 5:
			return v.getVtotal();
		case 6:
			return v.getVpagamento();
		case 7:
			return v.getTroco();
		case 8:
			return v.getData();
		case 9:
			return v.getHora();
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
			return "CÓD. CLIENTE";
		case 2:
			return "CLIENTE";
		case 3:
			return "CÓD. PRODUTO";
		case 4:
			return "PRODUTO";
		case 5:
			return "VALOR TOTAL";
		case 6:
			return "VALOR PAGAMENTO";
		case 7:
			return "TROCO";
		case 8:
			return "DATA";
		case 9:
			return "HORA";
		default:
			return "";
		}
	}
	
	/*
	 * Lista todos os clientes através do método Listar da classe DaoCliente
	 */
	public List<Venda> listar(){
		DaoVenda v = new DaoVenda();
		return lista = v.listar();
	}
	
	/*
	 * Adiciona uma venda na lista e atualiza a tabela
	 */
	public void addList(List<Venda> v){
		this.lista = v;
		this.fireTableStructureChanged();
	}
	
	/*
	 * Atualiza uma venda na lista e atualiza a tabela
	 */
	public void updateList(int index, Venda v){
		lista.set(index, v);
		this.fireTableStructureChanged();
	}
	
	/*
	 * Deleta uma venda na lista e atualiza a tabela
	 */
	public void delete(int index){
		lista.remove(index);
		this.fireTableStructureChanged();
	}

	
}

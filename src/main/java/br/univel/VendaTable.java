package br.univel;

/**
 * @author Danny Felipe, 02/11/2015 - 13:35:15
 * 
 * Table model venda
 * Cont�m todas as informa��es para exibi��o dos dados da venda
 * no formul�rio de cadastro
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
		case 2:
			return v.getCliente();
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
			return "C�D.";
		case 1:
			return "CLIENTE";
		case 2:
			return "PRODUTO";
		case 3:
			return "VALOR TOTAL";
		case 4:
			return "VALOR PAGAMENTO";
		case 5:
			return "TROCO";
		case 6:
			return "DATA";
		case 7:
			return "HORA";
		default:
			return "";
		}
	}
	
	/*
	 * Lista todos os clientes atrav�s do m�todo Listar da classe DaoCliente
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

package br.univel;

/**
 * @author Danny Felipe, 02/11/2015 - 03:34:18
 * 
 * Table model Produto
 * Contém todas as informações para exibição dos dados do produto
 * no formulário de cadastro
 */

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.connections.DaoProduto;

public class ProdutoTable extends AbstractTableModel {

	List<Produto> lista = new ArrayList<>();

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub

		Produto p = lista.get(row);
		switch (col) {
		case 0:
			return p.getId_p();
		case 1:
			return p.getBarcode();
		case 2:
			return p.getCategoria();
		case 3:
			return p.getDescricao();
		case 4:
			return p.getUnidade();
		case 5:
			return p.getCusto();
		case 6:
			return p.getMlucro();
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
			return "CÓD_BARRA";
		case 2:
			return "CATEGORIA";
		case 3:
			return "DESCRIÇÃO";
		case 4:
			return "UNIDADE";
		case 5:
			return "CUSTO";
		case 6:
			return "MARGEM DE LUCRO";
		default:
			return "";
		}
	}
	
	/*
	 * Lista todos os produtos através do método Listar da classe DaoProduto
	 */
	public List<Produto> listar() {
		DaoProduto c = new DaoProduto();
		return lista = c.listar();
	}
	
	/*
	 * Adiciona um produto na lista e atualiza a tabela
	 */
	public void addList(Produto c) {
		this.lista.add(c);
		this.fireTableStructureChanged();
	}
	
	/*
	 * Atualiza um produto na lista e atualiza a tabela
	 */
	public void updateList(int index, Produto c) {
		lista.set(index, c);
		this.fireTableStructureChanged();
	}
	
	/*
	 * Deleta um produto na lista e atualiza a tabela
	 */
	public void delete(int index) {
		lista.remove(index);
		this.fireTableStructureChanged();
	}

}

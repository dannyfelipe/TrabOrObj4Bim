package br.univel;

/**
 * @author Danny Felipe, 02/11/2015 - 11:56:22
 * 
 * Table model Usu�rio
 * Cont�m todas as informa��es para exibi��o dos dados do usu�rio
 * no formul�rio de cadastro
 */

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.connections.DaoUsuario;

public class UsuarioTable extends AbstractTableModel {

	List<Usuario> lista = new ArrayList<>();

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub

		Usuario u = lista.get(row);
		switch (col) {
		case 0:
			return u.getId_u();
		case 1:
			return u.getCliente_id();
		case 2:
			return u.getCliente();
		case 3:
			return u.getUsername();
		case 4:
			return u.getPassword();
		default:
			return "";
		}
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "C�D. USU�RIO";
		case 1:
			return "C�D. CLIENTE";
		case 2:
			return "CLIENTE";
		case 3:
			return "USERNAME";
		case 4:
			return "PASSWORD";
		default:
			return "";
		}
	}
	
	/*
	 * Lista todos os usu�rios atrav�s do m�todo Listar da classe DaoUsuario
	 */
	public List<Usuario> listar(){
		DaoUsuario u = new DaoUsuario();
		return lista = u.listar();
	}
	
	/*
	 * Adiciona um usu�rio na lista e atualiza a tabela
	 */
	public void addList(Usuario u){
		this.lista.add(u);
		this.fireTableStructureChanged();
	}
	
	/*
	 * Atualiza um usu�rio na lista e atualiza a tabela
	 */
	public void updateList(int index, Usuario u){
		lista.set(index, u);
		this.fireTableStructureChanged();
	}
	
	/*
	 * Deleta um usu�rio na lista e atualiza a tabela
	 */
	public void delete(int index){
		lista.remove(index);
		this.fireTableStructureChanged();
	}

}

package br.univel.system;

/**
 * @author Danny Felipe, 02/11/2015 - 12:02:51
 * 
 * Formulário de cadastro de usuário
 */

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import br.univel.Usuario;
import br.univel.UsuarioTable;
import br.univel.connections.DaoUsuario;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPasswordField;

public class MioloCadastroUsuario extends JPanel {

	protected JTextField txtFu_id;
	protected JTextField txtFu_clienteid;
	private JTextField txtFu_cliente;
	private JTable table;
	
	private DaoUsuario du = new DaoUsuario();
	private UsuarioTable tableUsuario;
	private List<Usuario> listUsuario = new ArrayList<>();
	private int aux = -1;
	private JTextField txtPFu_password;
	private JTextField txtPFu_username;
	

	/**
	 * Create the panel.
	 */
	public MioloCadastroUsuario() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		add(panel_2, gbc_panel_2);

		JLabel lblId = new JLabel("C\u00F3d.:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		add(lblId, gbc_lblId);

		txtFu_id = new JTextField();
		GridBagConstraints gbc_txtFu_id = new GridBagConstraints();
		gbc_txtFu_id.insets = new Insets(0, 0, 5, 0);
		gbc_txtFu_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFu_id.gridx = 1;
		gbc_txtFu_id.gridy = 1;
		add(txtFu_id, gbc_txtFu_id);
		txtFu_id.setColumns(10);

		JLabel lblNewLabel = new JLabel("C\u00F3d. Cliente:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);

		txtFu_clienteid = new JTextField();
		GridBagConstraints gbc_txtFu_clienteid = new GridBagConstraints();
		gbc_txtFu_clienteid.anchor = GridBagConstraints.NORTH;
		gbc_txtFu_clienteid.insets = new Insets(0, 0, 5, 0);
		gbc_txtFu_clienteid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFu_clienteid.gridx = 1;
		gbc_txtFu_clienteid.gridy = 2;
		add(txtFu_clienteid, gbc_txtFu_clienteid);
		txtFu_clienteid.setColumns(10);

		JLabel lblTelefone = new JLabel("Cliente:");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 0;
		gbc_lblTelefone.gridy = 3;
		add(lblTelefone, gbc_lblTelefone);

		txtFu_cliente = new JTextField();
		GridBagConstraints gbc_txtFu_cliente = new GridBagConstraints();
		gbc_txtFu_cliente.insets = new Insets(0, 0, 5, 0);
		gbc_txtFu_cliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFu_cliente.gridx = 1;
		gbc_txtFu_cliente.gridy = 3;
		add(txtFu_cliente, gbc_txtFu_cliente);
		txtFu_cliente.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 4;
		add(lblUsername, gbc_lblUsername);
		
		txtPFu_username = new JTextField();
		GridBagConstraints gbc_txtPFu_username = new GridBagConstraints();
		gbc_txtPFu_username.insets = new Insets(0, 0, 5, 0);
		gbc_txtPFu_username.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPFu_username.gridx = 1;
		gbc_txtPFu_username.gridy = 4;
		add(txtPFu_username, gbc_txtPFu_username);
		txtPFu_username.setColumns(10);

		JLabel lblEndereo = new JLabel("Password:");
		GridBagConstraints gbc_lblEndereo = new GridBagConstraints();
		gbc_lblEndereo.anchor = GridBagConstraints.EAST;
		gbc_lblEndereo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereo.gridx = 0;
		gbc_lblEndereo.gridy = 5;
		add(lblEndereo, gbc_lblEndereo);
		
		txtPFu_password = new JTextField();
		GridBagConstraints gbc_txtPFu_password = new GridBagConstraints();
		gbc_txtPFu_password.insets = new Insets(0, 0, 5, 0);
		gbc_txtPFu_password.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPFu_password.gridx = 1;
		gbc_txtPFu_password.gridy = 5;
		add(txtPFu_password, gbc_txtPFu_password);
		txtPFu_password.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 6;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {
					Usuario u = (Usuario) listUsuario.get(table.getSelectedRow());
					
					txtFu_id.setText(String.valueOf(u.getId_u()));
					txtFu_clienteid.setText(String.valueOf(u.getCliente_id()));
					txtFu_cliente.setText(u.getCliente());
					txtPFu_password.setText(u.getPassword());
					
					aux = table.getSelectedRow();
				}
			}
		});
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.EAST;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 8;
		add(panel_1, gbc_panel_1);

		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnAction_Add();
				
			}
		});
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Alterar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnAction_Update();
				
			}
		});
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnAction_delete();
				
			}
		});
		panel_1.add(btnNewButton_2);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.EAST;
		gbc_panel.gridwidth = 2;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 9;
		add(panel, gbc_panel);

		JLabel lblMensagem = new JLabel("Mensagem:");
		panel.add(lblMensagem);
		
		// inicia a conexão com o banco de dados
		du.getCon();

		// invoca o método para listar todos os usuários na tabela
		listarUsuarios();

	}

	/*
	 * Método para excluir um usuário na base de dados
	 */
	protected void btnAction_delete() {
		
		du.delete(table.getSelectedRow());
		tableUsuario.delete(table.getSelectedRow());
		
	}

	/*
	 * Método para atualizar um usuário na base de dados
	 */
	protected void btnAction_Update() {
		// TODO Auto-generated method stub
		
		if (aux > -1) {
			Usuario usuario = new Usuario();
			usuario.setId_u(Integer.parseInt(txtFu_id.getText()));
			usuario.setCliente_id(Integer.parseInt(txtFu_clienteid.getText()));
			usuario.setCliente(txtFu_cliente.getText());
			usuario.setPassword(txtPFu_password.getSelectedText());
			du.update(usuario);
			tableUsuario.updateList(aux, usuario);
			limpar();
			aux = -1;
		} else {
			JOptionPane.showMessageDialog(null, "Selecio um usuário!");
		}
		
	}

	/*
	 * Inicia um thread para listar todos os usuários da base de dados
	 */
	private void listarUsuarios() {
		// TODO Auto-generated method stub
		
		new Thread(new Runnable() {			
			@Override
			public void run() {
				tableUsuario = new UsuarioTable();
				listUsuario = tableUsuario.listar();
				table.setModel(tableUsuario);		
			}
		}).start();
		
	}

	/*
	 * Método para adicionar um usuário na base de dados
	 * cria um novo usuário, pega os dados do formulário
	 * insere-o através do método inserir da classe DaoUsuario
	 * atualiza a tabela e limpa os campos
	 */
	protected void btnAction_Add() {
		// TODO Auto-generated method stub
		
		Usuario usuario = new Usuario();
		usuario.setCliente_id(Integer.parseInt(txtFu_clienteid.getText()));
		usuario.setCliente(txtFu_cliente.getText());
		usuario.setPassword(txtPFu_password.getText());
		du.insert(usuario);
		listUsuario = du.listar();
		tableUsuario.addList(usuario);
		limpar();
		
	}

	/*
	 * Método para limpar os campos do formulário após a inserção do registro
	 */
	private void limpar() {
		// TODO Auto-generated method stub
		
		txtFu_id.setText("");
		txtFu_clienteid.setText("");
		txtFu_cliente.setText("");
		txtPFu_password.setText("");
		
	}

}

package br.univel.system;

/**
 * @author Danny Felipe, 02/11/2015 - 01:04:23
 * 
 * Formul�rio de cadastro de cliente
 */

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import br.univel.Cliente;
import br.univel.ClienteTable;
import br.univel.Estado;
import br.univel.Genero;
import br.univel.connections.DaoCliente;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class MioloCadastroCliente extends JPanel {

	protected JTextField txtFc_id;
	protected JTextField txtFc_nome;
	private JTextField txtFc_telefone;
	private JTextField txtFc_endereco;
	private JTextField txtFc_cidade;
	private JTextField txtFc_email;
	private JComboBox cBxc_estado;
	private JComboBox cBxc_genero;
	private JTable table;
	
	private DaoCliente dc = new DaoCliente();
	private ClienteTable tableCliente;
	private List<Cliente> listCliente = new ArrayList<>();
	

	/**
	 * Create the panel.
	 */
	public MioloCadastroCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
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

		txtFc_id = new JTextField();
		GridBagConstraints gbc_txtFc_id = new GridBagConstraints();
		gbc_txtFc_id.insets = new Insets(0, 0, 5, 0);
		gbc_txtFc_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFc_id.gridx = 1;
		gbc_txtFc_id.gridy = 1;
		add(txtFc_id, gbc_txtFc_id);
		txtFc_id.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);

		txtFc_nome = new JTextField();
		GridBagConstraints gbc_txtFc_nome = new GridBagConstraints();
		gbc_txtFc_nome.anchor = GridBagConstraints.NORTH;
		gbc_txtFc_nome.insets = new Insets(0, 0, 5, 0);
		gbc_txtFc_nome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFc_nome.gridx = 1;
		gbc_txtFc_nome.gridy = 2;
		add(txtFc_nome, gbc_txtFc_nome);
		txtFc_nome.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 0;
		gbc_lblTelefone.gridy = 3;
		add(lblTelefone, gbc_lblTelefone);

		txtFc_telefone = new JTextField();
		GridBagConstraints gbc_txtFc_telefone = new GridBagConstraints();
		gbc_txtFc_telefone.insets = new Insets(0, 0, 5, 0);
		gbc_txtFc_telefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFc_telefone.gridx = 1;
		gbc_txtFc_telefone.gridy = 3;
		add(txtFc_telefone, gbc_txtFc_telefone);
		txtFc_telefone.setColumns(10);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		GridBagConstraints gbc_lblEndereo = new GridBagConstraints();
		gbc_lblEndereo.anchor = GridBagConstraints.EAST;
		gbc_lblEndereo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereo.gridx = 0;
		gbc_lblEndereo.gridy = 4;
		add(lblEndereo, gbc_lblEndereo);

		txtFc_endereco = new JTextField();
		GridBagConstraints gbc_txtFc_endereco = new GridBagConstraints();
		gbc_txtFc_endereco.insets = new Insets(0, 0, 5, 0);
		gbc_txtFc_endereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFc_endereco.gridx = 1;
		gbc_txtFc_endereco.gridy = 4;
		add(txtFc_endereco, gbc_txtFc_endereco);
		txtFc_endereco.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.gridx = 0;
		gbc_lblCidade.gridy = 5;
		add(lblCidade, gbc_lblCidade);

		txtFc_cidade = new JTextField();
		GridBagConstraints gbc_txtFc_cidade = new GridBagConstraints();
		gbc_txtFc_cidade.insets = new Insets(0, 0, 5, 0);
		gbc_txtFc_cidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFc_cidade.gridx = 1;
		gbc_txtFc_cidade.gridy = 5;
		add(txtFc_cidade, gbc_txtFc_cidade);
		txtFc_cidade.setColumns(10);

		JLabel lblEstado = new JLabel("Estado:");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 6;
		add(lblEstado, gbc_lblEstado);

		cBxc_estado = new JComboBox();
		GridBagConstraints gbc_cBxc_estado = new GridBagConstraints();
		gbc_cBxc_estado.insets = new Insets(0, 0, 5, 0);
		gbc_cBxc_estado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cBxc_estado.gridx = 1;
		gbc_cBxc_estado.gridy = 6;
		add(cBxc_estado, gbc_cBxc_estado);
		

		JLabel lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 7;
		add(lblEmail, gbc_lblEmail);

		txtFc_email = new JTextField();
		GridBagConstraints gbc_txtFc_email = new GridBagConstraints();
		gbc_txtFc_email.insets = new Insets(0, 0, 5, 0);
		gbc_txtFc_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFc_email.gridx = 1;
		gbc_txtFc_email.gridy = 7;
		add(txtFc_email, gbc_txtFc_email);
		txtFc_email.setColumns(10);

		JLabel lblGnero = new JLabel("G\u00EAnero:");
		GridBagConstraints gbc_lblGnero = new GridBagConstraints();
		gbc_lblGnero.anchor = GridBagConstraints.EAST;
		gbc_lblGnero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGnero.gridx = 0;
		gbc_lblGnero.gridy = 8;
		add(lblGnero, gbc_lblGnero);

		cBxc_genero = new JComboBox();
		GridBagConstraints gbc_cBxc_genero = new GridBagConstraints();
		gbc_cBxc_genero.insets = new Insets(0, 0, 5, 0);
		gbc_cBxc_genero.fill = GridBagConstraints.HORIZONTAL;
		gbc_cBxc_genero.gridx = 1;
		gbc_cBxc_genero.gridy = 8;
		add(cBxc_genero, gbc_cBxc_genero);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 9;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.EAST;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 11;
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
				
				
			}
		});
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		panel_1.add(btnNewButton_2);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.EAST;
		gbc_panel.gridwidth = 2;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 12;
		add(panel, gbc_panel);

		JLabel lblMensagem = new JLabel("Mensagem:");
		panel.add(lblMensagem);
		
		// inicia a conex�o com o banco de dados
		dc.getCon();

		// invoca o m�todo para listar todos os clientes na tabela
		listarClientes();
		
		uf();
		gen();
	}
	
	
	private void listarClientes() {
		// TODO Auto-generated method stub
		
		new Thread(new Runnable() {			
			@Override
			public void run() {
				tableCliente = new ClienteTable();
				listCliente = tableCliente.listar();
				table.setModel(tableCliente);		
			}
		}).start();
		
	}


	protected void btnAction_Add() {
		// TODO Auto-generated method stub
		
		Cliente cliente = new Cliente(
				txtFc_nome.getText(),
				txtFc_telefone.getText(), 
				txtFc_endereco.getText(),
				txtFc_cidade.getText(),
				Estado.valueOf(String.valueOf(cBxc_estado.getSelectedItem())),
				txtFc_email.getText(),
				Genero.valueOf(String.valueOf(cBxc_genero.getSelectedItem())));
		dc.insert(cliente);
		tableCliente.addList(cliente);
		limpar();
		
	}


	private void limpar() {
		// TODO Auto-generated method stub
		
		txtFc_id.setText("");
		txtFc_nome.setText("");
		txtFc_telefone.setText("");
		txtFc_endereco.setText("");
		txtFc_cidade.setText("");
		cBxc_estado.setSelectedIndex(0);
		txtFc_email.setText("");
		cBxc_genero.setSelectedIndex(0);
		
	}


	private void uf() {
		
		for (Estado o : Estado.values()) {
			//System.out.println(o.name());
			cBxc_estado.addItem(o.name());
		}
		
		//System.out.println("inserir");
	}
	
	private void gen() {
		for (Genero o : Genero.values()) {
			cBxc_genero.addItem(o.name());
		}
	}

}

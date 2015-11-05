package br.univel.system;

/**
 * @author Danny Felipe, 03/11/2015 - 20:26:33
 * 
 * Formulário de relatório de cliente
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

import br.univel.Cliente;
import br.univel.ClienteTable;
import br.univel.Estado;
import br.univel.Genero;
import br.univel.connections.DaoCliente;
import br.univel.rels.RelCliente_cidade;
import br.univel.rels.RelCliente_estado;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MioloRelatorioCliente extends JPanel {
	private JTable table;
	
	private DaoCliente dc = new DaoCliente();
	private ClienteTable tableCliente;
	private List<Cliente> listCliente = new ArrayList<>();
	private int aux = -1;
	

	/**
	 * Create the panel.
	 */
	public MioloRelatorioCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0,
				0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		add(panel_2, gbc_panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.EAST;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 3;
		add(panel_1, gbc_panel_1);
		
		JButton btnRelUf = new JButton("Gerar relat\u00F3rio Cliente/UF");
		btnRelUf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// invoca o método
				gerarRelClienteUF();
				
			}
		});
		panel_1.add(btnRelUf);
		
		JButton btnRelCidade = new JButton("Gerar relat\u00F3rio Cliente/Cidade");
		btnRelCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// invoca o método
				gerarRelClienteCidade();
			}
		});
		panel_1.add(btnRelCidade);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.EAST;
		gbc_panel.gridwidth = 2;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		add(panel, gbc_panel);

		JLabel lblMensagem = new JLabel("Mensagem:");
		panel.add(lblMensagem);
		
		// inicia a conexão com o banco de dados
		dc.getCon();

		// invoca o método para listar todos os clientes na tabela
		listarClientes();
	}

	protected void gerarRelClienteCidade() {
		// TODO Auto-generated method stub
		// chama a classe
		new RelCliente_cidade();
	}

	protected void gerarRelClienteUF() {
		// TODO Auto-generated method stub
		// chama a classe
		new RelCliente_estado();
		
	}

	/*
	 * Inicia um thread para listar todos os clientes da base de dados
	 */
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

}

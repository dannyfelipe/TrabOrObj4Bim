package br.univel.system;

/**
 * @author Danny Felipe, 05/11/2015 - 00:40:12
 * 
 * Formulário de relatório de venda
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

import br.univel.Venda;
import br.univel.VendaTable;
import br.univel.connections.DaoVenda;
import br.univel.rels.RelVenda_geral;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MioloRelatorioVenda extends JPanel {
	private JTable table;
	
	private DaoVenda dv = new DaoVenda();
	private VendaTable tableVenda;
	private List<Venda> SaleList = new ArrayList<>();
	private int aux = -1;
	

	/**
	 * Create the panel.
	 */
	public MioloRelatorioVenda() {
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
		
		JButton btnRelUf = new JButton("Gerar relat\u00F3rio Venda");
		btnRelUf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				gerarRelUF();
				
			}
		});
		panel_1.add(btnRelUf);

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
		dv.getCon();

		// invoca o método para listar todos os clientes na tabela
		listarClientes();
	}

	protected void gerarRelUF() {
		// TODO Auto-generated method stub
		// chama a classe
		new RelVenda_geral();
	}

	/*
	 * Inicia um thread para listar todos os clientes da base de dados
	 */
	private void listarClientes() {
		// TODO Auto-generated method stub
		
		new Thread(new Runnable() {			
			@Override
			public void run() {
				tableVenda = new VendaTable();
				SaleList = tableVenda.listar();
				table.setModel(tableVenda);		
			}
		}).start();
		
	}

}

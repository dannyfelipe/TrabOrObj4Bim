package br.univel.system;

/**
 * @author Danny Felipe, 05/11/2015 - 00:25:36
 * 
 * Formulário de relatório de produto
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

import br.univel.Produto;
import br.univel.ProdutoTable;
import br.univel.connections.DaoProduto;
import br.univel.rels.RelCliente_estado;
import br.univel.rels.RelProduto_geral;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MioloRelatorioProduto extends JPanel {
	private JTable table;
	
	private DaoProduto dp = new DaoProduto();
	private ProdutoTable tableProduto;
	private List<Produto> ProductList = new ArrayList<>();
	private int aux = -1;
	

	/**
	 * Create the panel.
	 */
	public MioloRelatorioProduto() {
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
		
		JButton btnRelCidade = new JButton("Gerar relat\u00F3rio Produto");
		btnRelCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// chama a classe
				new RelProduto_geral();
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
		dp.getCon();

		// invoca o método para listar todos os clientes na tabela
		listarProdutos();
	}

	/*
	 * Inicia um thread para listar todos os clientes da base de dados
	 */
	private void listarProdutos() {
		// TODO Auto-generated method stub
		
		new Thread(new Runnable() {			
			@Override
			public void run() {
				tableProduto = new ProdutoTable();
				ProductList = tableProduto.listar();
				table.setModel(tableProduto);		
			}
		}).start();
		
	}

}

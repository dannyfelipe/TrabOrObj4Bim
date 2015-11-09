package br.univel.system;

/**
 * @author Danny Felipe, 02/11/2015 - 13:32:39
 * 
 * Formulário de cadastro de venda
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
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.univel.Cliente;
import br.univel.Produto;
import br.univel.Venda;
import br.univel.VendaTable;
import br.univel.connections.DaoCliente;
import br.univel.connections.DaoProduto;
import br.univel.connections.DaoVenda;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MioloCadastroVenda extends JPanel {

	protected JTextField txtFv_id;
	private JTextField txtFv_vpagamento;
	private JTable table;
	
	private DaoVenda dv = new DaoVenda();
	private VendaTable tableVenda;
	private List<Venda> saleList = new ArrayList<>();
	private int aux = -1;
	private JTextField txtFv_vtotal;
	private JTextField txtFv_troco;
	private JTextField txtFv_data;
	private JTextField txtFv_hora;
	
	private List<Cliente> customerList = new ArrayList<Cliente>();
	private List<Produto> productList = new ArrayList<Produto>();
	private JComboBox cBxv_produto;
	private JComboBox cBxv_cliente;
	

	/**
	 * Create the panel.
	 */
	public MioloCadastroVenda() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
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

		txtFv_id = new JTextField();
		GridBagConstraints gbc_txtFv_id = new GridBagConstraints();
		gbc_txtFv_id.insets = new Insets(0, 0, 5, 0);
		gbc_txtFv_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFv_id.gridx = 1;
		gbc_txtFv_id.gridy = 1;
		add(txtFv_id, gbc_txtFv_id);
		txtFv_id.setColumns(10);

		JLabel lblTelefone = new JLabel("Cliente:");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 0;
		gbc_lblTelefone.gridy = 2;
		add(lblTelefone, gbc_lblTelefone);
		
		cBxv_cliente = new JComboBox();
		GridBagConstraints gbc_cBxv_cliente = new GridBagConstraints();
		gbc_cBxv_cliente.insets = new Insets(0, 0, 5, 0);
		gbc_cBxv_cliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_cBxv_cliente.gridx = 1;
		gbc_cBxv_cliente.gridy = 2;
		add(cBxv_cliente, gbc_cBxv_cliente);

		JLabel lblCidade = new JLabel("Produto:");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.gridx = 0;
		gbc_lblCidade.gridy = 3;
		add(lblCidade, gbc_lblCidade);
		
		cBxv_produto = new JComboBox();
		GridBagConstraints gbc_cBxv_produto = new GridBagConstraints();
		gbc_cBxv_produto.insets = new Insets(0, 0, 5, 0);
		gbc_cBxv_produto.fill = GridBagConstraints.HORIZONTAL;
		gbc_cBxv_produto.gridx = 1;
		gbc_cBxv_produto.gridy = 3;
		add(cBxv_produto, gbc_cBxv_produto);

		JLabel lblEstado = new JLabel("Valor total:");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 4;
		add(lblEstado, gbc_lblEstado);
		
		txtFv_vtotal = new JTextField();
		GridBagConstraints gbc_txtFv_vtotal = new GridBagConstraints();
		gbc_txtFv_vtotal.insets = new Insets(0, 0, 5, 0);
		gbc_txtFv_vtotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFv_vtotal.gridx = 1;
		gbc_txtFv_vtotal.gridy = 4;
		add(txtFv_vtotal, gbc_txtFv_vtotal);
		txtFv_vtotal.setColumns(10);
		

		JLabel lblEmail = new JLabel("Valor do pagamento:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 5;
		add(lblEmail, gbc_lblEmail);

		txtFv_vpagamento = new JTextField();
		GridBagConstraints gbc_txtFv_vpagamento = new GridBagConstraints();
		gbc_txtFv_vpagamento.insets = new Insets(0, 0, 5, 0);
		gbc_txtFv_vpagamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFv_vpagamento.gridx = 1;
		gbc_txtFv_vpagamento.gridy = 5;
		add(txtFv_vpagamento, gbc_txtFv_vpagamento);
		txtFv_vpagamento.setColumns(10);
		
		JLabel lblTroco = new JLabel("Troco:");
		GridBagConstraints gbc_lblTroco = new GridBagConstraints();
		gbc_lblTroco.anchor = GridBagConstraints.EAST;
		gbc_lblTroco.insets = new Insets(0, 0, 5, 5);
		gbc_lblTroco.gridx = 0;
		gbc_lblTroco.gridy = 6;
		add(lblTroco, gbc_lblTroco);
		
		txtFv_troco = new JTextField();
		GridBagConstraints gbc_txtFv_troco = new GridBagConstraints();
		gbc_txtFv_troco.insets = new Insets(0, 0, 5, 0);
		gbc_txtFv_troco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFv_troco.gridx = 1;
		gbc_txtFv_troco.gridy = 6;
		add(txtFv_troco, gbc_txtFv_troco);
		txtFv_troco.setColumns(10);
		
		JLabel lblData = new JLabel("Data:");
		GridBagConstraints gbc_lblData = new GridBagConstraints();
		gbc_lblData.anchor = GridBagConstraints.EAST;
		gbc_lblData.insets = new Insets(0, 0, 5, 5);
		gbc_lblData.gridx = 0;
		gbc_lblData.gridy = 7;
		add(lblData, gbc_lblData);
		
		txtFv_data = new JTextField();
		GridBagConstraints gbc_txtFv_data = new GridBagConstraints();
		gbc_txtFv_data.insets = new Insets(0, 0, 5, 0);
		gbc_txtFv_data.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFv_data.gridx = 1;
		gbc_txtFv_data.gridy = 7;
		add(txtFv_data, gbc_txtFv_data);
		txtFv_data.setColumns(10);

		JLabel lblGnero = new JLabel("Hora:");
		GridBagConstraints gbc_lblGnero = new GridBagConstraints();
		gbc_lblGnero.anchor = GridBagConstraints.EAST;
		gbc_lblGnero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGnero.gridx = 0;
		gbc_lblGnero.gridy = 8;
		add(lblGnero, gbc_lblGnero);
		
		txtFv_hora = new JTextField();
		GridBagConstraints gbc_txtFv_hora = new GridBagConstraints();
		gbc_txtFv_hora.insets = new Insets(0, 0, 5, 0);
		gbc_txtFv_hora.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFv_hora.gridx = 1;
		gbc_txtFv_hora.gridy = 8;
		add(txtFv_hora, gbc_txtFv_hora);
		txtFv_hora.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 9;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {
					Venda v = (Venda) saleList.get(table.getSelectedRow());
					
					txtFv_id.setText(String.valueOf(v.getId_v()));
					cBxv_cliente.setSelectedItem(v.getCliente());
					cBxv_produto.setSelectedItem(v.getProduto());
					//txtFv_clienteid.setText(String.valueOf(v.getCliente_id()));
					//txtFv_cliente.setText(v.getCliente());
					//txtFv_produtoid.setText(String.valueOf(v.getProduto_id()));
					//txtFv_produto.setText(v.getProduto());
					txtFv_vtotal.setText(String.valueOf(v.getVtotal()));
					txtFv_vpagamento.setText(String.valueOf(v.getVpagamento()));
					txtFv_troco.setText(String.valueOf(v.getTroco()));
					txtFv_data.setText(String.valueOf(v.getData()));
					txtFv_hora.setText(String.valueOf(v.getHora()));
					
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
		gbc_panel.gridy = 12;
		add(panel, gbc_panel);

		JLabel lblMensagem = new JLabel("Mensagem:");
		panel.add(lblMensagem);
		
		// inicia a conexão com o banco de dados
		dv.getCon();

		// invoca o método para listar todos as vendas na tabela
		listarVendas();
		
		// recupera os clientes, listando-os nos combobox
		listarClientesCbx();

		// recupera os clientes, listando-os nos combobox
		listarProdutosCbx();
		
		// recupera data e hora do SO, exibe nos campos de texto
		exibirDataHora();
	}

	private void exibirDataHora() {
		// TODO Auto-generated method stub
		
		SimpleDateFormat frm = new SimpleDateFormat("dd/MM/yyyy");
		txtFv_data.setText(frm.format(new java.util.Date()));

		Calendar hora = Calendar.getInstance();
		txtFv_hora.setText(String.format("%1$tH:%tM:%1$tS", hora));
		
	}

	private void listarProdutosCbx() {
		// TODO Auto-generated method stub
		
		DaoProduto dp = new DaoProduto();
		productList = dp.listar();
		
		int cont = 0;
		for (Produto p : productList) {
			if (cont == 0) {
				cont = 1;
				cBxv_produto.addItem("");
			}
			cBxv_produto.addItem(p.getDescricao());
		}
		
	}

	private void listarClientesCbx() {
		// TODO Auto-generated method stub
		
		DaoCliente dc = new DaoCliente();
		customerList = dc.listar();
		
		int cont = 0;
		for (Cliente c : customerList) {
			if (cont == 0) {
				cont = 1;
				cBxv_cliente.addItem("");
			}
			cBxv_cliente.addItem(c.getNome());
		}
	}

	/*
	 * Método para excluir uma venda na base de dados
	 */
	protected void btnAction_delete() {
		
		dv.delete(table.getSelectedRow());
		tableVenda.delete(table.getSelectedRow());
		
	}

	/*
	 * Método para atualizar um cliente na base de dados
	 */
	protected void btnAction_Update() {
		// TODO Auto-generated method stub
		
		if (aux > -1) {
			Venda venda = new Venda(
					Integer.parseInt(txtFv_id.getText()),
					customerList.get(cBxv_cliente.getSelectedIndex() -1).getId_c(),
					productList.get(cBxv_produto.getSelectedIndex() -1).getId_p(),
					String.valueOf(cBxv_cliente.getSelectedItem()),
					String.valueOf(cBxv_produto.getSelectedItem()),
					BigDecimal.valueOf(Double.valueOf(txtFv_vtotal.getText())),
					BigDecimal.valueOf(Double.valueOf(txtFv_vpagamento.getText())),
					BigDecimal.valueOf(Double.valueOf(txtFv_troco.getText())),
					txtFv_data.getText(), txtFv_hora.getText());
			dv.insert(venda);
			saleList = dv.listar();
			tableVenda.addList(saleList);
			limpar();
			aux = -1;
			
		} else {
			JOptionPane.showMessageDialog(null, "Selecione um cliente!");
		}
		
	}

	/*
	 * Inicia um thread para listar todos as vendas da base de dados
	 */
	private void listarVendas() {
		// TODO Auto-generated method stub
		
		new Thread(new Runnable() {			
			@Override
			public void run() {
				tableVenda = new VendaTable();
				saleList = tableVenda.listar();
				table.setModel(tableVenda);		
			}
		}).start();
		
	}

	/*
	 * Método para efetuar uma venda na base de dados
	 * efetua uma nova venda, pega os dados do formulário
	 * insere-o através do método inserir da classe DaoVenda
	 * atualiza a tabela e limpa os campos
	 */
	protected void btnAction_Add() {
		// TODO Auto-generated method stub
		
		Venda venda = new Venda(
				customerList.get(cBxv_cliente.getSelectedIndex() -1).getId_c(),
				productList.get(cBxv_produto.getSelectedIndex() -1).getId_p(),
				String.valueOf(cBxv_cliente.getSelectedItem()),
				String.valueOf(cBxv_produto.getSelectedItem()),
				BigDecimal.valueOf(Double.valueOf(txtFv_vtotal.getText())),
				BigDecimal.valueOf(Double.valueOf(txtFv_vpagamento.getText())),
				BigDecimal.valueOf(Double.valueOf(txtFv_troco.getText())),
				txtFv_data.getText(),
				txtFv_hora.getText());
		dv.insert(venda);
		saleList = dv.listar();
		tableVenda.addList(saleList);
		limpar();
		
	}

	/*
	 * Método para limpar os campos do formulário após a inserção do registro
	 */
	private void limpar() {
		// TODO Auto-generated method stub
		
		txtFv_id.setText("");
		cBxv_cliente.setSelectedIndex(0);
		cBxv_produto.setSelectedIndex(0);
		//txtFv_clienteid.setText("");
		//txtFv_cliente.setText("");
		//txtFv_produtoid.setText("");
		//txtFv_produto.setText("");
		txtFv_vtotal.setText("");
		txtFv_vpagamento.setText("");
		txtFv_troco.setText("");
		txtFv_data.setText("");
		txtFv_hora.setText("");
		
	}

}

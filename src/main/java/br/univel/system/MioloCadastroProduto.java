package br.univel.system;

/**
 * @author Danny Felipe, 02/11/2015 - 03:40:32
 * 
 * Formulário de cadastro de produto
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

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MioloCadastroProduto extends JPanel {

	protected JTextField txtFp_id;
	protected JTextField txtFp_barcode;
	private JTextField txtFp_categoria;
	private JTextField txtFp_descricao;
	private JTextField txtFp_unidade;
	private JTextField txtFp_custo;
	private JTextField txtFp_mlucro;
	private JTable table;

	private DaoProduto dp = new DaoProduto();
	private ProdutoTable tableProduto;
	private List<Produto> listProduto = new ArrayList<>();
	private int aux = -1;

	/**
	 * Create the panel.
	 */
	public MioloCadastroProduto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
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

		txtFp_id = new JTextField();
		GridBagConstraints gbc_txtFp_id = new GridBagConstraints();
		gbc_txtFp_id.insets = new Insets(0, 0, 5, 0);
		gbc_txtFp_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFp_id.gridx = 1;
		gbc_txtFp_id.gridy = 1;
		add(txtFp_id, gbc_txtFp_id);
		txtFp_id.setColumns(10);

		JLabel lblNewLabel = new JLabel("C\u00F3digo de barras:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);

		txtFp_barcode = new JTextField();
		GridBagConstraints gbc_txtFp_barcode = new GridBagConstraints();
		gbc_txtFp_barcode.anchor = GridBagConstraints.NORTH;
		gbc_txtFp_barcode.insets = new Insets(0, 0, 5, 0);
		gbc_txtFp_barcode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFp_barcode.gridx = 1;
		gbc_txtFp_barcode.gridy = 2;
		add(txtFp_barcode, gbc_txtFp_barcode);
		txtFp_barcode.setColumns(10);

		JLabel lblTelefone = new JLabel("Categoria:");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 0;
		gbc_lblTelefone.gridy = 3;
		add(lblTelefone, gbc_lblTelefone);

		txtFp_categoria = new JTextField();
		GridBagConstraints gbc_txtFp_categoria = new GridBagConstraints();
		gbc_txtFp_categoria.insets = new Insets(0, 0, 5, 0);
		gbc_txtFp_categoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFp_categoria.gridx = 1;
		gbc_txtFp_categoria.gridy = 3;
		add(txtFp_categoria, gbc_txtFp_categoria);
		txtFp_categoria.setColumns(10);

		JLabel lblEndereo = new JLabel("Descri\u00E7\u00E3o:");
		GridBagConstraints gbc_lblEndereo = new GridBagConstraints();
		gbc_lblEndereo.anchor = GridBagConstraints.EAST;
		gbc_lblEndereo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereo.gridx = 0;
		gbc_lblEndereo.gridy = 4;
		add(lblEndereo, gbc_lblEndereo);

		txtFp_descricao = new JTextField();
		GridBagConstraints gbc_txtFp_descricao = new GridBagConstraints();
		gbc_txtFp_descricao.insets = new Insets(0, 0, 5, 0);
		gbc_txtFp_descricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFp_descricao.gridx = 1;
		gbc_txtFp_descricao.gridy = 4;
		add(txtFp_descricao, gbc_txtFp_descricao);
		txtFp_descricao.setColumns(10);

		JLabel lblCidade = new JLabel("Unidade:");
		GridBagConstraints gbc_lblCidade = new GridBagConstraints();
		gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade.anchor = GridBagConstraints.EAST;
		gbc_lblCidade.gridx = 0;
		gbc_lblCidade.gridy = 5;
		add(lblCidade, gbc_lblCidade);

		txtFp_unidade = new JTextField();
		GridBagConstraints gbc_txtFp_unidade = new GridBagConstraints();
		gbc_txtFp_unidade.insets = new Insets(0, 0, 5, 0);
		gbc_txtFp_unidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFp_unidade.gridx = 1;
		gbc_txtFp_unidade.gridy = 5;
		add(txtFp_unidade, gbc_txtFp_unidade);
		txtFp_unidade.setColumns(10);

		JLabel lblEstado = new JLabel("Custo:");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 6;
		add(lblEstado, gbc_lblEstado);

		txtFp_custo = new JTextField();
		GridBagConstraints gbc_txtFp_custo = new GridBagConstraints();
		gbc_txtFp_custo.insets = new Insets(0, 0, 5, 0);
		gbc_txtFp_custo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFp_custo.gridx = 1;
		gbc_txtFp_custo.gridy = 6;
		add(txtFp_custo, gbc_txtFp_custo);
		txtFp_custo.setColumns(10);

		JLabel lblEmail = new JLabel("Margem de lucro:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 7;
		add(lblEmail, gbc_lblEmail);

		txtFp_mlucro = new JTextField();
		GridBagConstraints gbc_txtFp_mlucro = new GridBagConstraints();
		gbc_txtFp_mlucro.insets = new Insets(0, 0, 5, 0);
		gbc_txtFp_mlucro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFp_mlucro.gridx = 1;
		gbc_txtFp_mlucro.gridy = 7;
		add(txtFp_mlucro, gbc_txtFp_mlucro);
		txtFp_mlucro.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 8;
		add(scrollPane, gbc_scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {
					Produto p = (Produto) listProduto.get(table.getSelectedRow());

					txtFp_id.setText(String.valueOf(p.getId_p()));
					txtFp_barcode.setText(String.valueOf(p.getBarcode()));
					txtFp_categoria.setText(p.getCategoria());
					txtFp_descricao.setText(p.getDescricao());
					txtFp_unidade.setText(String.valueOf(p.getUnidade()));
					txtFp_custo.setText(String.valueOf(p.getCusto()));
					txtFp_mlucro.setText(String.valueOf(p.getMlucro()));

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
		gbc_panel_1.gridy = 10;
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
		gbc_panel.gridy = 11;
		add(panel, gbc_panel);

		JLabel lblMensagem = new JLabel("Mensagem:");
		panel.add(lblMensagem);

		// inicia a conexão com o banco de dados
		dp.getCon();

		// invoca o método para listar todos os produtos na tabela
		listarProdutos();
	}

	/*
	 * Método para excluir um produto na base de dados
	 */
	protected void btnAction_delete() {

		dp.delete(table.getSelectedRow());
		tableProduto.delete(table.getSelectedRow());

	}

	/*
	 * Método para atualizar um produto na base de dados
	 */
	protected void btnAction_Update() {
		// TODO Auto-generated method stub

		if (aux > -1) {
			Produto produto = new Produto(
					Integer.parseInt(txtFp_id.getText()),
					Integer.parseInt(txtFp_barcode.getText()),
					txtFp_categoria.getText(), txtFp_descricao.getText(),
					Integer.parseInt(txtFp_unidade.getText()),
					BigDecimal.valueOf(Double.parseDouble(txtFp_custo.getText())),
					BigDecimal.valueOf(Double.parseDouble(txtFp_mlucro.getText())));
			dp.update(produto);
			tableProduto.updateList(aux, produto);
			limpar();
			aux = -1;
		} else {
			JOptionPane.showMessageDialog(null, "Selecione um produto!");
		}

	}

	/*
	 * Inicia um thread para listar todos os produtos da base de dados
	 */
	private void listarProdutos() {
		// TODO Auto-generated method stub

		new Thread(new Runnable() {
			@Override
			public void run() {
				tableProduto = new ProdutoTable();
				listProduto = tableProduto.listar();
				table.setModel(tableProduto);
			}
		}).start();

	}

	/*
	 * Método para adicionar um produto na base de dados cria um novo produto,
	 * pega os dados do formulário insere-o através do método inserir da classe
	 * DaoProduto atualiza a tabela e limpa os campos
	 */
	protected void btnAction_Add() {
		// TODO Auto-generated method stub

		Produto produto = new Produto(
				Integer.parseInt(txtFp_barcode.getText()), 
				txtFp_categoria.getText(),
				txtFp_descricao.getText(),
				Integer.parseInt(txtFp_unidade.getText()),
				BigDecimal.valueOf(Double.parseDouble(txtFp_custo.getText())),
				BigDecimal.valueOf(Double.parseDouble(txtFp_mlucro.getText()))
				);
		dp.insert(produto);
		tableProduto.addList(produto);
		limpar();

	}

	/*
	 * Método para limpar os campos do formulário após a inserção do registro
	 */
	private void limpar() {
		// TODO Auto-generated method stub

		txtFp_id.setText("");
		txtFp_barcode.setText("");
		txtFp_categoria.setText("");
		txtFp_descricao.setText("");
		txtFp_unidade.setText("");
		txtFp_custo.setText("");
		txtFp_mlucro.setText("");
	}

}

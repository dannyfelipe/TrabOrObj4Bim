package br.univel.busca.cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JButton;

import org.h2.table.Table;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.function.Consumer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txfId;
	private JTextField txfNome;
	private JTextField txfRaca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblId = new JLabel("Id (F2)");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		contentPane.add(lblId, gbc_lblId);
		
		txfId = new JTextField();
		txfId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_F2) {
					abreBusca();
				}
			}
		});
		GridBagConstraints gbc_txfId = new GridBagConstraints();
		gbc_txfId.insets = new Insets(0, 0, 5, 0);
		gbc_txfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfId.gridx = 1;
		gbc_txfId.gridy = 0;
		contentPane.add(txfId, gbc_txfId);
		txfId.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		contentPane.add(lblNome, gbc_lblNome);
		
		txfNome = new JTextField();
		GridBagConstraints gbc_txfNome = new GridBagConstraints();
		gbc_txfNome.insets = new Insets(0, 0, 5, 0);
		gbc_txfNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfNome.gridx = 1;
		gbc_txfNome.gridy = 1;
		contentPane.add(txfNome, gbc_txfNome);
		txfNome.setColumns(10);
		
		JLabel lblRaca = new JLabel("Ra�a");
		GridBagConstraints gbc_lblRaca = new GridBagConstraints();
		gbc_lblRaca.anchor = GridBagConstraints.EAST;
		gbc_lblRaca.insets = new Insets(0, 0, 5, 5);
		gbc_lblRaca.gridx = 0;
		gbc_lblRaca.gridy = 2;
		contentPane.add(lblRaca, gbc_lblRaca);
		
		txfRaca = new JTextField();
		GridBagConstraints gbc_txfRaca = new GridBagConstraints();
		gbc_txfRaca.insets = new Insets(0, 0, 5, 0);
		gbc_txfRaca.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfRaca.gridx = 1;
		gbc_txfRaca.gridy = 2;
		contentPane.add(txfRaca, gbc_txfRaca);
		txfRaca.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abreBusca();
			}
		});
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 3;
		contentPane.add(btnBuscar, gbc_btnBuscar);
	}
	
	

	protected void abreBusca() {
		
		PainelBusca painelBusca = new PainelBusca();
		
		painelBusca.setOnOk(new Consumer<Pet>() {
			@Override
			public void accept(Pet t) {
				getGlassPane().setVisible(false);
				preencher(t);
			}
		});
		
		painelBusca.setOnCancel(new Runnable() {
			
			@Override
			public void run() {
				limparCampos();
				getGlassPane().setVisible(false);
			}
		});
		
		setGlassPane(painelBusca);
		painelBusca.setVisible(true);
	}

	protected void limparCampos() {
		txfId.setText("");
		txfNome.setText("");
		txfRaca.setText("");		
	}

	protected void preencher(Pet t) {
		txfId.setText(String.valueOf(t.getId()));;
		txfNome.setText(t.getNome());
		txfRaca.setText(t.getRaca());
	}

}

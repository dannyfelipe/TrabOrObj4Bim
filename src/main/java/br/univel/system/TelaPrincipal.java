package br.univel.system;

/**
 *  @author Danny Felipe, 29/10/2015 - 19:24:10
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import org.jdesktop.swingx.JXBusyLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.function.Function;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private BlockPanel glass;
	
	private String ABA1 = "Cadastro de Cliente";
	private String ABA2 = "Cadastro de Produto";
	private String ABA3 = "Cadastro de Usuário";
	private String ABA4 = "Venda de Produto";
	private String ABA5 = "Relatório de Clientes";
	private String ABA6 = "Relatório de Produtos";
	private String ABA7 = "Relatório de Vendas";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setExtendedState(MAXIMIZED_BOTH);
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
	public TelaPrincipal() {
		setTitle("Sistema Gen\u00E9rico");

		blockParaLogin();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);

		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// invoca o método
				openScreenClientRegistration();
			}

		});
		mnCadastros.add(mntmCliente);
		
		JMenuItem mntmProduto = new JMenuItem("Produto");
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// invoca o método
				openScreenProductRegistration();
			}
		});
		mnCadastros.add(mntmProduto);
		
		JMenu mnVenda = new JMenu("Venda");
		menuBar.add(mnVenda);
		
		JMenuItem mntmLanarVenda = new JMenuItem("Lan\u00E7ar venda");
		mntmLanarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// invoca o método
				openScreenSaleRegistration();
			}
		});
		mnVenda.add(mntmLanarVenda);
		
		JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatrios);
		
		JMenuItem mntmCliente_1 = new JMenuItem("Cliente");
		mntmCliente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// invoca o método
				openScreenClientReport();
			}
		});
		mnRelatrios.add(mntmCliente_1);
		
		JMenuItem mntmProduto_1 = new JMenuItem("Produto");
		mntmProduto_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// invoca o método
				openScreenProductReport();
			}
		});
		mnRelatrios.add(mntmProduto_1);
		
		JMenuItem mntmVenda = new JMenuItem("Venda");
		mntmVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// invoca o método
				openScreenSaleReport();
			}
		});
		mnRelatrios.add(mntmVenda);
		
		JMenu mnSistema = new JMenu("Sistema");
		menuBar.add(mnSistema);
		
		JMenu mnUsurio = new JMenu("Usu\u00E1rio");
		mnSistema.add(mnUsurio);
		
		JMenuItem mntmCadastro = new JMenuItem("Cadastro");
		mntmCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// invoca o método
				openScreenUserRegistration();
			}
		});
		mnUsurio.add(mntmCadastro);
		
		JMenuItem mntmBloquear_1 = new JMenuItem("Bloquear");
		mntmBloquear_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// bloqueia a tela
				block();
			}
		});
		mnSistema.add(mntmBloquear_1);
		
		JMenuItem mntmEncerrar = new JMenuItem("Encerrar");
		mntmEncerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// encerra a aplicação
				System.exit(0);
			}
		});
		mnSistema.add(mntmEncerrar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}

	protected void openScreenSaleReport() {
		// TODO Auto-generated method stub
		
		TelaRelatorioVenda telaRelatorioVenda = new TelaRelatorioVenda();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaRelatorioVenda);
			}
		};
		telaRelatorioVenda.setCloseAction(action);
		
		for (int i = 0; i < tabbedPane.getTabCount(); i++) {
			if (tabbedPane.getTitleAt(i).equals(ABA7)) {
				tabbedPane.setSelectedIndex(i);
				return;
			}
		}

		tabbedPane.addTab(ABA7, telaRelatorioVenda);
		abaAtual();
	}

	protected void openScreenProductReport() {
		// TODO Auto-generated method stub
		
		TelaRelatorioProduto telaRelatorioProduto = new TelaRelatorioProduto();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaRelatorioProduto);
			}
		};
		telaRelatorioProduto.setCloseAction(action);
		
		for (int i = 0; i < tabbedPane.getTabCount(); i++) {
			if (tabbedPane.getTitleAt(i).equals(ABA6)) {
				tabbedPane.setSelectedIndex(i);
				return;
			}
		}

		tabbedPane.addTab(ABA6, telaRelatorioProduto);
		abaAtual();
	}

	protected void openScreenClientReport() {
		// TODO Auto-generated method stub
		
		TelaRelatorioCliente telaRelatorioCliente = new TelaRelatorioCliente();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaRelatorioCliente);
			}
		};
		telaRelatorioCliente.setCloseAction(action);
		
		for (int i = 0; i < tabbedPane.getTabCount(); i++) {
			if (tabbedPane.getTitleAt(i).equals(ABA5)) {
				tabbedPane.setSelectedIndex(i);
				return;
			}
		}

		tabbedPane.addTab(ABA5, telaRelatorioCliente);
		abaAtual();
	}

	protected void openScreenSaleRegistration() {
		// TODO Auto-generated method stub
		
		TelaCadastroVenda telaCadastroVenda = new TelaCadastroVenda();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCadastroVenda);
			}
		};
		telaCadastroVenda.setCloseAction(action);
		
		for (int i = 0; i < tabbedPane.getTabCount(); i++) {
			if (tabbedPane.getTitleAt(i).equals(ABA4)) {
				tabbedPane.setSelectedIndex(i);
				return;
			}
		}

		tabbedPane.addTab(ABA4, telaCadastroVenda);
		abaAtual();
	}

	protected void openScreenUserRegistration() {
		// TODO Auto-generated method stub
		
		TelaCadastroUsuario telaCadastroUsuario = new TelaCadastroUsuario();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCadastroUsuario);
			}
		};
		telaCadastroUsuario.setCloseAction(action);
		
		for (int i = 0; i < tabbedPane.getTabCount(); i++) {
			if (tabbedPane.getTitleAt(i).equals(ABA3)) {
				tabbedPane.setSelectedIndex(i);
				return;
			}
		}

		tabbedPane.addTab(ABA3, telaCadastroUsuario);
		abaAtual();
	}

	protected void openScreenProductRegistration() {
		// TODO Auto-generated method stub
		
		TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCadastroProduto);
			}
		};
		telaCadastroProduto.setCloseAction(action);
		
		for (int i = 0; i < tabbedPane.getTabCount(); i++) {
			if (tabbedPane.getTitleAt(i).equals(ABA2)) {
				tabbedPane.setSelectedIndex(i);
				return;
			}
		}

		tabbedPane.addTab(ABA2, telaCadastroProduto);
		abaAtual();
	}

	protected void openScreenClientRegistration() {
		// TODO Auto-generated method stub
		
		TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCadastroCliente);
			}
		};
		telaCadastroCliente.setCloseAction(action);
		
		for (int i = 0; i < tabbedPane.getTabCount(); i++) {
			if (tabbedPane.getTitleAt(i).equals(ABA1)) {
				tabbedPane.setSelectedIndex(i);
				return;
			}
		}
		tabbedPane.addTab(ABA1, telaCadastroCliente);
		abaAtual();
	}

	/*
	 * Define o foco para a última aba instânciada
	 */
	private void abaAtual() {
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
	}

	/*
	 * Bloqueia a tela
	 */
	protected void block() {
		setGlassPane(glass);
		glass.setVisible(true);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i =0; i < 5; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				glass.setVisible(false);
			}
		}).start();
	}

	private void blockParaLogin() {
		
		Runnable acaoOk = () -> {
			glass.setVisible(false);
			glass = new BlockPanel();
		};

		
		//---- USAR A INDICAÇÃO DE PROGRESSO.
		//JXBusyLabel busy = new JXBusyLabel();
		//busy.setBusy(true);
		//glass = new BlockPanel(busy);
		//-----------------------------------
		
		//---- USAR O PAINEL DE LOGIN.
		PainelLogin painelLogin = new PainelLogin(acaoOk);
		glass = new BlockPanel(painelLogin);
		//-----------------------------------

		setGlassPane(glass);

		glass.setVisible(true);
	}

}

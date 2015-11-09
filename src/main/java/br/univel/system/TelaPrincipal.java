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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.function.Function;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private BlockPanel glass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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

		tabbedPane.addTab("Relatório de Vendas", telaRelatorioVenda);
		
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

		tabbedPane.addTab("Relatório de Produtos", telaRelatorioProduto);
		
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

		tabbedPane.addTab("Relatório de Clientes", telaRelatorioCliente);
		
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

		tabbedPane.addTab("Venda de produto", telaCadastroVenda);
		
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

		tabbedPane.addTab("Cadastro de Usuário", telaCadastroUsuario);
		
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

		tabbedPane.addTab("Cadastro de Produto", telaCadastroProduto);
		
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

		tabbedPane.addTab("Cadastro de Cliente", telaCadastroCliente);
		
	}

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

		PainelLogin painelLogin = new PainelLogin(acaoOk);

		glass = new BlockPanel(painelLogin);

		setGlassPane(glass);

		glass.setVisible(true);
	}

}

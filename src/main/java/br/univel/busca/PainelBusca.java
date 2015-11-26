package br.univel.busca;

import javax.swing.JPanel;

import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PainelBusca extends JPanel {
	private JTextField textField;
	private JTable table;
	private Consumer<Pet> consumerOnOk;
	private Runnable runnableOnCancel;

	/**
	 * Create the panel.
	 */
	public PainelBusca() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.WEST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 0);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		add(lblNome, gbc_lblNome);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		
		// O WindowBuilder vai ignorar o c�digo que est�
		// dentro desses coment�rios:
		
		// $hide>>$
		configuraTela();
		// $hide<<$
	}

	private void configuraTela() {
		PetTableModel model = new PetTableModel();
		table.setModel(model);

		
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					busca(textField.getText().trim());
				}

				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					// Seleciona o primeiro item na tabela.
					table.getSelectionModel().setSelectionInterval(0, 0);
					// Transfere o foco pra frente.
					textField.transferFocus();
				}
				
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					if (PainelBusca.this.runnableOnCancel != null) {
						PainelBusca.this.runnableOnCancel.run();
					}
				}
			}
		});
		
		table.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					table.transferFocusBackward();
				}
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					// Pra cancelar a a��o padr�o que j� existe
					// na JTable com a tecla Enter.
					e.consume();
					
					int idx = table.getSelectedRow();
					if (idx != -1) {
						Pet pet = ((PetTableModel)table.getModel()).getPetAt(idx);
						if (pet == null) {
							return;
						}
						PainelBusca.this.consumerOnOk.accept(pet);
					}
				}
				
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					if (PainelBusca.this.runnableOnCancel != null) {
						PainelBusca.this.runnableOnCancel.run();
					}
				}
			}
		});
	}

	protected void busca(String palavra) {

		List<Pet> lista = buscaNoBanco(palavra);

		((PetTableModel) table.getModel()).preencherResultado(lista);

	}

	/**
	 * Simula uma busca no banco, como se pedisse para um DAO ou fizesse o
	 * Statement diretamente no banco.
	 * 
	 * @param palavra
	 * 
	 * @return
	 */
	private List<Pet> buscaNoBanco(String palavra) {

		List<Pet> lista = new ArrayList<Pet>();

		for (int i = 0; i < DADOS_FICTICIOS.length; i++) {
			if (DADOS_FICTICIOS[i][1].toLowerCase().startsWith(palavra)) {
				Pet pet = new Pet();

				pet.setId(Integer.parseInt(DADOS_FICTICIOS[i][0]));
				pet.setNome(DADOS_FICTICIOS[i][1]);
				pet.setRaca(DADOS_FICTICIOS[i][2]);

				lista.add(pet);
			}
		}

		return lista;
	}

	public void setOnOk(Consumer<Pet> c) {
		this.consumerOnOk = c;
	}

	public void setOnCancel(Runnable r) {
		this.runnableOnCancel = r;
	}

	@Override
	public void setVisible(boolean arg0) {
		
		super.setVisible(arg0);
		
		// Depois que ficar visivel e terminar tudo
		// o que foi agendado para a EDT, solicita o
		// foco do teclado para o textField.
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				textField.requestFocusInWindow();
			}
		});
	}

	private static final String[][] DADOS_FICTICIOS = new String[][] {
			{ "254", "Atrevido", "Akita Inu" }, { "255", "Azarado", "Beagle" },
			{ "256", "Babu�no", "Beagle Harrier" },
			{ "257", "Balet", "Bobtail" },
			{ "258", "Bandido", "Boiadeiro de Berna" },
			{ "259", "Barriga", "Boxer" }, { "260", "Batman", "Braco Alem�o" },
			{ "261", "Beijoca", "Braco Franc�s" },
			{ "262", "Bigode", "Bull Terrier Ingl�s" },
			{ "263", "Blue", "Bulldog Americano" },
			{ "264", "Bolinha", "Bulldog Ingl�s" },
			{ "265", "Boss", "Cairn Terrier" },
			{ "266", "Brhama", "Cane Corso" }, { "267", "Brutus", "Caniche" },
			{ "268", "Carioca", "C�o de Crista Chin�s" },
			{ "269", "Chato", "C�o d��gua Espanhol" },
			{ "270", "Chuvisco", "C�o Lobo Checoslovaco" },
			{ "271", "Chuvisco", "Cavalier King Charles Spaniel" },
			{ "272", "Ciroc", "Chihuahua" }, { "273", "Coringa", "Chow-Chow" },
			{ "274", "Cristal", "Cocker Americano" },
			{ "275", "Dengoso", "Cocker Spaniel Ingl�s" },
			{ "276", "Detonalta", "Collie" }, { "277", "Diazepan", "D�lmata" },
			{ "278", "Tieta", "Doberman" },
			{ "279", "Docinho", "Dogue Alem�o" },
			{ "280", "D�lar", "Dogue de Bord�us" },
			{ "281", "Ema", "Epagneul Bret�o" },
			{ "282", "Esponja", "Fila Brasileiro" },
			{ "283", "Estrela", "Fox Terrier" },
			{ "284", "Fagulha", "Galgo Afeg�o" },
			{ "285", "Falc�o", "Golden Retriever" },
			{ "286", "Fedorento", "Husky Siberiano" },
			{ "287", "Fifa", "Ibizan Hound" },
			{ "288", "Fit�", "Jack Russel Terrier" },
			{ "289", "Flop", "Lhasa Apso" }, { "290", "Fofuxo", "Mastiff" },
			{ "291", "Foguinho", "Mastim dos Piren�us" },
			{ "292", "Frida", "Mastim Espanhol" },
			{ "293", "Gamado", "Mastim Napolitano" },
			{ "294", "Ganesh", "Norfolk Terrier" },
			{ "295", "Geppeto", "Papillon" },
			{ "296", "Guitarra", "Pastor Alem�o" },
			{ "297", "Hakuna", "Pastor de Beauce" },
			{ "298", "Happy", "Pequeno Basset Griffon" },
			{ "299", "Hermano", "Pequeno Braban�on" },
			{ "300", "Hobby", "Pequeno C�o Le�o" },
			{ "301", "Indio", "Pequin�s" },
			{ "302", "Iron", "Perdigueiro Portugu�s" },
			{ "303", "Jaleco", "Pinscher An�o" }, { "304", "Jazz", "Pitbull" },
			{ "305", "Jeans", "Rottweiler" }, { "306", "J�ia", "Samoiedo" },
			{ "307", "Jokei", "S�o Bernardo" }, { "308", "King", "Schnauzer" },
			{ "309", "Lambida", "Setter Ingl�s" },
			{ "310", "Lanterna", "Setter Irland�s" },
			{ "311", "Lesado", "Shar Pei" }, { "312", "Lingua", "Shih Tzu" },
			{ "313", "Lion", "Spaniel Japon�s" },
			{ "314", "Lobo", "Spitz Alem�o" },
			{ "315", "Lord", "Staffordshire Bull Terrier" },
			{ "316", "Lua", "Teckel" }, { "317", "Mafioso", "Terranova" },
			{ "318", "Manjarino", "Terrier Brasileiro" },
			{ "319", "Marmota", "Vizsla" }, { "320", "Matata", "Waimaraner" },
			{ "321", "Melado", "West Highland White Terrier" },
			{ "322", "Metal", "Yorkshire Terrier" },
			{ "323", "Mila", "Akita Inu" }, { "324", "Molly", "Beagle" },
			{ "325", "Morena", "Beagle Harrier" },
			{ "326", "Mort�fero", "Bobtail" },
			{ "327", "Music", "Boiadeiro de Berna" },
			{ "328", "Natal", "Boxer" }, { "329", "Nerd", "Braco Alem�o" },
			{ "330", "Neve", "Braco Franc�s" },
			{ "331", "Nutella", "Bull Terrier Ingl�s" },
			{ "332", "Obina", "Bulldog Americano" },
			{ "333", "Or�culo", "Bulldog Ingl�s" },
			{ "334", "Pandora", "Cairn Terrier" },
			{ "335", "Pantera", "Cane Corso" },
			{ "336", "Parauso", "Caniche" },
			{ "337", "Paz", "C�o de Crista Chin�s" },
			{ "338", "Peludo", "C�o d��gua Espanhol" },
			{ "339", "Peteca", "C�o Lobo Checoslovaco" },
			{ "340", "Poker", "Cavalier King Charles Spaniel" },
			{ "341", "Pop", "Chihuahua" }, { "342", "Popeye", "Chow-Chow" },
			{ "343", "Positivo", "Cocker Americano" },
			{ "344", "Pregui�a", "Cocker Spaniel Ingl�s" },
			{ "345", "Proteina", "Collie" }, { "346", "Pumba", "D�lmata" },
			{ "347", "Raio", "Doberman" }, { "348", "Ral�", "Dogue Alem�o" },
			{ "349", "Rebelde", "Dogue de Bord�us" },
			{ "350", "Revotril", "Epagneul Bret�o" },
			{ "351", "Rex", "Fila Brasileiro" },
			{ "352", "Saci", "Fox Terrier" },
			{ "353", "Sarado", "Galgo Afeg�o" },
			{ "354", "Severino", "Golden Retriever" },
			{ "355", "Skol", "Husky Siberiano" },
			{ "356", "Sorriso", "Ibizan Hound" },
			{ "357", "Stella", "Jack Russel Terrier" },
			{ "358", "Suvaco", "Lhasa Apso" }, { "359", "Tarz�n", "Mastiff" },
			{ "360", "Teimoso", "Mastim dos Piren�us" },
			{ "361", "Tim�o", "Mastim Espanhol" },
			{ "362", "Toete", "Mastim Napolitano" },
			{ "363", "Tot�", "Norfolk Terrier" },
			{ "364", "Valente", "Papillon" },
			{ "365", "Vibe", "Pastor Alem�o" },
			{ "366", "Vicky", "Pastor de Beauce" },
			{ "367", "Vinil", "Pequeno Basset Griffon" },
			{ "368", "Whey", "Pequeno Braban�on" },
			{ "369", "Xadrez", "Pequeno C�o Le�o" },
			{ "370", "Xeque", "Pequin�s" },
			{ "371", "Xoxo", "Perdigueiro Portugu�s" },
			{ "372", "Xulipa", "Pinscher An�o" }, { "373", "Xuxa", "Pitbull" },
			{ "374", "Zeus", "Rottweiler" }, { "375", "Zika", "Samoiedo" },
			{ "376", "Zorro", "S�o Bernardo" } };
}

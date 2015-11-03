package br.univel.rels;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.univel.Cliente;
import br.univel.connections.DaoCliente;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;

public class RelCliente_estado {
	
	private static final String OUT_PDF = "rel_cliente_uf.pdf";
	private String arq = "C:\\Users\\DOT\\git\\TrabOrObj4Bim\\src\\main\\resources\\Cliente_uf.jasper";
	private List<Cliente> listaC;

	public RelCliente_estado() {
		
		DaoCliente cliente = new DaoCliente();
		listaC = cliente.listar();

		TableModel tableModel = getTableModel();

		JasperPrint jp = null;
		try {

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("empresa", "Petrobras");
			map.put("telefone", "123pim567pim");

			jp = JasperFillManager.fillReport(arq, map,
					new JRTableModelDataSource(tableModel));

			// JasperViewer jasperViewer = new JasperViewer(jp);
			//
			// jasperViewer.setBounds(50, 50, 320, 240);
			// jasperViewer.setLocationRelativeTo(null);
			// jasperViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
			//
			// jasperViewer.setVisible(true);

			JasperExportManager.exportReportToPdfFile(jp, OUT_PDF);

			JOptionPane
					.showMessageDialog(
							null,
							"<html>Arquivo exportado para PDF!<br><br>A aplicação vai pedir"
							+ " ao Sistema operacional <br>para abrir com o visualizador"
							+ " padrão.");

			Desktop.getDesktop().open(new File(OUT_PDF));

		} catch (JRException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private TableModel getTableModel() {
		Object[] columnNames = { "id_c", "nome", "telefone", "endereco", "cidade", "estado", "email", "genero" };

		Object[][] data = new Object[listaC.size()][8];
		for (int i = 0; i < listaC.size(); i++) {
			int j = 0;
			
			data[i][j++] = listaC.get(i).getId_c();
			data[i][j++] = listaC.get(i).getNome();
			data[i][j++] = listaC.get(i).getTelefone();
			data[i][j++] = listaC.get(i).getEndereco();
			data[i][j++] = listaC.get(i).getCidade();
			data[i][j++] = listaC.get(i).getEstado().getNome();
			data[i][j++] = listaC.get(i).getEmail();
			data[i][j++] = listaC.get(i).getGenero().getNome();
		}

		return new DefaultTableModel(data, columnNames);
	}
	
	

//	public static void main(String[] args) {
//		new RelCliente();
//	}

}

package br.univel.rels;

/**
 * @author Danny Felipe, 05/11/2015 - 00:13:48
 * 
 * Classe responsável por gerar os relatórios em formato PDF
 */

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.univel.Venda;
import br.univel.connections.DaoVenda;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;

public class RelVenda_geral {

	private static final String OUT_PDF = "rel_venda_geral.pdf";
	private String arq = "C:\\Users\\DOT\\git\\TrabOrObj4Bim\\src\\main\\resources\\RelVendaGeral.jasper";
	private List<Venda> SaleList;

	public RelVenda_geral() {

		DaoVenda venda = new DaoVenda();
		SaleList = venda.listar();

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

			JOptionPane.showMessageDialog(null,
					"<html>Arquivo exportado para PDF!<br><br>"
							+ "Aguarde. Em instantes o arquivo será aberto.");

			Desktop.getDesktop().open(new File(OUT_PDF));

		} catch (JRException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private TableModel getTableModel() {
		Object[] columnNames = { "id_v", "cliente_id", "cliente", "produto_id",
				"produto", "vtotal", "vpagamento", "troco", "data", "hora" };

		Object[][] data = new Object[SaleList.size()][8];
		for (int i = 0; i < SaleList.size(); i++) {
			int j = 0;

			data[i][j++] = SaleList.get(i).getId_v();
			data[i][j++] = SaleList.get(i).getCliente_id();
			data[i][j++] = SaleList.get(i).getCliente();
			data[i][j++] = SaleList.get(i).getProduto_id();
			data[i][j++] = SaleList.get(i).getProduto();
			data[i][j++] = SaleList.get(i).getVtotal();
			data[i][j++] = SaleList.get(i).getVpagamento();
			data[i][j++] = SaleList.get(i).getTroco();
			data[i][j++] = SaleList.get(i).getData();
			data[i][j++] = SaleList.get(i).getHora();
		}

		return new DefaultTableModel(data, columnNames);
	}

	// public static void main(String[] args) {
		// new RelVenda_geral();
	// }

}

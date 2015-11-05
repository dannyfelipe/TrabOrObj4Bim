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

import br.univel.Produto;
import br.univel.connections.DaoProduto;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;

public class RelProduto_geral {

	private static final String OUT_PDF = "rel_produto_geral.pdf";
	private String arq = "C:\\Users\\DOT\\git\\TrabOrObj4Bim\\src\\main\\resources\\RelProdutoGeral.jasper";
	private List<Produto> ProductList;

	public RelProduto_geral() {

		DaoProduto produto = new DaoProduto();
		ProductList = produto.listar();

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
		Object[] columnNames = { "id_p", "barcode", "categoria", "descricao",
				"unidade", "custo", "mlucro" };

		Object[][] data = new Object[ProductList.size()][8];
		for (int i = 0; i < ProductList.size(); i++) {
			int j = 0;

			data[i][j++] = ProductList.get(i).getId_p();
			data[i][j++] = ProductList.get(i).getBarcode();
			data[i][j++] = ProductList.get(i).getCategoria();
			data[i][j++] = ProductList.get(i).getDescricao();
			data[i][j++] = ProductList.get(i).getUnidade();
			data[i][j++] = ProductList.get(i).getCusto();
			data[i][j++] = ProductList.get(i).getMlucro();
		}

		return new DefaultTableModel(data, columnNames);
	}

	// public static void main(String[] args) {
	// new RelProduto_geral();
	// }

}

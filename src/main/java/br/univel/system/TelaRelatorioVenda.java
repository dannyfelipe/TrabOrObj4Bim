package br.univel.system;

/**
 * @author Danny Felipe, 04/11/2015 - 13:15:14
 * 
 * Moldura abstrata para o formulário de relatório de venda
 */

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class TelaRelatorioVenda extends MolduraAbstrata {

	public TelaRelatorioVenda() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new MioloRelatorioVenda(), BorderLayout.CENTER);
	}

}

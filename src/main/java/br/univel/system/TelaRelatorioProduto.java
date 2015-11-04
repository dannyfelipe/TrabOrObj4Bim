package br.univel.system;

/**
 * @author Danny Felipe, 04/11/2015 - 13:13:42
 * 
 * Moldura abstrata para o formulário de relatório de produto
 */

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class TelaRelatorioProduto extends MolduraAbstrata {

	public TelaRelatorioProduto() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new MioloRelatorioProduto(), BorderLayout.CENTER);
	}

}

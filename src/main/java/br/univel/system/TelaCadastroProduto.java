package br.univel.system;

/**
 * @author Danny Felipe, 02/11/2015 - 03:39:47
 * 
 * Moldura abstrata para o formulário de cadastro de produto
 */

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class TelaCadastroProduto extends MolduraAbstrata {

	public TelaCadastroProduto() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new MioloCadastroProduto(), BorderLayout.CENTER);
	}

}

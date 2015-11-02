package br.univel.system;

/**
 * @author Danny Felipe, 02/11/2015 - 13:27:34
 * 
 * Moldura abstrata para o formulário de cadastro da venda
 */

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class TelaCadastroVenda extends MolduraAbstrata {

	public TelaCadastroVenda() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new MioloCadastroVenda(), BorderLayout.CENTER);
	}

}

package br.univel.system;

/**
 * @author Danny Felipe, 02/11/2015 - 01:03:07
 * 
 * Moldura abstrata para o formulário de cadastro de cliente
 */

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class TelaCadastroCliente extends MolduraAbstrata {

	public TelaCadastroCliente() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new MioloCadastroCliente(), BorderLayout.CENTER);
	}

}

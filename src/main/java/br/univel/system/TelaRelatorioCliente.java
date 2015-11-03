package br.univel.system;

/**
 * @author Danny Felipe, 03/11/2015 - 20:45:59
 * 
 * Moldura abstrata para o formulário de relatório de cliente
 */

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class TelaRelatorioCliente extends MolduraAbstrata {

	public TelaRelatorioCliente() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new MioloRelatorioCliente(), BorderLayout.CENTER);
	}

}

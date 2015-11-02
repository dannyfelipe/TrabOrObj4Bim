package br.univel.system;

/**
 * @author Danny Felipe, 02/11/2015 - 12:01:58
 * 
 * Moldura abstrata para o formul�rio de cadastro de usu�rio
 */

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class TelaCadastroUsuario extends MolduraAbstrata {

	public TelaCadastroUsuario() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new MioloCadastroUsuario(), BorderLayout.CENTER);
	}

}

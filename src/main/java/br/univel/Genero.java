package br.univel;

/**
 * @author Danny Felipe, 01/11/2015 - 18:55:44
 * 
 * Enum Genero - Lista com valores pré-definidos do genero do cliente
 * 
 */

public enum Genero {
	
	F("Feminino"), //
	M("Masculino"), //
	T("Trans"),
	V("Viado"),
	I("Indeciso do caralho");
	
	// variável para receber um dos valores
	private String nome;

	// método para retornar o valor da variável
	public String getNome() {
		return nome;
	}
	
	// construtor padrão
	private Genero(String nome) {
		this.nome = nome;
	}
	
	public Genero valida(Object o) {
		if (o.toString().equals(F.nome)) {
			return Genero.F;
		} else if (o.toString().equals(M.nome)) {
			return Genero.M;
		} else if (o.toString().equals(T.nome)) {
			return Genero.T;
		} else if (o.toString().equals(V.nome)) {
			return Genero.V;
		} else if (o.toString().equals(I.nome)) {
			return Genero.I;
		}
		return null;
	}

}

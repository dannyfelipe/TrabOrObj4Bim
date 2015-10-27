package br.univel;

public enum Genero {
	
	F("Feminino"), //
	M("Masculino"), //
	T("Trans"),
	V("Viado"),
	I("Indeciso do caralho");
	
	private String nome;

	public String getNome() {
		return nome;
	}

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

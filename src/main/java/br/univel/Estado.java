package br.univel;

/**
 * @author Danny Felipe, 01/11/2015 - 18:55:44
 * 
 * Enum Estado - Lista com valores pré-definidos dos estados brasileiros
 * 
 */

public enum Estado {
	
	AC("Acre"),
	AL("Alagoas"),
	AP("Amapá"),
	AM("Amazonas"),
	BA("Bahia"),
	CE("Ceará"),
	DF("Distrito Federal"),
	ES("Espírito Santo"),
	GO("Goiás"),
	MA("Maranhão"),
	MT("Mato Grosso"),
	MS("Mato Grosso do Sul"),
	MG("Minas Gerais"),
	PA("Pará"),
	PB("Paraíba"),
	PR("Paraná"), //
	PE("Pernambuco"),
	PI("Piauí"),
	RJ("Rio de Janeiro"),
	RN("Rio Grande do Norte"),
	RS("Rio Grande do Sul"),
	RO("Rondônia"),
	RR("Roraima"),
	SC("Santa Catarina"),
	SP("São Paulo"), //
	SE("Sergipe"),
	TO("Tocantins"); //
	
	// variável para receber um dos valores
	private String nome;
	
	// método para retornar o valor da variável
	public String getNome() {
		return nome;
	}
	
	// construtor padrão
	private Estado(String nome) {
		this.nome = nome;
	}
	
	public Estado valida(Object o) {
		if (o.toString().equals(PR.nome)) {
			return Estado.PR;
		}
		return null;
	}

}

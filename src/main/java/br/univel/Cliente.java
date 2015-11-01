package br.univel;

/**
 * 
 * @author Danny Felipe, 01/11/2015 - 19:38:43
 * 
 * Classe Cliente
 * Atributos da classe que receberão os dados no formulário de cadastro
 *
 */

public class Cliente {

	private int id_c;
	private String nome;
	private String endereco;
	private String cidade;
	private Estado estado;
	private String email;
	private Genero genero;

	/*
	 *  construtor padrão
	 */
	public Cliente() {

	}
	
	/*
	 *  construtores da classe
	 */
	public Cliente(int id_c, String nome, String endereco, String cidade,
			Estado estado, String email, Genero genero) {
		this.id_c = id_c;
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.email = email;
		this.genero = genero;
	}
	
	/*
	 *  construtores da classe
	 */
	public Cliente(String nome, String endereco, String cidade, Estado estado,
			String email, Genero genero) {
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.email = email;
		this.genero = genero;

	}

	/*
	 * Getters & Setters
	 */
	public int getId_c() {
		return id_c;
	}
	public void setId(int id_c) {
		this.id_c = id_c;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}

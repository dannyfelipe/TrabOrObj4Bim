package br.univel;

/**
 * 
 * @author Danny Felipe, 01/11/2015 - 19:47:01
 * 
 * Classe Usuario
 * Atributos da classe que receberão os dados no formulário de cadastro
 *
 */

public class Usuario {
	
	private int id_u;
	private int cliente_id;
	private String cliente;
	private String username;
	private String password;
	
	/*
	 * Construtor padrão
	 */
	public Usuario() {
		
	}

	/*
	 * Getters & Setters
	 */
	public int getId_u() {
		return id_u;
	}
	public void setId_u(int id_u) {
		this.id_u = id_u;
	}

	public int getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}

	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public String getUsername() {
		return password;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

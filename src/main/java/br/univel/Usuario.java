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
	
	private int id;
	private Cliente cliente;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getUsername() {
		return username;
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

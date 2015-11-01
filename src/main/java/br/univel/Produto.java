package br.univel;

/**
 * @author Danny Felipe, 01/11/2015 - 19:45:59
 * 
 * Classe Produto
 * Atributos da classe que receberão os dados no formulário de cadastro
 */

import java.math.BigDecimal;

public class Produto {

	private int id_p;
	private int barcode;
	private String categoria;
	private String descricao;
	private String unidade;
	private BigDecimal custo;
	private BigDecimal mlucro;

	/*
	 *  construtor padrão
	 */
	public Produto() {

	}
	
	/*
	 * construtores da classe
	 */
	public Produto(int id_p, int barcode, String categoria, String descricao,
			String unidade, BigDecimal custo, BigDecimal margenLucro) {
		this.id_p = id_p;
		this.barcode = barcode;
		this.categoria = categoria;
		this.descricao = descricao;
		this.unidade = unidade;
		this.custo = custo;
		this.mlucro = mlucro;
	}
	
	/*
	 * construtores da classe
	 */
	public Produto(int barcode, String categoria, String descricao,
			String unidade, BigDecimal custo, BigDecimal mlucro) {
		this.barcode = barcode;
		this.categoria = categoria;
		this.descricao = descricao;
		this.unidade = unidade;
		this.custo = custo;
		this.mlucro = mlucro;
	}
	
	// Getters & Setters
	public int getId_p() {
		return id_p;
	}
	public void setId_p(int id_p) {
		this.id_p = id_p;
	}

	public int getBarcode() {
		return barcode;
	}
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public BigDecimal getCusto() {
		return custo;
	}
	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	public BigDecimal getMlucro() {
		return mlucro;
	}
	public void setMlucro(BigDecimal mlucro) {
		this.mlucro = mlucro;
	}

}

package br.univel;

/**
 * @author Danny Felipe, 01/11/2015 - 19:48:30
 * 
 * Classe Venda
 * Atributos da classe que receberão os dados no formulário de cadastro
 */

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

public class Venda {

	private int id_v;
	private int cliente_id;
	private String cliente;
	private int produto_id;
	private String produto;
	private BigDecimal vtotal;
	private BigDecimal vpagamento;
	private BigDecimal troco;
	//private Date data;
	//private Time hora;
	private String data;
	private String hora;

	/*
	 * Construtor padrão
	 */
	public Venda() {

	}

	/*
	 * Construtores da classe
	 */
	public Venda(int id_v, int cliente_id, String cliente, int produto_id,
			String produto, BigDecimal vtotal, BigDecimal vpagamento,
			BigDecimal troco, String data, String hora) {
		this.id_v = id_v;
		this.cliente_id = cliente_id;
		this.produto_id = produto_id;
		this.cliente = cliente;
		this.produto = produto;
		this.vtotal = vtotal;
		this.vpagamento = vpagamento;
		this.troco = troco;
		this.data = data;
		this.hora = hora;
	}

	/*
	 * Construtores da classe
	 */
	public Venda(int cliente_id, String cliente, int produto_id,
			String produto, BigDecimal vtotal, BigDecimal vpagamento,
			BigDecimal troco, String data, String hora) {
		this.cliente_id = cliente_id;
		this.cliente = cliente;
		this.produto_id = produto_id;
		this.produto = produto;
		this.vtotal = vtotal;
		this.vpagamento = vpagamento;
		this.troco = troco;
		this.data = data;
		this.hora = hora;

	}

	/*
	 * Getters & Setters
	 */
	public int getId_v() {
		return id_v;
	}

	public void setId_v(int id_v) {
		this.id_v = id_v;
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

	public int getProduto_id() {
		return produto_id;
	}

	public void setProduto_id(int produto_id) {
		this.produto_id = produto_id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public BigDecimal getVtotal() {
		return vtotal;
	}

	public void setVtotal(BigDecimal vtotal) {
		this.vtotal = vtotal;
	}

	public BigDecimal getVpagamento() {
		return vpagamento;
	}

	public void setVpagamento(BigDecimal vpagamento) {
		this.vpagamento = vpagamento;
	}

	public BigDecimal getTroco() {
		return troco;
	}

	public void setTroco(BigDecimal troco) {
		this.troco = troco;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

}

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
	private int produto_id;
	private String cliente;
	private String produto;
	private BigDecimal valor_compra;
	private BigDecimal valor_pago;
	private BigDecimal troco;
	private Date data;
	private Time hora;

	/*
	 * Construtor padrão
	 */
	public Venda() {

	}

	/*
	 * Construtores da classe
	 */
	public Venda(int id_v, int cliente_id, int produto_id, String cliente,
			String produto, BigDecimal valor_compra, BigDecimal valor_pago,
			BigDecimal troco, Date data, Time hora) {
		this.id_v = id_v;
		this.cliente_id = cliente_id;
		this.cliente = cliente;
		this.produto = produto;
		this.valor_compra = valor_compra;
		this.valor_pago = valor_pago;
		this.troco = troco;
		this.data = data;
		this.hora = hora;
	}

	/*
	 * Construtores da classe
	 */
	public Venda(int cliente_id, int produto_id, String cliente,
			String produto, BigDecimal valor_compra, BigDecimal valor_pago,
			BigDecimal troco, Date data, Time hora) {
		this.cliente_id = cliente_id;
		this.cliente = cliente;
		this.produto = produto;
		this.valor_compra = valor_compra;
		this.valor_pago = valor_pago;
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

	public int getProduto_id() {
		return produto_id;
	}

	public void setProduto_id(int produto_id) {
		this.produto_id = produto_id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public BigDecimal getValor_compra() {
		return valor_compra;
	}

	public void setValor_compra(BigDecimal valor_compra) {
		this.valor_compra = valor_compra;
	}

	public BigDecimal getValor_pago() {
		return valor_pago;
	}

	public void setValor_pago(BigDecimal valor_pago) {
		this.valor_pago = valor_pago;
	}

	public BigDecimal getTroco() {
		return troco;
	}

	public void setTroco(BigDecimal troco) {
		this.troco = troco;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

}

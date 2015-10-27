package br.univel;

import java.math.BigDecimal;

public class Vendas {
	
	private Cliente cliente;
	private Produto produto;
	private BigDecimal valor_compra;
	private BigDecimal valor_pago;
	private BigDecimal troco;
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
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
	
	 

}

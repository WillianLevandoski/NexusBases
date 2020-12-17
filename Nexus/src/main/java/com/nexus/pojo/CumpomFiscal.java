package com.nexus.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "cumpomfiscal")
public class CumpomFiscal extends Pojo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "data")
	private Date data;
	
	@Column(name = "total")
	private Double total;

	@Column(name = "forma_pagamento")
	private Double formaDePagamento;
	
//----Relacões	

    @ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
    
    
    
	
	@OneToOne(mappedBy = "venda")
	private Venda venda;

	
//----Gets e Sets
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(Double formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
}

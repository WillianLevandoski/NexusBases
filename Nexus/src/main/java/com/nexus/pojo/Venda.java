package com.nexus.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "venda")
public class Venda extends Pojo {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "quantidade")
	private Integer quantidade;
	
	
//----Relacões
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "produto_id", referencedColumnName = "id")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "cupomfiscal_id", referencedColumnName = "id")
	private CumpomFiscal cupomFiscal;


//----Gets e Sets
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public CumpomFiscal getCupomFiscal() {
		return cupomFiscal;
	}

	public void setCupomFiscal(CumpomFiscal cupomFiscal) {
		this.cupomFiscal = cupomFiscal;
	}
	
	
	
	
	
}

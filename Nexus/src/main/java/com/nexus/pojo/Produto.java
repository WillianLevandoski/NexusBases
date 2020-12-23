package com.nexus.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto extends Pojo {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "descricao")
	private String descricao;

	@Column(name = "codigo_de_barras")
	private String codigoDeBarras;
	
	@Column(name = "quantidade")
	private Integer quantidade;
	
	@Column(name = "preco_compra")
	private Double precoCompra;
	
	@Column(name = "valor_venda")
	private Double valorVenda;
	
	@Column(name = "margem_lucro")
	private Double margemLucro;
	
//----Relacões
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fornecedor_id", referencedColumnName = "id")
	private Fornecedor fornecedor;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "nfe_id", referencedColumnName = "id")
	private NFE nfe;



//----Gets e Sets
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public Double getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(Double precoCompra) {
		this.precoCompra = precoCompra;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Double getMargemLucro() {
		return margemLucro;
	}

	public void setMargemLucro(Double margemLucro) {
		this.margemLucro = margemLucro;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public NFE getNfe() {
		return nfe;
	}

	public void setNfe(NFE nfe) {
		this.nfe = nfe;
	}
	
}

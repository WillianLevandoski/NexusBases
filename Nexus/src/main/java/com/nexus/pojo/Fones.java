package com.nexus.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "fones")
public class Fones extends Pojo { 
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "numero")
	private String numero;
	
	@Column(name = "relacao")
	private String relacao;
	
	@Column(name = "id_relacao")
	private Integer idRelacao;
	
	
//----Gets e Sets

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRelacao() {
		return relacao;
	}

	public void setRelacao(String relacao) {
		this.relacao = relacao;
	}

	public Integer getIdRelacao() {
		return idRelacao;
	}

	public void setIdRelacao(Integer idRelacao) {
		this.idRelacao = idRelacao;
	}
	

}

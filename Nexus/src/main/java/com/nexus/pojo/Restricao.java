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

@Table(name = "restricao")
public class Restricao extends Pojo {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "tela")
	private String tela;
	
	@Column(name = "consultar")
	private boolean consultar;
	
	@Column(name = "cadastrar")
	private boolean cadastrar;
	
	@Column(name = "alterar")
	private boolean alterar;
	
	@Column(name = "excluir")
	private boolean exlcuir;
	
	@ManyToOne
	@JoinColumn(name = "grupo_id", referencedColumnName = "id")
	private Grupo grupo;
	
	
//----Gets e Sets
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTela() {
		return tela;
	}

	public void setTela(String tela) {
		this.tela = tela;
	}

	public boolean isConsultar() {
		return consultar;
	}

	public void setConsultar(boolean consultar) {
		this.consultar = consultar;
	}

	public boolean isCadastrar() {
		return cadastrar;
	}

	public void setCadastrar(boolean cadastrar) {
		this.cadastrar = cadastrar;
	}

	public boolean isAlterar() {
		return alterar;
	}

	public void setAlterar(boolean alterar) {
		this.alterar = alterar;
	}

	public boolean isExlcuir() {
		return exlcuir;
	}

	public void setExlcuir(boolean exlcuir) {
		this.exlcuir = exlcuir;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
}

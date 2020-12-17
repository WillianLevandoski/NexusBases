package com.nexus.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario extends Pojo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "email")
	private String email;

	@Column(name = "senha")
	private String senha;

//----Relacões

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "grupo_id", referencedColumnName = "id")
	private Grupo grupo;
	
//	@OneToOne(mappedBy = "fornecedor")
//	private Fornecedor forncedor;
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cumpomfiscal")
//	private Set<CumpomFiscal> cumpomFiscal;
	
	
	@Column(name = "telefone")
	private String telefone;
	 
//	@OneToOne(mappedBy = "fornecedor")
//	private Fornecedor fornecedor;
	

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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}


//	public Set<CumpomFiscal> getCumpomFiscal() {
//		return cumpomFiscal;
//	}
//
//	public void setCumpomFiscal(Set<CumpomFiscal> cumpomFiscal) {
//		this.cumpomFiscal = cumpomFiscal;
//	}

//	public Fornecedor getForncedor() {
//		return forncedor;
//	}
//
//	public void setForncedor(Fornecedor forncedor) {
//		this.forncedor = forncedor;
//	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

//	public Fornecedor getFornecedor() {
//		return fornecedor;
//	}
//
//	public void setFornecedor(Fornecedor fornecedor) {
//		this.fornecedor = fornecedor;
//	}
	
}
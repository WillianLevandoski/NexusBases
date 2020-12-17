package com.nexus.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "grupo")
public class Grupo extends Pojo {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "parametros")
	private String parametros;
	
	
//----Gets e Sets	

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getParametros() {
		return parametros;
	}

	public void setParametros(String parametros) {
		this.parametros = parametros;
	}

//	public Restricao getRestricao() {
//		return restricao;
//	}
	
//	public void setRestricao(Restricao restricao) {
//	this.restricao = restricao;
//}
//
//
//	public Set<Usuario> getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(Set<Usuario> usuario) {
//		this.usuario = usuario;
//	}


}

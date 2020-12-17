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
@Table(name = "fornecedor")
public class Fornecedor extends Pojo {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "telefone")
	private String fone;
	
	@Column(name = "email")
	private String email;
	
//----Relacões	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;
	

	
//----Gets e Sets
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setId(Integer cod) {
		// TODO Auto-generated method stub
		
	}
	

}

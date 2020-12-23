package com.nexus.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.nexus.pojo.Pojo;
import com.nexus.pojo.Produto;

public class Busca extends DAO {
	
	Pojo pojo = null;
	Criteria query;
	MatchMode restricao = MatchMode.EXACT;
	public MatchMode IGUAL = MatchMode.EXACT;
	public MatchMode CONTEM = MatchMode.ANYWHERE;
	public MatchMode COMECO = MatchMode.START;
	public MatchMode FIM = MatchMode.START;
	
	
	//Ajustar para  throw exception
	public Busca(Class clazz) {
		query = getSession().createCriteria(clazz);
	}
	
	public void add(String chave, String valor) {
		query.add(Restrictions.like(chave, valor, restricao));
	}
	
	public void add(Integer id) {
		query.add(Restrictions.idEq(id));
	}
	
	
	public void add(String chave, String valor, MatchMode restricao) {
		query.add(Restrictions.like(chave, valor, restricao));
	}
	
	public  List<Pojo> listarTudo() {
		try {
			List<Pojo> lsPojo = (List<Pojo>) query.list();
			return lsPojo;
		} catch (HibernateException e) {
			rollback();
		}
		return null;
	}
	
	public  Pojo obter() {
		try {
			return (Pojo) query.uniqueResult();
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void addRestricao(MatchMode restricao) {
		this.restricao = restricao;
	}

	
}

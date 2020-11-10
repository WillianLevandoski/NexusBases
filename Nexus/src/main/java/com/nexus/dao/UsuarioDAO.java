package com.nexus.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.nexus.exception.UsuarioException;
import com.nexus.pojo.Usuario;

public class UsuarioDAO extends SuperDAO {

	public Usuario get(String nome, String senha) throws UsuarioException {
		try {
			begin();
			Query q = getSession().createQuery("from Usuario where usuario = :usuario and senha = :senha");
			q.setString("usuario", nome);
			q.setString("senha", senha);
			Usuario usuario = (Usuario) q.uniqueResult();
			commit();
			return usuario;
		} catch (HibernateException e) {
			rollback();
			throw new UsuarioException("Could not get usuario " + nome, e);
		}
	}
	
	public  Optional<Usuario> get(int id) throws UsuarioException {
		try {
			begin();
			Query q = getSession().createQuery("from Usuario where id= :id");
			q.setInteger("id", id);		
			Usuario usuario = (Usuario) q.uniqueResult();
			commit();
			return Optional.of(usuario);
		} catch (HibernateException e) {
			rollback();
		}
		return Optional.empty();

	}
	
	public List<Usuario> listarTodos() {
	    CriteriaBuilder cb = getSession().getCriteriaBuilder();
	    CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
	    Root<Usuario> rootEntry = cq.from(Usuario.class);
	    CriteriaQuery<Usuario> all = cq.select(rootEntry);
	 
	    TypedQuery<Usuario> allQuery = getSession().createQuery(all);
	    return allQuery.getResultList();
	}

	public Usuario register(Usuario u)throws UsuarioException {
		try {
			begin();
			getSession().save(u);
			commit();
			return u;
		} catch (HibernateException e) {
			rollback();
			throw new UsuarioException("Exception while creating user: " + e.getMessage());
		}
	}

	public void delete(Usuario usuario) throws UsuarioException {
		try {
			begin();
			getSession().delete(usuario);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UsuarioException("Could not delete user " + usuario.getNome(), e);
		}
	}
	
	public Optional<Usuario> getUsuarioPorEmailESenha(String email, String senha){
		//TODO: senha para md5
		try {
			begin();
			Query q = getSession().createQuery("FROM Usuario where email= :email AND senha= :senha");
			q.setString("email", email);
			q.setString("senha", senha);
			Usuario usuario = (Usuario) q.uniqueResult();
			commit();
			return Optional.of(usuario);
		} catch (HibernateException e) {
			rollback();
		}
		return Optional.empty();
	}
	

	public Optional<Usuario> getUsuarioPorNome(String nome){
		try {
			begin();
			Query q = getSession().createQuery("from Usuario where nome= :nome");
			q.setString("nome", nome);
			Usuario usuario = (Usuario) q.uniqueResult();
			commit();
			return Optional.of(usuario);
		} catch (HibernateException e) {
			rollback();
		}
		return Optional.empty();
	}
	
}
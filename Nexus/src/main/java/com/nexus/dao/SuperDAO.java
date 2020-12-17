package com.nexus.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.nexus.exception.UsuarioException;
import com.nexus.pojo.Pojo;
import com.nexus.pojo.Usuario;
import com.nexus.utils.Busca;


public class SuperDAO <P extends Pojo> extends DAO {
	
	
		private static final long serialVersionUID = 4738690556487758985L;
	    public Class getClassPojo() {
	        ParameterizedType tipo = ((ParameterizedType) this.getClass().getGenericSuperclass());
	        return (Class) tipo.getActualTypeArguments()[0];

	    }
	
	  public static Session getSession(){
	        return DAO.getSession();
	  }
	  
	  public Usuario get(String nome, String senha) throws UsuarioException {
			try {
				begin();
				Query q = getSession().createQuery("from Usuario where usuario = :usuario and senha = :senha");
				q.setString("usuario", nome);
				q.setString("senha", senha);
				Usuario usuario = (Usuario) q.uniqueResult();
				//commit();
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
		
		public List<Pojo> listarTodos(Class clazz) {
		    CriteriaBuilder cb = getSession().getCriteriaBuilder();
		    CriteriaQuery<Pojo> cq = cb.createQuery(clazz);
		    Root<Pojo> rootEntry = cq.from(clazz);
		    CriteriaQuery<Pojo> all = cq.select(rootEntry);
		    TypedQuery<Pojo> allQuery = getSession().createQuery(all);
		    return allQuery.getResultList();
		    
		}
		
		public  List<Pojo> pesquisa(String nome, Class clazz) {
			try {
				Criteria query = getSession().createCriteria(clazz);
				query.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE));
				List<Pojo> lsPojo = (List<Pojo>) query.list();
				return lsPojo;
			} catch (HibernateException e) {
				rollback();
			}
			return null;
		}

		public Usuario cadastrar(Usuario u)throws UsuarioException {
			try {
				begin();
				getSession().save(u);
				commit();
				return u;
			} catch (HibernateException e) {
				rollback();
				throw new UsuarioException("Erro ao criar Usuario: " + e.getMessage());
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
			System.out.println(getClassPojo().getName());

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

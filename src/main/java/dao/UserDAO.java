package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import entities.User;
import utils.JpaUtil;

public class UserDAO {
	private EntityManager em;

	public UserDAO() {
		this.em = JpaUtil.getEntityManager();
	}

	public User insert(User user) {
		try {
			this.em.getTransaction().begin();
			this.em.persist(user);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
		
		return user;
	}
	
	public void update(User user) {
		try {
			this.em.getTransaction().begin();
			
			this.em.merge(user);
			
			this.em.getTransaction().commit();
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public void delete(User user) {
		try {
			this.em.getTransaction().begin();
			
			this.em.remove(user);
			
			this.em.getTransaction().commit();
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public User findById(int id) {
		User user = this.em.find(User.class, id);

		return user;
	}
	
	public List<User> findAll() {
		String jpql = "SELECT user FROM User user";
		TypedQuery<User> query = this.em.createQuery(jpql, User.class);
		List<User> list = query.getResultList();
		
		return list;
	}
	
	public User login(String email, String password) {
		String hql = "SELECT u FROM User u "
			+ "WHERE u.email = :email AND u.password = :pwd";
		
		TypedQuery<User> query = this.em.createQuery(hql, User.class);
		query.setParameter("email", email);
		query.setParameter("pwd", password);
		
		try {
			User u = query.getSingleResult();
			return u;
		} catch (NoResultException e) {
			e.printStackTrace();
		}

		return null;
	}
}

package dao;

import java.util.List;

import javax.persistence.EntityManager;
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
}

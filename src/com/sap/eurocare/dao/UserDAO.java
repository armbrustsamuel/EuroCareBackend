package com.sap.eurocare.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sap.eurocare.model.User;

@Repository
public class UserDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public Collection<User> getAllUsers(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> criteria = cb.createQuery(User.class); 
		Collection<User> resultList = em.createQuery(criteria).getResultList();
		return resultList;
	}
	
	public User getUserById(long id){
		User user = em.find(User.class, id);
		return user;
	}
	
	/*
	 * Transactional methods
	 */
	
	@Transactional
	public User createUser(User user){
		em.persist(user);
		return user;
	}
	
	@Transactional
	public void deleteUser(long id) {
		User user = getUserById(id);

		if (user != null) {
			em.remove(user);
		}
	}
	
	@Transactional
	public User updateUser(long id, User newUser){
		User user = getUserById(id);
		
		user.setName(newUser.getName());
		user.setGender(newUser.getGender());
		user.setBirthDate(newUser.getBirthDate());
		
		em.merge(user);
		return user;
	}
}
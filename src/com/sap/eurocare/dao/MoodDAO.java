package com.sap.eurocare.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sap.eurocare.model.Mood;

@Repository
public class MoodDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Collection<Mood> getAllEvents(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Mood> criteria = cb.createQuery(Mood.class); 
		Collection<Mood> resultList = em.createQuery(criteria).getResultList();
		return resultList;
	}
	
	/*
	 * Transactional methods
	 */
	
	@Transactional
	public Mood createMood(Mood mood){
		em.persist(mood);
		return mood;
	}
	
	// Add get mood by date (MAYBE)
	
}
//
//public Event getEventById(long id){
//	Event evt = em.find(Event.class, id);
//	return evt;
//}
//

//
//@Transactional
//public Event updateEvent(long id, Event newEvent){
//	Event evt = getEventById(id);
//	
//	evt.setName(newEvent.getName());
//	evt.setDescription(newEvent.getDescription());
//	
//	em.merge(evt);
//	return evt;
//}

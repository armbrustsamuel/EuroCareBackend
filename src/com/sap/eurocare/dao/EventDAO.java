package com.sap.eurocare.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sap.eurocare.model.Event;

@Repository
public class EventDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public Collection<Event> getAllEvents(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Event> criteria = cb.createQuery(Event.class); 
		Collection<Event> resultList = em.createQuery(criteria).getResultList();
		return resultList;
	}
	
	public Event getEventById(long id){
		Event evt = em.find(Event.class, id);
		return evt;
	}
	
	/*
	 * Transactional methods
	 */
	
	@Transactional
	public Event createEvent(Event evt){
		em.persist(evt);
		return evt;
	}
	
	@Transactional
	public void deleteEvent(long id) {
		Event evt = getEventById(id);

		if (evt != null) {
			em.remove(evt);
		}
	}
	
	@Transactional
	public Event updateEvent(long id, Event newEvent){
		Event evt = getEventById(id);
		
		evt.setName(newEvent.getName());
		evt.setDescription(newEvent.getDescription());
		
		em.merge(evt);
		return evt;
	}
}

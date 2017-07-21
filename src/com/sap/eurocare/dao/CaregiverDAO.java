package com.sap.eurocare.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sap.eurocare.model.Caregiver;
import com.sap.eurocare.model.Event;
import com.sap.eurocare.model.Patient;
import com.sap.eurocare.model.User;

@Repository
public class CaregiverDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public Collection<Caregiver> getAllCaregivers(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Caregiver> criteria = cb.createQuery(Caregiver.class); 
		Collection<Caregiver> resultList = em.createQuery(criteria).getResultList();
		return resultList;
	}
	
	public Caregiver getCaregiverById(long id){
		Caregiver caregiver = em.find(Caregiver.class, id);
		return caregiver;
	}
	
	/*
	 * Transactional methods
	 */
	
	@Transactional
	public Caregiver createCaregiver(Caregiver caregiver){
		em.persist(caregiver);
		return caregiver;
	}
	
	@Transactional
	public void deleteCaregiver(long id) {
		Caregiver caregiver = getCaregiverById(id);

		if (caregiver != null) {
			em.remove(caregiver);
		}
	}
	
	@Transactional
	public Caregiver updateCaregiver(long id, Caregiver newCaregiver){
		Caregiver caregiver = getCaregiverById(id);
		
		caregiver.setName(newCaregiver.getName());
		caregiver.setGender(newCaregiver.getGender());
		caregiver.setBirthDate(newCaregiver.getBirthDate());
		caregiver.setRegistrationDate(newCaregiver.getRegistrationDate());
		
		em.merge(caregiver);
		return caregiver;
	}
}

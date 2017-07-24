package com.sap.eurocare.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sap.eurocare.model.DoctorAnswer;




@Repository
public class DoctorAnswerDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public Collection<DoctorAnswer> getAllDoctorAnswers(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<DoctorAnswer> criteria = cb.createQuery(DoctorAnswer.class); 
		Collection<DoctorAnswer> resultList = em.createQuery(criteria).getResultList();
		return resultList;
	}
	
	public DoctorAnswer getDoctorAnswerById(long id){
		DoctorAnswer doctorAnswer = em.find(DoctorAnswer.class, id);
		return doctorAnswer;
	}
	
	/*
	 * Transactional methods
	 */
	
	@Transactional
	public DoctorAnswer createDoctorAnswer(DoctorAnswer doctorAnswer){
		em.persist(doctorAnswer);
		return doctorAnswer;
	}
	
	//Is this function really useful to our system?
	/*
	@Transactional
	public void deleteDoctorAnswer(long id) {
		DoctorAnswer doctorAnswer = getDoctorAnswerById(id);

		if (doctorAnswer != null) {
			em.remove(doctorAnswer);
		}
	}
	*/
	
	@Transactional
	public DoctorAnswer updateDoctorAnswer(long id, DoctorAnswer newDoctorAnswer){
		DoctorAnswer doctorAnswer = getDoctorAnswerById(id);
		
		doctorAnswer.setMessage(newDoctorAnswer.getMessage());
		
		
		em.merge(doctorAnswer);
		return doctorAnswer;
	}
}
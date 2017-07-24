package com.sap.eurocare.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.sap.eurocare.model.Question;




@Repository
public class QuestionDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public Collection<Question> getAllQuestions(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Question> criteria = cb.createQuery(Question.class); 
		Collection<Question> resultList = em.createQuery(criteria).getResultList();
		return resultList;
	}
	
	public Question getQuestionById(long id){
		Question question = em.find(Question.class, id);
		return question;
	}
	
	/*
	 * Transactional methods
	 */
	
	@Transactional
	public Question createQuestion(Question question){
		em.persist(question);
		return question;
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
	public Question updateQuestion(long id, Question newQuestion){
		Question question = getQuestionById(id);
		
		question.setMessage(newQuestion.getMessage());
		
		
		em.merge(question);
		return question;
	}
}
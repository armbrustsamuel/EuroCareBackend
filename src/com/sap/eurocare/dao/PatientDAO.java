package com.sap.eurocare.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sap.eurocare.model.Patient;

@Repository
public class PatientDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public Collection<Patient> getAllPatients(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Patient> criteria = cb.createQuery(Patient.class); 
		Collection<Patient> resultList = em.createQuery(criteria).getResultList();
		return resultList;
	}
	
	public Patient getPatientById(long id){
		Patient patient = em.find(Patient.class, id);
		return patient;
	}
	
	/*
	 * Transactional methods
	 */
	
	@Transactional
	public Patient createPatient(Patient patient){
		em.persist(patient);
		return patient;
	}
	
	@Transactional
	public void deletePatient(long id) {
		Patient patient = getPatientById(id);

		if (patient != null) {
			em.remove(patient);
		}
	}
	
	@Transactional
	public Patient updatePatient(long id, Patient newPatient){
		Patient patient = getPatientById(id);
		
		patient.setName(newPatient.getName());
		patient.setGender(newPatient.getGender());
		patient.setBirthDate(newPatient.getBirthDate());
		patient.setDiagnosalDate(newPatient.getDiagnosalDate());
		
		em.merge(patient);
		return patient;
	}
}
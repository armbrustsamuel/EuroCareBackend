package com.sap.eurocare.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Transactional;

import com.sap.eurocare.model.Doctor;
import com.sap.eurocare.model.User;

public class DoctorDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public Collection<Doctor> getAllDoctors(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Doctor> criteria = cb.createQuery(Doctor.class); 
		Collection<Doctor> resultList = em.createQuery(criteria).getResultList();
		return resultList;
	}
	
	public Doctor getDoctorById(long id){
		Doctor doctor = em.find(Doctor.class, id);
		return doctor;
	}
	
	/*
	 * Transactional methods
	 */
	
	@Transactional
	public Doctor createDoctor(Doctor doctor){
		em.persist(doctor);
		return doctor;
	}
	
	@Transactional
	public void deleteDoctor(long id) {
		Doctor doctor = getDoctorById(id);

		if (doctor != null) {
			em.remove(doctor);
		}
	}
	
	@Transactional
	public Doctor updateDoctor(long id, Doctor newDoctor){
		Doctor doctor = getDoctorById(id);
		
		doctor.setName(newDoctor.getName());
		doctor.setGender(newDoctor.getGender());
		doctor.setBirthDate(newDoctor.getBirthDate());
		
		em.merge(doctor);
		return doctor;
	}
}

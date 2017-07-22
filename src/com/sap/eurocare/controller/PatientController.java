package com.sap.eurocare.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sap.eurocare.dao.PatientDAO;
import com.sap.eurocare.model.Patient;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientDAO patientDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<Patient> findAll() {
		return patientDao.getAllPatients();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Patient findById(@PathVariable long id) {
		return patientDao.getPatientById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Patient create(@RequestBody Patient patient) {
		return patientDao.createPatient(patient);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void delete(@PathVariable long id) {
		patientDao.deletePatient(id);
	}

}
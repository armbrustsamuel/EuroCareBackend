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

import com.sap.eurocare.dao.DoctorDAO;
import com.sap.eurocare.model.Doctor;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorDAO doctorDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<Doctor> findAll() {
		return doctorDao.getAllDoctors();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Doctor findById(@PathVariable long id) {
		return doctorDao.getDoctorById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Doctor create(@RequestBody Doctor doctor) {
		return doctorDao.createDoctor(doctor);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void delete(@PathVariable long id) {
		doctorDao.deleteDoctor(id);
	}

}
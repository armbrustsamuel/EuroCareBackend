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

import com.sap.eurocare.dao.DoctorAnswerDAO;
import com.sap.eurocare.model.DoctorAnswer;

@Controller
@RequestMapping("/doctorAnswer")
public class DoctorAnswerController {

	@Autowired
	private DoctorAnswerDAO doctorAnswerDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<DoctorAnswer> findAll() {
		return doctorAnswerDao.getAllDoctorAnswers();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody DoctorAnswer findById(@PathVariable long id) {
		return doctorAnswerDao.getDoctorAnswerById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody DoctorAnswer create(@RequestBody DoctorAnswer doctorAnswer) {
		return doctorAnswerDao.createDoctorAnswer(doctorAnswer);
	}
	
	/*
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void delete(@PathVariable long id) {
		doctorAnswerDao.deleteDoctorAnswer(id);
	}
	*/
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody DoctorAnswer updateDoctorAnswer(@PathVariable long id, @RequestBody DoctorAnswer doctorAnswer) {
		return doctorAnswerDao.updateDoctorAnswer(id, doctorAnswer);
	}

}
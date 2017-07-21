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

import com.sap.eurocare.dao.CaregiverDAO;
import com.sap.eurocare.dao.EventDAO;
import com.sap.eurocare.dao.UserDAO;
import com.sap.eurocare.model.Caregiver;
import com.sap.eurocare.model.Event;
import com.sap.eurocare.model.User;

@Controller
@RequestMapping("/careGiver")
public class CaregiverController {

	@Autowired
	private CaregiverDAO caregiverDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<Caregiver> findAll() {
		return caregiverDao.getAllCaregivers();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Caregiver findById(@PathVariable long id) {
		return caregiverDao.getCaregiverById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Caregiver create(@RequestBody Caregiver caregiver) {
		return caregiverDao.createCaregiver(caregiver);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void delete(@PathVariable long id) {
		caregiverDao.deleteCaregiver(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Caregiver updateCaregiver(@PathVariable long id, @RequestBody Caregiver caregiver) {
		return caregiverDao.updateCaregiver(id, caregiver);
	}

}
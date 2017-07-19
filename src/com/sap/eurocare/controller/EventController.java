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

import com.sap.eurocare.dao.EventDAO;
import com.sap.eurocare.model.Event;

@Controller
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventDAO evtDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<Event> findAll() {
		return evtDao.getAllEvents();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Event findById(@PathVariable long id) {
		return evtDao.getEventById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Event create(@RequestBody Event evt) {
		return evtDao.createEvent(evt);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void delete(@PathVariable long id) {
		evtDao.deleteEvent(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Event setOccupied(@PathVariable long id, @RequestBody Event evt) {
		return evtDao.updateEvent(id, evt);
	}

}
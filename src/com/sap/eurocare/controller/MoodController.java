package com.sap.eurocare.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sap.eurocare.dao.MoodDAO;
import com.sap.eurocare.model.Mood;

@Controller
@RequestMapping("/mood")
public class MoodController {
	
	@Autowired
	private MoodDAO moodDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<Mood> findAll() {
		return moodDao.getAllEvents();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Mood create(@RequestBody Mood mood) {
		return moodDao.createMood(mood);
	}

}

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
import com.sap.eurocare.dao.UserDAO;
import com.sap.eurocare.model.Event;
import com.sap.eurocare.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDAO userDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<User> findAll() {
		return userDao.getAllUsers();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody User findById(@PathVariable long id) {
		return userDao.getUserById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody User create(@RequestBody User user) {
		return userDao.createUser(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void delete(@PathVariable long id) {
		userDao.deleteUser(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody User updateUser(@PathVariable long id, @RequestBody User user) {
		return userDao.updateUser(id, user);
	}

}
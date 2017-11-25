package com.sap.eurocare.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sap.eurocare.dao.QuestionDAO;
import com.sap.eurocare.model.Question;

//@Controller
//@RequestMapping("/patient")
//@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionDAO questionDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<Question> findAll() {
		return questionDao.getAllQuestions();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Question findById(@PathVariable long id) {
		return questionDao.getQuestionById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Question create(@RequestBody Question question) {
		return questionDao.createQuestion(question);
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
	public @ResponseBody Question updateDoctorAnswer(@PathVariable long id, @RequestBody Question question) {
		return questionDao.updateQuestion(id, question);
	}

}
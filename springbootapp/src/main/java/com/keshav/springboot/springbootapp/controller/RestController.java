package com.keshav.springboot.springbootapp.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.keshav.springboot.springbootapp.beans.Student;

@org.springframework.web.bind.annotation.RestController

/***
 * Controller for Student management application
 * @author kesav
 *
 */
public class RestController {
	Logger logger = LoggerFactory.getLogger(RestController.class);

	@RequestMapping(value = "/hello")
	@GetMapping
	public String sayHello() {
		return "Hi Everyone how are you!";
	}
	
	@RequestMapping(value = "/studentDetails")
	@GetMapping
	public Student getStudentDetails() {
		long startTime = System.currentTimeMillis();
		logger.info("going to execute studentDetails method");
		Student student = new Student();
		student.setStudentName("Ramu");
		student.setStudentId("420");
		student.setStudentGrade("D");
		logger.info("successfully executed studentDetails method");
		long endTime = System.currentTimeMillis();
		logger.info("studentDetails method executed in "+(endTime-startTime)+" milliseconds");
		return student;
	}
	
	/***
	 * Method to create student details
	 * @param student object
	 * @return status of insert operation
	 */
	@RequestMapping(value = "/addStudents", method=RequestMethod.POST)
	public String addStudent(@RequestBody Object student) {
		return "Student details of "+" have been added successfully";
	}
	
	@RequestMapping(value = "/createStudents", method=RequestMethod.POST)
	public ResponseEntity<Object> createStudent(@RequestBody Student student) {
		return new ResponseEntity<Object>("Student details of "+student.getStudentName()+" has been created!",HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/students/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateStudent(@PathVariable("id") String id,@RequestBody Student student) {
		
		return new ResponseEntity<Object>("Student details of "+student.getStudentName()+" have been updated!", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/students/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteStudent(@PathVariable("id") String id, @RequestBody Student student) {
		
		return new ResponseEntity<Object>("Student details of "+student.getStudentName()+" have been deleted!", HttpStatus.OK);
	}
	
	
	
	
	
}

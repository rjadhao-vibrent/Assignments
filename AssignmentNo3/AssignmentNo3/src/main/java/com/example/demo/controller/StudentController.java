package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Students;
import com.example.demo.services.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

//representational state transfer

	@GetMapping("/")
	public String home() {
		return "This is home page";
	}

	// get the student
	@GetMapping("/student")
	public List<Students> getstudent() {
		return this.service.getStudent();
	}

	@GetMapping("/student/{StudentId}")
	public Students getStudent(@PathVariable String StudentId) {
		return this.service.getStudent(Long.parseLong(StudentId));

	}

	@PostMapping("/student")
	public Students addStudent(@RequestBody Students Student) {

		return this.service.addStudent(Student);

	}

	@PutMapping("/student/")
	public Students updateStudent(@RequestBody Students Student) {
		return this.service.updateStudent(Student);

	}

	@DeleteMapping("/student/{StudentId}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("StudentId") String StudentId) {
		try {
			this.service.deleteStudents(Long.parseLong(StudentId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
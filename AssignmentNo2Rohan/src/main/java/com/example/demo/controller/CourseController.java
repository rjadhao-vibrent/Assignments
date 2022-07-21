package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.demo.entities.Courses;
import com.example.demo.services.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService service;

	//representational state transfer

	@GetMapping("/")
	public String home() {
		return "This is home page";
	}

	// get the courses
	@GetMapping("/courses")
	public ResponseEntity<List<Courses>> getCourses() {
		List<Courses> list = service.getCourses();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(list));
	}

	@GetMapping("/courses/{courseId}")
	public ResponseEntity<Courses> getCourse(@PathVariable("courseId") String courseId) {
		Courses course = service.getCourse(Long.parseLong(courseId));
		if (course == null || course.getId() == 111) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.of(Optional.of(course));
	}

	@PostMapping("/courses")
	public ResponseEntity<Courses> addCourse(@RequestBody Courses course) {

		Courses cour = null;
		try {
			cour = this.service.addCourse(course);
			//System.out.println(cour);
			return ResponseEntity.of(Optional.of(cour));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	@PutMapping("/courses/{courseId}")
	public Courses updateCourse(@RequestBody Courses course, @PathVariable("courseId") int courseId, Courses Courses) {
		this.service.updateCourse(courseId, course);
		return Courses;
	}

	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<Void> deleteCourse(@PathVariable("courseId") int courseId) {
		try {
			this.service.deleteCourses(courseId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
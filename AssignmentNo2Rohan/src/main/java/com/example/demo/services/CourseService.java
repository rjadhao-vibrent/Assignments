package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Courses;

public interface CourseService {
	public List<Courses> getCourses();

	 

	public Courses getCourse(long courseId);



	public Courses addCourse(Courses course);



	public void updateCourse(int courseId,Courses course);



	public List<Courses> deleteCourses(int id);

	 
}
 
package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Students;

public interface StudentService {
	public List<Students> getStudents();

	 

	public List<Students> getStudent();



	public Students addStudent(Students Student);



	public Students updateStudent(Students Student);



	public void deleteStudents(long id);



	Students getStudent(long StudentId);

	 
}
 
package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customException.EmptyInputException;
import com.example.demo.dao.StudentDao;
import com.example.demo.entities.Students;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao Studentdao;

	public StudentServiceImpl() {

	}

	@Override
	public List<Students> getStudents() {
		return Studentdao.findAll();
	}
	 
	@SuppressWarnings("deprecation")
	@Override
	public Optional<Students> getStudent(long StudentId) {
		//return Studentdao.getById(StudentId);
		return Studentdao.findById(StudentId);

	}

	@Override
	public Students addStudent(Students Student) {
		if(Student.getDescription().isEmpty() || Student.getDescription().length() == 0) {
			throw new EmptyInputException("601","Input Fields are empty");
		}
		return Studentdao.save(Student);
	}

	@Override
	public Students updateStudent(Students Student) {
		Studentdao.save(Student);
		return Student;
	}

	@Override
	public void deleteStudents(long id) {
		@SuppressWarnings("deprecation")
		Students entity = Studentdao.getOne(id);
		Studentdao.delete(entity);
		
	}

	@Override
	public List<Students> getStudent() {
		// TODO Auto-generated method stub
		return null;
	}

}

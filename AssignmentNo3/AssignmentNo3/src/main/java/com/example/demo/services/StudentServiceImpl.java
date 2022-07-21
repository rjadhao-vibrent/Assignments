package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	 
	@Override
	public Students getStudent(long StudentId) {
		return Studentdao.getById(StudentId);

	}

	@Override
	public Students addStudent(Students Student) {
		return Studentdao.save(Student);
	}

	@Override
	public Students updateStudent(Students Student) {
		Studentdao.save(Student);
		return Student;
	}

	@Override
	public void deleteStudents(long id) {
		Students entity = Studentdao.getOne(id);
		Studentdao.delete(entity);
		
	}

	@Override
	public List<Students> getStudent() {
		// TODO Auto-generated method stub
		return null;
	}

}

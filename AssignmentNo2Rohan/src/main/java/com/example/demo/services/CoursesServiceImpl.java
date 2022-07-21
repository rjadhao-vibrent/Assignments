package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Courses;

@Service
public class CoursesServiceImpl implements CourseService {

	List<Courses> list;

	public CoursesServiceImpl() {
		list = new ArrayList<Courses>();
		list.add(new Courses(124, "java", "This course contains basics"));
		list.add(new Courses(123, "v22a", "This e basics"));

	}

	@Override
	public List<Courses> getCourses() {

		return list;
	}

	@Override
	public Courses getCourse(long courseId) {

		Courses c = null;
		try {
			for (Courses cc : list) {
				if (cc.getId() == courseId) {
					c = cc;
					break;

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Courses addCourse(Courses course) {
		list.add(course);
		return course;
	}

	@Override
	public void updateCourse(int id, Courses course) {
		list = list.stream().map(b -> {
			if (b.getId() == id) {
				b.setTitle(course.getTitle());
				b.setDescription(course.getDescription());
			}
			return b;
		}).collect(Collectors.toList());
	}

	@Override
	public List<Courses> deleteCourses(int id) {
		list = list.stream().filter(course -> course.getId() != id).collect(Collectors.toList());
		//System.out.println(list);
		return list;
	}

}

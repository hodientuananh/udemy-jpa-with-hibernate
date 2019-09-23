package com.benkinmat.database.udemyjpawithhibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benkinmat.database.udemyjpawithhibernate.entity.Course;
import com.benkinmat.database.udemyjpawithhibernate.jpa.CourseSpringRepository;

@Service
public class CourseSpringJpaService {
	@Autowired
	CourseSpringRepository courseSpringRepository;
	
	public Course saveCourse(Course course) {
	    return courseSpringRepository.save(course);
	  }

}

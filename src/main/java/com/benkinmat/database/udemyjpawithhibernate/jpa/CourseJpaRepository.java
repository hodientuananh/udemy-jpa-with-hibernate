package com.benkinmat.database.udemyjpawithhibernate.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.benkinmat.database.udemyjpawithhibernate.entity.Course;

@Repository
public class CourseJpaRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
	
}

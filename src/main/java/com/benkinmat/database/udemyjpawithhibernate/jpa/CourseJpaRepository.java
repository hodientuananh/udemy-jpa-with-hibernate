package com.benkinmat.database.udemyjpawithhibernate.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.benkinmat.database.udemyjpawithhibernate.entity.Course;

@Repository
@Transactional
public class CourseJpaRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(Long id) {
		Course course = findById(id);
		entityManager.remove(course);
	}
	
}

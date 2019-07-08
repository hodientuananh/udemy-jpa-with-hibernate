package com.benkinmat.database.udemyjpawithhibernate.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.benkinmat.database.udemyjpawithhibernate.UdemyJpaWithHibernateApplication;
import com.benkinmat.database.udemyjpawithhibernate.entity.Course;

@Repository
@Transactional
public class CourseJpaRepository {
	
	private static final Logger log = LoggerFactory.getLogger(UdemyJpaWithHibernateApplication.class);

	@PersistenceContext
	EntityManager entityManager;
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(Long id) {
		Course course = findById(id);
		entityManager.remove(course);
	}
	
	public Course save(Course course) {
		if (course.getId() == null) {
			entityManager.persist(course);
		}
		else {
			entityManager.merge(course);
		}
		
		return course;
	}
	
	public void playWithEntityManager() {
		Course course1 = new Course("Learn new stuff 1");
		entityManager.persist(course1);
		Course course2 = new Course("Learn new stuff 2");
		entityManager.persist(course2);
		
		entityManager.flush();
		
//		entityManager.clear();
//		entityManager.detach(course1);
		
		course1.setName("Learn new stuff 1 - Updated");
		course2.setName("Learn new stuff 2 - Updated");
		
		entityManager.refresh(course1);
		entityManager.flush();
	}
	
}

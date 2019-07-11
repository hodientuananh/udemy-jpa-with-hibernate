package com.benkinmat.database.udemyjpawithhibernate.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.benkinmat.database.udemyjpawithhibernate.UdemyJpaWithHibernateApplication;
import com.benkinmat.database.udemyjpawithhibernate.entity.Course;
import com.benkinmat.database.udemyjpawithhibernate.entity.Rating;
import com.benkinmat.database.udemyjpawithhibernate.entity.Review;

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

	public void addReviewsForCourse() {
		Course course = entityManager.find(Course.class, 1000L);
		log.info("Reviews of Course 1000: " + course.getReviews());
		Review review1 = new Review("Great Course Again", Rating.FIVE);
		Review review2 = new Review("Great Course Again Again", Rating.FIVE);
		
		course.addReview(review1);
		review1.setCourse(course);
		course.addReview(review2);
		review2.setCourse(course);
		
		entityManager.persist(review1);
		entityManager.persist(review2);
	}
	
	public void addReviewsForCourse(Long courseId, List<Review> reviews) {
		Course course = entityManager.find(Course.class, courseId);
		log.info("Reviews of Course " + courseId + course.getReviews());
		
		for (Review review : reviews) {
			course.addReview(review);
			review.setCourse(course);
			
			entityManager.persist(review);
		}
				
	}
	
}

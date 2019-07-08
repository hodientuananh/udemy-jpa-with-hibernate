package com.benkinmat.database.udemyjpawithhibernate.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.benkinmat.database.udemyjpawithhibernate.UdemyJpaWithHibernateApplication;
import com.benkinmat.database.udemyjpawithhibernate.entity.Passport;
import com.benkinmat.database.udemyjpawithhibernate.entity.Student;

@Repository
@Transactional
public class StudentJpaRepository {
	
	private static final Logger log = LoggerFactory.getLogger(UdemyJpaWithHibernateApplication.class);

	@PersistenceContext
	EntityManager entityManager;
	
	public Student findById(long id) {
		return entityManager.find(Student.class, id);
	}
	
	public void deleteById(Long id) {
		Student student = findById(id);
		entityManager.remove(student);
	}
	
	public void saveStudentWithPassport() {
		Passport passport = new Passport("D10001");
		entityManager.persist(passport);
		
		Student student = new Student("Tuan Anh");
		
		student.setPassport(passport);		
		entityManager.persist(student);
	}
	
	public void playWithEntityManager() {
		Student course1 = new Student("Learn new stuff 1");
		entityManager.persist(course1);
		Student course2 = new Student("Learn new stuff 2");
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

package com.benkinmat.database.udemyjpawithhibernate.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.benkinmat.database.udemyjpawithhibernate.UdemyJpaWithHibernateApplication;
import com.benkinmat.database.udemyjpawithhibernate.entity.Address;
import com.benkinmat.database.udemyjpawithhibernate.entity.Course;
import com.benkinmat.database.udemyjpawithhibernate.entity.Passport;
import com.benkinmat.database.udemyjpawithhibernate.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UdemyJpaWithHibernateApplication.class)
public class StudentRepositoryTests {

	private static final Logger log = LoggerFactory.getLogger(UdemyJpaWithHibernateApplication.class);
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	StudentJpaRepository studentJpaRepository;
	
	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		Student student = entityManager.find(Student.class, 1000L);
		log.info("Student: " + student);
		log.info("Passport " + student.getPassport());
	}
	
	@Test
	@Transactional
	public void retrieveStudentAndAssociatedPassport() {
		Passport passport = entityManager.find(Passport.class, 1000L);
		log.info("Passport: " + passport);
		log.info("Student " + passport.getStudent());
	}
	
	@Test
	@Transactional
	public void sameTest() {
		Student student = entityManager.find(Student.class, 1000L);
		Passport passport = student.getPassport();
		passport.setNumber("E1000");
		student.setName("Student 1 - Updated");
		log.info("Student: " + student + " Passport: " + passport);
	}
	
	@Test
	@Transactional
	public void retrieveStudentAndCour() {
		Student student = entityManager.find(Student.class, 1000L);
		log.info("Student id 1000L" + student);
		log.info("Course of student id 1000L " + student.getCourses());
	}
	
	@Test
	@Transactional
	public void setAddressDetails() {
		Student student = entityManager.find(Student.class, 1000L);
		student.setAddress(new Address("line 1", "line 2", "Ho Chi Minh city"));
		entityManager.flush();
		log.info("Student id 1000L " + student);
	}
	
}

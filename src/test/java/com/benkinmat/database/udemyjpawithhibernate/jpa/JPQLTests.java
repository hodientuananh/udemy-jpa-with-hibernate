package com.benkinmat.database.udemyjpawithhibernate.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.benkinmat.database.udemyjpawithhibernate.UdemyJpaWithHibernateApplication;
import com.benkinmat.database.udemyjpawithhibernate.entity.Course;
import com.benkinmat.database.udemyjpawithhibernate.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UdemyJpaWithHibernateApplication.class)
public class JPQLTests {

	private static final Logger log = LoggerFactory.getLogger(UdemyJpaWithHibernateApplication.class);
	
	@Autowired
	EntityManager entityManager;
	
	@Test
	public void selectAll() {
		List<Course>courses = entityManager.createNamedQuery("get_all_courses", Course.class).getResultList();
		log.info("courses: " + courses);
	}
	
	@Test
	public void selectAllWithWhere() {
		List<Course>courses = entityManager.createNamedQuery("get_learn_new_courses", Course.class).getResultList();
		log.info("courses: " + courses);
	}
	
	@Test
	public void selectCourseWithoutStudents() {
		TypedQuery<Course> query = entityManager.createQuery("select c from Course c where c.students is empty", Course.class);
		List<Course> courses = query.getResultList();
		log.info("Courses: " + courses);
	}
	
	@Test
	public void selectCourseAtLeast2Students() {
		TypedQuery<Course> query = entityManager.createQuery("select c from Course c where size(c.students) >= 2", Course.class);
		List<Course> courses = query.getResultList();
		log.info("Courses: " + courses);
	}
	
	@Test
	public void selectCourseOrderByStudents() {
		TypedQuery<Course> query = entityManager.createQuery("select c from Course c order by size(c.students) desc", Course.class);
		List<Course> courses = query.getResultList();
		log.info("Courses: " + courses);
	}
	
	@Test
	public void selectStudentsWithPassportsInCertainPattern() {
		TypedQuery<Student> query = entityManager.createQuery("select s from Student s where s.passport.number like '%1000%'", Student.class);
		List<Student> student = query.getResultList();
		log.info("Students: " + student);
	}
	
	@Test
	public void join() {
		Query query = entityManager.createQuery("select s, c from Course c JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		log.info("Result size: " + resultList.size());
		for (Object[] result : resultList) {
			log.info("Student: " + result[0] + " Course: " + result[1]);
		}
	}
	
	@Test
	public void leftJoin() {
		Query query = entityManager.createQuery("select s, c from Course c LEFT JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		log.info("Result size: " + resultList.size());
		for (Object[] result : resultList) {
			log.info("Student: " + result[0] + " Course: " + result[1]);
		}
	}
	
	@Test
	public void crossJoin() {
		Query query = entityManager.createQuery("select s, c from Course c, Student s");
		List<Object[]> resultList = query.getResultList();
		log.info("Result size: " + resultList.size());
		for (Object[] result : resultList) {
			log.info("Student: " + result[0] + " Course: " + result[1]);
		}
	}
}

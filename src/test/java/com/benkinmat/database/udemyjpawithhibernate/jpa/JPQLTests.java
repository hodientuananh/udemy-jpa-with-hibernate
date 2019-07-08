package com.benkinmat.database.udemyjpawithhibernate.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;

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
	
}

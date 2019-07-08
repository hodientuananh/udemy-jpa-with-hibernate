package com.benkinmat.database.udemyjpawithhibernate.jpa;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.benkinmat.database.udemyjpawithhibernate.UdemyJpaWithHibernateApplication;
import com.benkinmat.database.udemyjpawithhibernate.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UdemyJpaWithHibernateApplication.class)
public class CourseRepositoryTests {

	private static final Logger log = LoggerFactory.getLogger(UdemyJpaWithHibernateApplication.class);
	
	@Autowired
	CourseJpaRepository repository;
	
	@Test
	public void contextLoads() {
		Course course = repository.findById(1000L);
		assertEquals("Spring with Jpa v1" , course.getName());
	}

}

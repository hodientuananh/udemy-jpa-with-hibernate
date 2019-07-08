package com.benkinmat.database.udemyjpawithhibernate.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
public class CourseRepositoryTests {

	private static final Logger log = LoggerFactory.getLogger(UdemyJpaWithHibernateApplication.class);
	
	@Autowired
	CourseJpaRepository repository;
	
	@Test
	public void findbyId() {
		Course course = repository.findById(1000L);
		assertEquals("Spring with Jpa" , course.getName());
	}
	
	@Test
	@DirtiesContext
	public void deleteById() {
		repository.deleteById(1000L);
		assertNull(repository.findById(1000L));
	}
	
	@Test
	@DirtiesContext
	public void save() {
		Course course = repository.findById(1000L);
		assertEquals("Spring with Jpa" , course.getName());
		
		course.setName("Spring with Jpa - Updated");
		repository.save(course);
		
		Course updatedCourse = repository.findById(1000L);
		assertEquals("Spring with Jpa - Updated" , updatedCourse.getName());
	}

}

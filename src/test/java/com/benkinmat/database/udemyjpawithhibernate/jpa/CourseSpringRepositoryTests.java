package com.benkinmat.database.udemyjpawithhibernate.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.benkinmat.database.udemyjpawithhibernate.UdemyJpaWithHibernateApplication;
import com.benkinmat.database.udemyjpawithhibernate.entity.Course;
import com.benkinmat.database.udemyjpawithhibernate.entity.Review;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UdemyJpaWithHibernateApplication.class)
public class CourseSpringRepositoryTests {

	private static final Logger log = LoggerFactory.getLogger(UdemyJpaWithHibernateApplication.class);

	@Autowired
	CourseSpringRepository courseSpringRepository;

	@Test
	public void findbyId() {
		Optional<Course> course = courseSpringRepository.findById(1000L);
		assertTrue(course.isPresent());
	}
	
	@Test
	public void sortCourses() {
		Sort sort = new Sort(Direction.DESC, "name");
		log.info("Sorted Course: " + courseSpringRepository.findAll(sort));
	}
	
	@Test
	public void pagination() {
		PageRequest pageRequest = PageRequest.of(0, 3);
		Page<Course> firstPage = courseSpringRepository.findAll(pageRequest);
		log.info("First page " + firstPage.getContent());
		
		Pageable secondPageable = firstPage.nextPageable();
		Page<Course> secondPage = courseSpringRepository.findAll(secondPageable);
		log.info("Second page " + secondPage.getContent());
	}
	
	@Test
	public void findByName() {
		log.info("Find by name: " + courseSpringRepository.findByName("Spring with Jpa"));
	}
	
}

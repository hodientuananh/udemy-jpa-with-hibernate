package com.benkinmat.database.udemyjpawithhibernate.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
import com.benkinmat.database.udemyjpawithhibernate.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UdemyJpaWithHibernateApplication.class)
public class NativeQueryTests {

	private static final Logger log = LoggerFactory.getLogger(UdemyJpaWithHibernateApplication.class);
	
	@Autowired
	EntityManager entityManager;
	
	@Test
	public void selectAll() {
		Query query = entityManager.createNativeQuery("select * from Course where id = ?", Course.class);
		query.setParameter(1, 1000);
		List<Course>courses = query.getResultList();
		
		log.info("courses: " + courses);
	}
	
	@Test
	@Transactional
	public void updateLastUpdate() {
		Query query = entityManager.createNativeQuery("Update Course set last_updated_date = sysdate", Course.class);
		int noOfRowsUpdated = query.executeUpdate();
		
		log.info("row updated: " + noOfRowsUpdated);
	}
	
}

package com.benkinmat.database.udemyjpawithhibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.benkinmat.database.udemyjpawithhibernate.entity.Course;
import com.benkinmat.database.udemyjpawithhibernate.entity.FullTimeEmployee;
import com.benkinmat.database.udemyjpawithhibernate.entity.PartTimeEmployee;
import com.benkinmat.database.udemyjpawithhibernate.entity.Person;
import com.benkinmat.database.udemyjpawithhibernate.entity.Review;
import com.benkinmat.database.udemyjpawithhibernate.jdbc.PersonJdbcDao;
import com.benkinmat.database.udemyjpawithhibernate.jpa.CourseJpaRepository;
import com.benkinmat.database.udemyjpawithhibernate.jpa.CourseSpringRepository;
import com.benkinmat.database.udemyjpawithhibernate.jpa.EmployeeJpaRepository;
import com.benkinmat.database.udemyjpawithhibernate.jpa.PersonJpaRepository;
import com.benkinmat.database.udemyjpawithhibernate.jpa.StudentJpaRepository;

@SpringBootApplication
public class UdemyJpaWithHibernateApplication implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(UdemyJpaWithHibernateApplication.class);
	
//	@Autowired
//	PersonJdbcDao personJdbcDao;
	
//	@Autowired
//	PersonJpaRepository personJpaRepository;
//	
//	@Autowired
//	CourseJpaRepository courseJpaRepository;
//	
//	@Autowired
//	StudentJpaRepository studentJpaRepository;
//	
//	@Autowired
//	EmployeeJpaRepository employeeJpaRepository;
	
	@Autowired
	CourseSpringRepository courseSpringRepository;
	
	@Autowired
	Algorithm algorithm;

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(UdemyJpaWithHibernateApplication.class, args);
		String[] beans = applicationContext.getBeanDefinitionNames();
		for (String bean : beans) {
			log.info("Beans: " + bean.toString());
		}
	}

	@Override
	public void run(String... args) throws Exception {

//		log.info("All person: " + personJdbcDao.getAll());
//		log.info("Person with id = 1000" + personJdbcDao.getById(1000));
//		log.info("Delete person with id = 1000, row affected = " + personJdbcDao.deleteById(1000));
//		log.info("Insert person with id = 1004, row affected = " + personJdbcDao.insert(new Person(1004, "four", "Vietnam", new Date())));
//		log.info("Update person with id = 1002, row affected = " + personJdbcDao.update(new Person(1002, "two updated", "Vietnam", new Date())));
		
//		log.info("Person with id = 1000 " + personJpaRepository.findById(1000));
//		log.info("Insert person with id = 1004, row affected = " + personJpaRepository.insert(new Person("four", "Vietnam", new Date())));
//		log.info("Update person with id = 1002, row affected = " + personJpaRepository.update(new Person(1002, "two updated", "Vietnam", new Date())));
//		personJpaRepository.deleteById(1000);
//		log.info("All person: " + personJpaRepository.findAll());
		
//		log.info("Course with id = 1000 " + courseJpaRepository.findById(1000l));
//		log.info("Insert new course " + courseJpaRepository.save(new Course("Learn new stuff")));
//		courseJpaRepository.deleteById(1000L);
		
//		log.info("Play with entity manager ");
//		courseJpaRepository.playWithEntityManager();
		
//		studentJpaRepository.saveStudentWithPassport();
		
//		List<Review> reviews = new ArrayList<Review>();
//		reviews.add(new Review("Greate stuff", "5"));
//		reviews.add(new Review("Greate stuff Again", "5"));
//		courseJpaRepository.addReviewsForCourse();
//		courseJpaRepository.addReviewsForCourse(1000L, reviews );
		
//		studentJpaRepository.insertStudentAndCourse();
		
//		employeeJpaRepository.insert(new FullTimeEmployee("Full time 1", new BigDecimal(1000)));
//		employeeJpaRepository.insert(new PartTimeEmployee("Part time 1", new BigDecimal(50)));
//		log.info("all employees: " 
//				+ employeeJpaRepository.retrieveAllPartimeEmployees()
//				+ employeeJpaRepository.retrieveFullTimeEmployees());
		
		
//		algorithm.sort();
		
	}

}

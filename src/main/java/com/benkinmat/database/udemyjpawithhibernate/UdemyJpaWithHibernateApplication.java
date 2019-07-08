package com.benkinmat.database.udemyjpawithhibernate;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.benkinmat.database.udemyjpawithhibernate.entity.Person;
import com.benkinmat.database.udemyjpawithhibernate.jdbc.PersonJdbcDao;
import com.benkinmat.database.udemyjpawithhibernate.jpa.CourseJpaRepository;
import com.benkinmat.database.udemyjpawithhibernate.jpa.PersonJpaRepository;

@SpringBootApplication
public class UdemyJpaWithHibernateApplication implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(UdemyJpaWithHibernateApplication.class);

	
//	@Autowired
//	PersonJdbcDao personJdbcDao;
	
	@Autowired
	PersonJpaRepository personJpaRepository;
	
	@Autowired
	CourseJpaRepository courseJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(UdemyJpaWithHibernateApplication.class, args);
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
		
		log.info("Course with id = 1000 " + courseJpaRepository.findById(1000l));
		courseJpaRepository.deleteById(1000L);
	}

}

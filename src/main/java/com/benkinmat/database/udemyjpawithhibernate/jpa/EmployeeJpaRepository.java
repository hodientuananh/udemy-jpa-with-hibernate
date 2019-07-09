package com.benkinmat.database.udemyjpawithhibernate.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.benkinmat.database.udemyjpawithhibernate.UdemyJpaWithHibernateApplication;
import com.benkinmat.database.udemyjpawithhibernate.entity.Course;
import com.benkinmat.database.udemyjpawithhibernate.entity.Employee;
import com.benkinmat.database.udemyjpawithhibernate.entity.Review;

@Repository
@Transactional
public class EmployeeJpaRepository {
	
	private static final Logger log = LoggerFactory.getLogger(UdemyJpaWithHibernateApplication.class);

	@PersistenceContext
	EntityManager entityManager;
	
	public void insert(Employee employee) {
		entityManager.persist(employee);
	}
	
	public List<Employee> retrieveAllEmployees(){
		return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
	}
	
}
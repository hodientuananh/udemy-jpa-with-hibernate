package com.benkinmat.database.udemyjpawithhibernate;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.benkinmat.database.udemyjpawithhibernate.entity.Course;

public class GenericRepositoryImpl<T> extends SimpleJpaRepository<T, Long> implements GenericRepository<T>{
	
	private JpaEntityInformation<T, Serializable> entityInformation;
	  private final EntityManager entityManager;

	  public GenericRepositoryImpl(JpaEntityInformation<T, Serializable> entityInformation, EntityManager entityManager) {
	    super(entityInformation, entityManager);
	    this.entityInformation = entityInformation;
	    this.entityManager = entityManager;
	  }

	  @Override
	  @SuppressWarnings("unchecked")
	  public T findByUuid(Long uuid) {

	    Query query = entityManager.createQuery("from " + entityInformation.getEntityName() + " e where e.id = ?1")
	        .setParameter(1, uuid);

	    return (T) query.getSingleResult();
	  }

}

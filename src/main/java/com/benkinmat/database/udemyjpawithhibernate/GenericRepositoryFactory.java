package com.benkinmat.database.udemyjpawithhibernate;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;

public class GenericRepositoryFactory extends JpaRepositoryFactory {

	  private RepositoryMetadata metadata;

	/**
	   * Creates a new {@link org.springframework.data.jpa.repository.support.JpaRepositoryFactory}.
	   *
	   * @param entityManager must not be {@literal null}
	   */
	  public GenericRepositoryFactory(EntityManager entityManager) {
	    super(entityManager);
	  }

	  protected <T, ID extends Serializable> GenericRepository<T> getTargetRepository(RepositoryMetadata metadata, EntityManager entityManager) {
	    return new GenericRepositoryImpl<T>(getEntityInformation((Class<T>) metadata.getDomainType()), entityManager);
	  }
	  

	  @Override
	  protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
	    return GenericRepositoryImpl.class;
	  }
	}

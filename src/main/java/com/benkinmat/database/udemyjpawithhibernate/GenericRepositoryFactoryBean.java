package com.benkinmat.database.udemyjpawithhibernate;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class GenericRepositoryFactoryBean<T extends JpaRepository<S, ID>, S, ID extends Serializable>
		extends JpaRepositoryFactoryBean<T, S, ID> {

	public GenericRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
		super(repositoryInterface);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Returns a
	 * {@link org.springframework.data.repository.core.support.RepositoryFactorySupport}.
	 *
	 * @param entityManager
	 * @return
	 */
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		return new GenericRepositoryFactory(entityManager);
	}
}

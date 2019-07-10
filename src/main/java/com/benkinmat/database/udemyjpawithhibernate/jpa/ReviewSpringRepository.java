package com.benkinmat.database.udemyjpawithhibernate.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.benkinmat.database.udemyjpawithhibernate.entity.Course;
import com.benkinmat.database.udemyjpawithhibernate.entity.Review;

@RepositoryRestResource(path = "reviews")
public interface ReviewSpringRepository extends JpaRepository<Review, Long> {	
	
}

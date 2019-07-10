package com.benkinmat.database.udemyjpawithhibernate.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.benkinmat.database.udemyjpawithhibernate.entity.Course;

@RepositoryRestResource(path = "courses")
public interface CourseSpringRepository extends JpaRepository<Course, Long> {

	List<Course> findByName(String name);
	List<Course> findByNameAndId(String name, Long id);
	List<Course> countByName(String name);
	List<Course> findByNameOrderByIdDesc(String name);
	List<Course> deleteByName(String name);
	
	@Query(value = "select c from Course c where c.name like '%Learn new%'")
	List<Course> courseWithNameLike();
	
	@Query(value = "select * from Course c where c.name like '%Learn new%'", nativeQuery = true)
	List<Course> courseWithNameLikeUsingNativeQuery();
	
	@Query(name = "get_learn_new_courses")
	List<Course> courseWithNameLikeUsingNamedQuery();
	
}

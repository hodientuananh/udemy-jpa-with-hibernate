package com.benkinmat.database.udemyjpawithhibernate.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.benkinmat.database.udemyjpawithhibernate.UdemyJpaWithHibernateApplication;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "get_all_courses", 
				query = "select c from Course c"),
		@NamedQuery(name = "get_learn_new_courses", 
			query = "select c from Course c where c.name like '%Learn new%'")
})
@Cacheable
@SQLDelete(sql = "update course set is_deleted = true where id=?")
@Where(clause = "is_deleted = false")
public class Course {

	private static final Logger log = LoggerFactory.getLogger(Course.class);

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "course")
	private List<Review> reviews = new ArrayList<Review>();
	
	@ManyToMany(mappedBy = "courses")
	@JsonIgnore
	private List<Student> students = new ArrayList<Student>();
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	private boolean isDeleted;
	
	public Course(){
		
	}	

	public Course(String name) {
		this.setName(name);
	}
	
	public boolean isDeleted() {
		return isDeleted;
	}
	
	@PreRemove
	private void preRemove() {
		log.info("Pre remove: Set isDeleted = true");
		this.isDeleted = true;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}
	
	public void removeReview(Review review) {
		this.reviews.remove(review);
	}

	public List<Student> getStudents() {
		return students;
	}

	public void addStudents(Student student) {
		this.students.add(student);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
}

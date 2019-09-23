package com.benkinmat.database.udemyjpawithhibernate.jpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.benkinmat.database.udemyjpawithhibernate.entity.Course;
import com.benkinmat.database.udemyjpawithhibernate.service.CourseSpringJpaService;

@RunWith(MockitoJUnitRunner.class)
public class MockitoRepositoryTest {
	@Mock
	private CourseSpringRepository courseSpringRepository;

	@InjectMocks // auto inject helloRepository
	private CourseSpringJpaService courseSpringJpaService;

	@Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void saveCourseWithSpringJpaService() {
		Course course = new Course("Test");
		when(courseSpringRepository.save(any(Course.class))).thenReturn(course);
		Course savedCourse = courseSpringJpaService.saveCourse(course);
		assertThat(savedCourse.getName()).isNotNull();
	}
}

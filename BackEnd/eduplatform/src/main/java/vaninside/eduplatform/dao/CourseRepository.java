package vaninside.eduplatform.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import vaninside.eduplatform.entity.Course;
import vaninside.eduplatform.entity.User;

public interface CourseRepository extends JpaRepository<Course, Integer>{
	// findById �� �⺻���� ����.
}

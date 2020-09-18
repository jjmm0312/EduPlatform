package vaninside.eduplatform.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vaninside.eduplatform.entity.Course;
import vaninside.eduplatform.entity.User;

public interface CourseRepository extends JpaRepository<Course, Integer>{
	Course findById(int id);
	List<Course> findByTeacherId(int id);
}

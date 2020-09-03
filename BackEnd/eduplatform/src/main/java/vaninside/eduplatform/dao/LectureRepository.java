package vaninside.eduplatform.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vaninside.eduplatform.entity.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Integer>{
	List<Lecture> findByCourseId(int id);
}

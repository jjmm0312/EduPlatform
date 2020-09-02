package vaninside.eduplatform.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import vaninside.eduplatform.entity.Code;

public interface CodeRepository extends JpaRepository<Code, Integer>{
	Boolean existsByTeacher(String teacher);
	Boolean existsByStudent(String student);
	
	
}

package vaninside.eduplatform.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vaninside.eduplatform.entity.Register;

public interface RegisterRepository extends JpaRepository<Register, Integer>{
	Register findByCourseIdAndStudentId(int c_id, int s_id);
	List<Register> findByCourseId(int num);
	List<Register> findByStudentId(int num);
}

package vaninside.eduplatform.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import vaninside.eduplatform.entity.Academy;

public interface AcademyRepository extends JpaRepository<Academy, Integer> {
	Academy findById(int num);
}

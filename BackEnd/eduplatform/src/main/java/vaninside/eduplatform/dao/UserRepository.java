package vaninside.eduplatform.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vaninside.eduplatform.entity.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
}

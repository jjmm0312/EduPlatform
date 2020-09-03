package vaninside.eduplatform.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import vaninside.eduplatform.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice,Integer>{

}

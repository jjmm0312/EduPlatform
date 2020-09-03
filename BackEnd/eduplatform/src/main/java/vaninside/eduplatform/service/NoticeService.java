package vaninside.eduplatform.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import vaninside.eduplatform.dao.NoticeRepository;
import vaninside.eduplatform.entity.Notice;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeRepository noticeRepo;
	
	public List<Notice> getMainNoticeList() {
		return null;
		
	}
	
	public List<Notice> getAllNotice(){
		//List<Notice> result = new ArrayList<Notice>();
		
		return noticeRepo.findAll();
		
	}
	
	
}

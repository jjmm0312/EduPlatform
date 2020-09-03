package vaninside.eduplatform.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vaninside.eduplatform.dao.CourseRepository;
import vaninside.eduplatform.dao.LectureRepository;
import vaninside.eduplatform.dao.RegisterRepository;
import vaninside.eduplatform.entity.Course;
import vaninside.eduplatform.entity.Lecture;
import vaninside.eduplatform.entity.Register;
import vaninside.eduplatform.entity.User;
import vaninside.eduplatform.payload.CourseRequest;
import vaninside.eduplatform.payload.LectureRequest;
import vaninside.eduplatform.security.JwtAuthenticationFilter;
import vaninside.eduplatform.security.JwtTokenProvider;
import vaninside.eduplatform.security.UserPrincipal;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	LectureRepository lectureRepository;
	
	@Autowired
	RegisterRepository regiRepository;
	
	public void courseCreate(UserPrincipal user, CourseRequest courseRequest) {
		Course course = new Course(courseRequest.getTitle(), courseRequest.getDescription(), courseRequest.getPicture(), user.getUser());
        courseRepository.save(course);  
	}
	
	public void lectureCreate(LectureRequest lectureRequest) {
		Course course = courseRepository.findById(lectureRequest.getCourseId());
		Lecture lecture = new Lecture(lectureRequest.getTitle(), lectureRequest.getDescription(), lectureRequest.getVideo(), lectureRequest.getDocument(),course);
		lectureRepository.save(lecture);
	}
	
	public void register(UserPrincipal user, int num) {
		Register regi = new Register(courseRepository.findById(num), user.getUser());
		regiRepository.save(regi);
	}
	
	public void agree(int c_id, int s_id) {
		Register regi = regiRepository.findByCourseIdAndStudentId(c_id, s_id);
		if(regi.getAgree() == 1) {
			regi.setAgree(0);
		}else {
			regi.setAgree(1);
		}
		regiRepository.save(regi);
	}
}

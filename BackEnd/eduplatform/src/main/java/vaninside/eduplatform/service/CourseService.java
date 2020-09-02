package vaninside.eduplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vaninside.eduplatform.dao.CourseRepository;
import vaninside.eduplatform.entity.Course;
import vaninside.eduplatform.entity.User;
import vaninside.eduplatform.payload.CourseRequest;
import vaninside.eduplatform.security.JwtAuthenticationFilter;
import vaninside.eduplatform.security.JwtTokenProvider;
import vaninside.eduplatform.security.UserPrincipal;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	public void courseCreate(UserPrincipal user, CourseRequest courseRequest) {

		Course course = new Course(courseRequest.getTitle(), courseRequest.getDescription(), courseRequest.getPicture(), user.getUser());
        courseRepository.save(course);
        
	}
}

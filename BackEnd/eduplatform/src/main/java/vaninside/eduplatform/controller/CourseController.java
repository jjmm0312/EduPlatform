package vaninside.eduplatform.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import vaninside.eduplatform.dao.CourseRepository;
import vaninside.eduplatform.entity.Course;
import vaninside.eduplatform.entity.Lecture;
import vaninside.eduplatform.entity.User;
import vaninside.eduplatform.payload.CourseRequest;
import vaninside.eduplatform.payload.LoginRequest;
import vaninside.eduplatform.security.JwtAuthenticationFilter;
import vaninside.eduplatform.security.UserPrincipal;
import vaninside.eduplatform.service.CourseService;

// @Api 는 swagger api 문서를 위해서 쓰는 부분. 주소/swagger-ui.html 로 들어가면 확인 가능.
// @RestController 컨트롤러라고 지정
// @RequestMapping 요청 주소 매핑. 이 컨트롤러의 모든 api 주소는 /lecture로 시작. ex> /show 인경우 /lecture/show 주소임.
@Api(tags = {"2. Lecture"})
@RestController
@RequestMapping("/lecture")
public class CourseController {
	@Autowired
	CourseService service;
	
	@Autowired
	CourseRepository courseRepository;
	
	//@Autowired
	//LectureRepository lectureRepository;
	
	// ApiOperation은 API 문서를 위해서 쓰는 어노테이션
	// RequestMapping은 요청 url 과 메소드 설정
	// @PostMapping("/signup") 이런 방식으로도 작성 가능. 기능 동일.
	
	@ApiOperation(value = "모든 강좌 조회", notes = "현재 있는 모든 강좌를 조회한다.")
	@RequestMapping(value="/course-list", method=RequestMethod.GET)
	public List<Course> courseAll() {
		// 따로 별도의 Service에서 처리할 부분이 없으므로 여기서 바로 db 처리.
		// 만약에 있다면, 여기서 service.<메소드> 실행시키고
		// service 안의 메소드에서 db access를 하고 반환한다.
		return courseRepository.findAll();
	}
	
	@ApiOperation(value = "강좌 정보 조회", notes = "요청한 강좌 정보를 조회한다.")
	@RequestMapping(value="/course-info", method=RequestMethod.POST)
	public Optional<Course> courseInfo(int courseNum) {
		return courseRepository.findById(courseNum);
	}
	
	/*
	@ApiOperation(value = "강의 조회", notes = "요청한 강의 정보를 조회한다.")
	@RequestMapping(value="/lecture-info", method=RequestMethod.POST)
	public Optional<Lecture> lectureInfo(int lectureNum) {
		return lectureRepository.findById(lectureNum);
	}
	*/
	
	@ApiOperation(value = "강좌 등록", notes = "새로운 강좌를 등록한다.")
	@RequestMapping(value="/course-create", method=RequestMethod.POST)
	public void courseCreate(@ApiParam(value="강좌 정보", required=true) @AuthenticationPrincipal UserPrincipal user, @RequestBody CourseRequest courseRequest) {
		service.courseCreate(user, courseRequest);
	}
}

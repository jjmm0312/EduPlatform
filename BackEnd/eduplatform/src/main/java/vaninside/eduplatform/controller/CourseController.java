package vaninside.eduplatform.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import vaninside.eduplatform.dao.CourseRepository;
import vaninside.eduplatform.dao.LectureRepository;
import vaninside.eduplatform.dao.RegisterRepository;
import vaninside.eduplatform.entity.Course;
import vaninside.eduplatform.entity.Lecture;
import vaninside.eduplatform.entity.Register;
import vaninside.eduplatform.entity.User;
import vaninside.eduplatform.payload.CourseRequest;
import vaninside.eduplatform.payload.LectureRequest;
import vaninside.eduplatform.payload.LoginRequest;
import vaninside.eduplatform.security.JwtAuthenticationFilter;
import vaninside.eduplatform.security.UserPrincipal;
import vaninside.eduplatform.service.CourseService;

@Api(tags = {"2. Course"})
@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	CourseService service;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	LectureRepository lectureRepository;
	
	@Autowired
	RegisterRepository regiRepository;

	@ApiOperation(value = "강좌 조회", notes = "원하는 범위의 강좌를 조회합니다. size = ? & page = ? (0부터 시작) , sort 옵션도 있음.")
	@GetMapping("/course-list")
    public ResponseEntity retrievePosts(final Pageable pageable) {
        Page<Course> courses = courseRepository.findAll(pageable);
        return new ResponseEntity<>(courses,HttpStatus.OK);
    }
	
	@ApiOperation(value = "모든 강의 조회", notes = "강좌 안의 모든 강의를 조회합니다.")
	@RequestMapping(value="/lecture-list", method=RequestMethod.GET)
	public List<Lecture> lectureList(@ApiParam(value="강좌 번호", required=true) int num) {
		return lectureRepository.findByCourseId(num);
	}
	
	@ApiOperation(value = "강좌 정보 조회", notes = "요청한 강좌 정보를 조회한다.")
	@RequestMapping(value="/course-info", method=RequestMethod.GET)
	public Course courseInfo(@ApiParam(value="강좌 번호", required=true) int num) {
		return courseRepository.findById(num);
	}
	
	@ApiOperation(value = "강의 정보 조회", notes = "요청한 강의 정보를 조회한다.")
	@RequestMapping(value="/lecture-info", method=RequestMethod.GET)
	public Optional<Lecture> lectureInfo(@ApiParam(value="강의 번호", required=true) int num) {
		return lectureRepository.findById(num);
	}
	
	@ApiOperation(value = "강좌 등록", notes = "새로운 강좌를 등록한다. status 200 응답")
	@RequestMapping(value="/course-create", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void courseCreate(@ApiParam(value="강좌 정보", required=true) @AuthenticationPrincipal UserPrincipal user, @RequestBody CourseRequest courseRequest) {
		service.courseCreate(user, courseRequest);
	}

	@ApiOperation(value = "강의 등록", notes = "강의를 등록한다.")
	@RequestMapping(value="/lecture-create", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void lectureCreate(@ApiParam(value="강의 정보", required=true) @RequestBody LectureRequest lectureRequest) {
		service.lectureCreate(lectureRequest);
	}
	
	@ApiOperation(value = "내 강좌 조회", notes = "내 강좌를 조회한다.")
	@RequestMapping(value="/teacher/my-course", method=RequestMethod.GET)
	public List<Course> myCourse(@ApiParam(value="강사 번호", required=true) int num) {
		return courseRepository.findByTeacherId(num);
	}
	
	@ApiOperation(value = "수강 신청", notes = "수강 신청한다.")
	@RequestMapping(value="/register", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void register(@ApiParam(value="강의 번호", required=true) @AuthenticationPrincipal UserPrincipal user, int num) {
		service.register(user, num);
	}
	
	@ApiOperation(value = "수강 신청 승인 / 삭제", notes = "수강 신청 승인 및 삭제.")
	@RequestMapping(value="/agree", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void agree(@ApiParam(value="강의 번호", required=true) int c_id, int s_id) {
		service.agree(c_id, s_id);
	}
	
	@ApiOperation(value = "수강생 리스트", notes = "수강생 리스트")
	@RequestMapping(value="/student-list", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Register> studentList(@ApiParam(value="강좌 번호", required=true) int num) {
		return regiRepository.findByCourseId(num);
	}
	
	@ApiOperation(value = "학생용 내 강좌 조회", notes = "내 강좌를 조회한다.")
	@RequestMapping(value="/student/my-course", method=RequestMethod.GET)
	public List<Register> smyCourse(@ApiParam(value="학생 번호", required=true) int num) {
		return regiRepository.findByStudentId(num);
	}
}

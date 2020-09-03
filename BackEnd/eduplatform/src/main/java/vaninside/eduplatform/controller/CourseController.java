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

	@ApiOperation(value = "���� ��ȸ", notes = "���ϴ� ������ ���¸� ��ȸ�մϴ�. size = ? & page = ? (0���� ����) , sort �ɼǵ� ����.")
	@GetMapping("/course-list")
    public ResponseEntity retrievePosts(final Pageable pageable) {
        Page<Course> courses = courseRepository.findAll(pageable);
        return new ResponseEntity<>(courses,HttpStatus.OK);
    }
	
	@ApiOperation(value = "��� ���� ��ȸ", notes = "���� ���� ��� ���Ǹ� ��ȸ�մϴ�.")
	@RequestMapping(value="/lecture-list", method=RequestMethod.GET)
	public List<Lecture> lectureList(@ApiParam(value="���� ��ȣ", required=true) int num) {
		return lectureRepository.findByCourseId(num);
	}
	
	@ApiOperation(value = "���� ���� ��ȸ", notes = "��û�� ���� ������ ��ȸ�Ѵ�.")
	@RequestMapping(value="/course-info", method=RequestMethod.GET)
	public Course courseInfo(@ApiParam(value="���� ��ȣ", required=true) int num) {
		return courseRepository.findById(num);
	}
	
	@ApiOperation(value = "���� ���� ��ȸ", notes = "��û�� ���� ������ ��ȸ�Ѵ�.")
	@RequestMapping(value="/lecture-info", method=RequestMethod.GET)
	public Optional<Lecture> lectureInfo(@ApiParam(value="���� ��ȣ", required=true) int num) {
		return lectureRepository.findById(num);
	}
	
	@ApiOperation(value = "���� ���", notes = "���ο� ���¸� ����Ѵ�. status 200 ����")
	@RequestMapping(value="/course-create", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void courseCreate(@ApiParam(value="���� ����", required=true) @AuthenticationPrincipal UserPrincipal user, @RequestBody CourseRequest courseRequest) {
		service.courseCreate(user, courseRequest);
	}

	@ApiOperation(value = "���� ���", notes = "���Ǹ� ����Ѵ�.")
	@RequestMapping(value="/lecture-create", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void lectureCreate(@ApiParam(value="���� ����", required=true) @RequestBody LectureRequest lectureRequest) {
		service.lectureCreate(lectureRequest);
	}
	
	@ApiOperation(value = "�� ���� ��ȸ", notes = "�� ���¸� ��ȸ�Ѵ�.")
	@RequestMapping(value="/teacher/my-course", method=RequestMethod.GET)
	public List<Course> myCourse(@ApiParam(value="���� ��ȣ", required=true) int num) {
		return courseRepository.findByTeacherId(num);
	}
	
	@ApiOperation(value = "���� ��û", notes = "���� ��û�Ѵ�.")
	@RequestMapping(value="/register", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void register(@ApiParam(value="���� ��ȣ", required=true) @AuthenticationPrincipal UserPrincipal user, int num) {
		service.register(user, num);
	}
	
	@ApiOperation(value = "���� ��û ���� / ����", notes = "���� ��û ���� �� ����.")
	@RequestMapping(value="/agree", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void agree(@ApiParam(value="���� ��ȣ", required=true) int c_id, int s_id) {
		service.agree(c_id, s_id);
	}
	
	@ApiOperation(value = "������ ����Ʈ", notes = "������ ����Ʈ")
	@RequestMapping(value="/student-list", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Register> studentList(@ApiParam(value="���� ��ȣ", required=true) int num) {
		return regiRepository.findByCourseId(num);
	}
	
	@ApiOperation(value = "�л��� �� ���� ��ȸ", notes = "�� ���¸� ��ȸ�Ѵ�.")
	@RequestMapping(value="/student/my-course", method=RequestMethod.GET)
	public List<Register> smyCourse(@ApiParam(value="�л� ��ȣ", required=true) int num) {
		return regiRepository.findByStudentId(num);
	}
}

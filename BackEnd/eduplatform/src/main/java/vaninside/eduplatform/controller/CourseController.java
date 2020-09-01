package vaninside.eduplatform.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import vaninside.eduplatform.dao.CourseRepository;
import vaninside.eduplatform.entity.Course;

// @Api �� swagger api ������ ���ؼ� ���� �κ�. �ּ�/swagger-ui.html �� ���� Ȯ�� ����.
// @RestController ��Ʈ�ѷ���� ����
// @RequestMapping ��û �ּ� ����. �� ��Ʈ�ѷ��� ��� api �ּҴ� /lecture�� ����. ex> /show �ΰ�� /lecture/show �ּ���.
@Api(tags = {"2. Lecture"})
@RestController
@RequestMapping("/lecture")
public class CourseController {
	//@Autowired
	//CourseService service;
	
	@Autowired
	CourseRepository courseRepository;
	
	// ApiOperation�� API ������ ���ؼ� ���� ������̼�
	// RequestMapping�� ��û url �� �޼ҵ� ����
	// @PostMapping("/signup") �̷� ������ε� �ۼ� ����. ��� ����.
	
	@ApiOperation(value = "��� ���� ��ȸ", notes = "���� �ִ� ��� ���¸� ��ȸ�Ѵ�.")
	@RequestMapping(value="/course-list", method=RequestMethod.GET)
	public List<Course> courseAll() {
		// ���� ������ Service���� ó���� �κ��� �����Ƿ� ���⼭ �ٷ� db ó��.
		return courseRepository.findAll();
	}
	
	@ApiOperation(value = "���� ���� ��ȸ", notes = "��û�� ���� ������ ��ȸ�Ѵ�.")
	@RequestMapping(value="/course-info", method=RequestMethod.POST)
	public Optional<Course> courseInfo(int courseNum) {
		return courseRepository.findById(courseNum);
	}
	
	@ApiOperation(value = "���� ��ȸ", notes = "��û�� ���� ������ ��ȸ�Ѵ�.")
	@RequestMapping(value="/lecture-info", method=RequestMethod.POST)
	public ResponseEntity<?> lectureInfo(int lectureNum) {
		
		return null;
	}
}

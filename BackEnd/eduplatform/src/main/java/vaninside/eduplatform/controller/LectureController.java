package vaninside.eduplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// @Api �� swagger api ������ ���ؼ� ���� �κ�. �ּ�/swagger-ui.html �� ���� Ȯ�� ����.
// @RestController ��Ʈ�ѷ���� ����
// @RequestMapping ��û �ּ� ����. �� ��Ʈ�ѷ��� ��� api �ּҴ� /lecture�� ����. ex> /show �ΰ�� /lecture/show �ּ���.
@Api(tags = {"2. Lecture"})
@RestController
@RequestMapping("/lecture")
public class LectureController {
	//@Autowired
	//LectureService service;
	
	//@Autowired
	//LectureRepository lectureRepository;
	
	// ApiOperation�� API ������ ���ؼ� ���� ������̼�
	// RequestMapping�� ��û url �� �޼ҵ� ����
	// @PostMapping("/signup") �̷� ������ε� �ۼ� ����. ��� ����.
	
	@ApiOperation(value = "��� ���� ��ȸ", notes = "���� �ִ� ��� ���¸� ��ȸ�Ѵ�.")
	@RequestMapping(value="/lecture-list", method=RequestMethod.GET)
	public ResponseEntity<?> lectureAll() {
		
		return null;
	}
	
	@ApiOperation(value = "���� ���� ��ȸ", notes = "��û�� ���� ������ ��ȸ�Ѵ�.")
	@RequestMapping(value="/lecture-info", method=RequestMethod.POST)
	public ResponseEntity<?> lectureInfo() {
		
		return null;
	}
	
	@ApiOperation(value = "���� ��ȸ", notes = "��û�� ���� ������ ��ȸ�Ѵ�.")
	@RequestMapping(value="/class-info", method=RequestMethod.POST)
	public ResponseEntity<?> classInfo() {
		
		return null;
	}
}

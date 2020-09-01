package vaninside.eduplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// @Api 는 swagger api 문서를 위해서 쓰는 부분. 주소/swagger-ui.html 로 들어가면 확인 가능.
// @RestController 컨트롤러라고 지정
// @RequestMapping 요청 주소 매핑. 이 컨트롤러의 모든 api 주소는 /lecture로 시작. ex> /show 인경우 /lecture/show 주소임.
@Api(tags = {"2. Lecture"})
@RestController
@RequestMapping("/lecture")
public class LectureController {
	//@Autowired
	//LectureService service;
	
	//@Autowired
	//LectureRepository lectureRepository;
	
	// ApiOperation은 API 문서를 위해서 쓰는 어노테이션
	// RequestMapping은 요청 url 과 메소드 설정
	// @PostMapping("/signup") 이런 방식으로도 작성 가능. 기능 동일.
	
	@ApiOperation(value = "모든 강좌 조회", notes = "현재 있는 모든 강좌를 조회한다.")
	@RequestMapping(value="/lecture-list", method=RequestMethod.GET)
	public ResponseEntity<?> lectureAll() {
		
		return null;
	}
	
	@ApiOperation(value = "강좌 정보 조회", notes = "요청한 강좌 정보를 조회한다.")
	@RequestMapping(value="/lecture-info", method=RequestMethod.POST)
	public ResponseEntity<?> lectureInfo() {
		
		return null;
	}
	
	@ApiOperation(value = "강의 조회", notes = "요청한 강의 정보를 조회한다.")
	@RequestMapping(value="/class-info", method=RequestMethod.POST)
	public ResponseEntity<?> classInfo() {
		
		return null;
	}
}

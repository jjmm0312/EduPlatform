package vaninside.eduplatform.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags= {"3. Notice"})
@RestController
@RequestMapping("/notice")
public class NoticeController {
	
	// Service가 결국 Logic을 처리하기 위한 부분이고
	// Repository가 결국 데이터를 처리하기 위한 부분이고
	// Service가 필요할 경우, ( 예) Signup 등의 그런 처리에는 사용한다 )
	
	
	@ApiOperation(value = "공지사항 리스트 조회", notes = "공지사항 리스트 조회, 페이지네이션에 맞게, 설정해야함")
	@RequestMapping(value ="/noticeList",method=RequestMethod.GET)
	public String getNoticeAll() {
		return "Done";
	}
	
	@ApiOperation(value = "메인페이지 공지사항 리스트 조회",notes="공지사항 리스트 조회, 메인에서 쓸 수 있도록 5개만 가져옴")
	@RequestMapping(value = "/noticeMain",method=RequestMethod.GET)
	public String getNoticeMain() {
		return "Main Notice";
	}
	
}

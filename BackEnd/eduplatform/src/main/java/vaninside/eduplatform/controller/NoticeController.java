package vaninside.eduplatform.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import vaninside.eduplatform.dao.NoticeRepository;
import vaninside.eduplatform.entity.Notice;
import vaninside.eduplatform.service.NoticeService;

@Api(tags= {"3. Notice"})
@RestController
@RequestMapping("/notice")
public class NoticeController {
	
	// Service�� �ᱹ Logic�� ó���ϱ� ���� �κ��̰�
	// Repository�� �ᱹ �����͸� ó���ϱ� ���� �κ��̰�
	// Service�� �ʿ��� ���, ( ��) Signup ���� �׷� ó������ ����Ѵ� )
	
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private NoticeRepository noticeRepo;
//	@ApiOperation(value = "�������� ����Ʈ ��ȸ", notes = "�������� ����Ʈ ��ȸ, ���������̼ǿ� �°�, �����ؾ���")
//	@RequestMapping(value ="/noticeList",method=RequestMethod.GET)
//	public List<Notice> getNoticeAll() {
//		return noticeService.getAllNotice();
//		//return "Done";
//	}
	
	@ApiOperation(value = "�������� �� ��", notes="�������� �� �� ��ȸ�� API")
	@GetMapping("/noticeDetail")
	public Optional<Notice> getDetailNotice(@RequestParam Map<String, String> param) {
		return noticeRepo.findById(Integer.valueOf(param.get("noticeID")));
	}
	
	@ApiOperation(value = "�������� ����Ʈ ��ȸ", notes = "�������� ����Ʈ ��ȸ, ���������̼ǿ� �°�, �����ؾ���")
	@GetMapping("/noticeList")
	public ResponseEntity retrievePosts(final Pageable pageable) {
        Page<Notice> notices = noticeRepo.findAll(pageable);
        return new ResponseEntity<>(notices,HttpStatus.OK);
    }
	
	@ApiOperation(value = "�������� �� �ۼ� �� ����", notes="�������� �� �ۼ� �� ������ ���� API")
	@PostMapping("/newNotice")
	public ResponseEntity newNotice(@RequestBody Map<String,String> param) {
		System.out.println(param);
		System.out.println(param.get("title") + " " + param.get("content"));
		Notice thisNotice = new Notice(param.get("title"),param.get("content"));
		noticeRepo.save(thisNotice);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
}

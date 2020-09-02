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
	
	// Service�� �ᱹ Logic�� ó���ϱ� ���� �κ��̰�
	// Repository�� �ᱹ �����͸� ó���ϱ� ���� �κ��̰�
	// Service�� �ʿ��� ���, ( ��) Signup ���� �׷� ó������ ����Ѵ� )
	
	
	@ApiOperation(value = "�������� ����Ʈ ��ȸ", notes = "�������� ����Ʈ ��ȸ, ���������̼ǿ� �°�, �����ؾ���")
	@RequestMapping(value ="/noticeList",method=RequestMethod.GET)
	public String getNoticeAll() {
		return "Done";
	}
	
	@ApiOperation(value = "���������� �������� ����Ʈ ��ȸ",notes="�������� ����Ʈ ��ȸ, ���ο��� �� �� �ֵ��� 5���� ������")
	@RequestMapping(value = "/noticeMain",method=RequestMethod.GET)
	public String getNoticeMain() {
		return "Main Notice";
	}
	
}

package vaninside.eduplatform.controller;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

	//MemberService service;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public HashMap<String, Object> login(@RequestBody HashMap<String, Object> map){
		String id = (String) map.get("id");
		String pwd = (String) map.get("pwd");
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		//result = service.login();
		//map.put("status", result);
		
		return hashMap;
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public HashMap<String, Object> signup(@RequestBody HashMap<String, Object> map){
		String name = (String) map.get("name");
		String id = (String) map.get("id");
		String pwd = (String) map.get("pwd");
		String email = (String) map.get("email");
		String phone = (String) map.get("phone");
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		
		return hashMap;
	}
	
	@RequestMapping(value="/checkId", method=RequestMethod.GET)
	public HashMap<String, Object> checkId(@RequestParam(value = "id")String id){
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		//result = service.checkId();
		//map.put("status", result);
	
		return hashMap;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public HashMap<String, Object> edit(@RequestBody HashMap<String, Object> map){

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		return hashMap;
	}
	
	@RequestMapping(value="/findId", method=RequestMethod.POST)
	public void findId(@RequestBody HashMap<String, Object> map){
		
	}
	
	@RequestMapping(value="/findPwd", method=RequestMethod.POST)
	public void findPwd(@RequestBody HashMap<String, Object> map){
		
	}
}

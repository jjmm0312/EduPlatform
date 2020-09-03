package vaninside.eduplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import vaninside.eduplatform.dao.AcademyRepository;
import vaninside.eduplatform.dao.CodeRepository;
import vaninside.eduplatform.entity.Academy;
import vaninside.eduplatform.entity.Code;
import vaninside.eduplatform.payload.AcademyRequest;
import vaninside.eduplatform.service.ManageService;

@Api(tags = {"5. Manage"})
@RestController
@RequestMapping("/manage")
public class ManageController {
	
	@Autowired
	AcademyRepository academyRepository;
	
	@Autowired
	CodeRepository codeReopository;
	
	@Autowired
	ManageService manageService;
	
	@ApiOperation(value = "학원 정보 불러오기", notes = "학원 정보를 조회한다.")
	@GetMapping( "/academy-info" )
	public Academy academyInfo() {
		return academyRepository.findById(1);
	}
	
	@ApiOperation(value = "학원 정보 수정", notes = "학원 정보를 수정한다.")
	@PostMapping( "/academy-edit" )
	@ResponseStatus(HttpStatus.OK)
	public void academyEdit(@ApiParam(value="수정된 학원 정보", required=true) @RequestBody AcademyRequest academyRequest) {
		manageService.edit(academyRequest);
	}
	
	@ApiOperation(value = "코드 조회", notes = "학생 코드를 조회한다.")
	@GetMapping( "/code" )
	public Code getStudentCode() {
		return codeReopository.findById(1);
	}
	
	@ApiOperation(value = "강사 정보 조회", notes = "강사 정보를 조회한다.")
	@PostMapping( "/teacher-info" )
	public void teacherInfo() {
		//return codeReopository.findById(0);
	}
	
	@ApiOperation(value = "강사 정보 등록", notes = "강사 정보를 등록한다.")
	@PostMapping( "/teacher-create" )
	public void teacherCreate() {
		//return codeReopository.findById(0);
	}
	
	@ApiOperation(value = "강사 정보 삭제", notes = "강사 정보를 삭제한다.")
	@PostMapping( "/teacher-delete" )
	public void teacherDelte() {
		//return codeReopository.findById(0);
	}
	
	
	
}

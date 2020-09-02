package vaninside.eduplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import vaninside.eduplatform.service.FileService;

@Api(tags = {"4. File"})
@RestController
public class FileController {
	@Autowired
	FileService fileService;
	
	/*
	public String upload(
			@RequestParam("file") MultipartFile file) {
		String url = fileService.upload(file);
		return url;
	}
	*/
	
	@ApiOperation(value = "���� ���ε�", notes = "������ ���ε��Ѵ�.")
	@RequestMapping( "/upload" )
	public List<String> upload(@RequestParam("file") List<MultipartFile> files) throws Exception {
		return fileService.fileUpload(files);	
	}
	
	/*
	@ApiOperation(value = "���� �ٿ�ε�", notes = "������ �ٿ�ε��Ѵ�.")
	@RequestMapping( "/upload" )
	public List<String> download(@RequestPart List<MultipartFile> files) throws Exception {
		//return fileService.upload(files);	
	}
	*/
}

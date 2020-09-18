package vaninside.eduplatform.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	@ApiOperation(value = "���� ���ε�", notes = "������ ���ε��Ѵ�.")
	@PostMapping( "/upload" )
	public List<String> upload(@RequestParam("file") List<MultipartFile> files) throws Exception {
		return fileService.fileUpload(files);	
	}

	@ApiOperation(value = "���� �ٿ�ε�", notes = "������ �ٿ�ε��Ѵ�.")
	@PostMapping( "/download" )
	public ResponseEntity<Resource> download(@RequestParam String filepath) throws IOException {
		Path path = Paths.get(filepath);
		String contentType = Files.probeContentType(path);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, contentType);

		Resource resource = new InputStreamResource(Files.newInputStream(path));
		return new ResponseEntity<>(resource, headers, HttpStatus.OK);
	}
}

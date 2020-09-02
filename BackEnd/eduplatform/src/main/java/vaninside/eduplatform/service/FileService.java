package vaninside.eduplatform.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileService {
	
	private static final String SAVE_PATH = "/upload";
	private static final String PREFIX_URL = "/upload/";
	
	public List<String> fileUpload(List<MultipartFile> files) throws IllegalStateException, IOException {
		
		List<String> list = new ArrayList<>();
		
		for (MultipartFile file : files) {
		
			String originalfileName = file.getOriginalFilename();
			String extName
			= originalfileName.substring(originalfileName.lastIndexOf("."), originalfileName.length());
			String onlyname = originalfileName.substring(0, originalfileName.lastIndexOf('.'));
			
			SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMddmmss");
			Date curtime = new Date();
			String time1 = format1.format(curtime);	
			String fileName = onlyname +"_" + time1 + extName;
			System.out.println(fileName);
			
			File dest = new File("C:/Image/" + fileName);
			file.transferTo(dest);		
			
			list.add("C:/Image/" + fileName);
	
		}

		return list;
	}
		
		/*
		try {
			// 파일 정보
			String originFilename = multipartFile.getOriginalFilename();
			String extName
				= originFilename.substring(originFilename.lastIndexOf("."), originFilename.length());
			Long size = multipartFile.getSize();
			
			// 서버에서 저장 할 파일 이름
			String saveFileName = genSaveFileName(extName);
			
			System.out.println("originFilename : " + originFilename);
			System.out.println("extensionName : " + extName);
			System.out.println("size : " + size);
			System.out.println("saveFileName : " + saveFileName);
			
			writeFile(multipartFile, saveFileName);
			url = PREFIX_URL + saveFileName;
		}
		catch (IOException e) {
			// 원래라면 RuntimeException 을 상속받은 예외가 처리되어야 하지만
			// 편의상 RuntimeException을 던진다.
			// throw new FileUploadException();	
			throw new RuntimeException(e);
		}
		*/

		
	// 파일을 실제로 write 하는 메서드
	private boolean writeFile(MultipartFile multipartFile, String saveFileName) throws IOException{
		boolean result = false;

		byte[] data = multipartFile.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
		fos.write(data);
		fos.close();
		
		return result;
	}
}

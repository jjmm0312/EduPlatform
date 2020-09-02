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
	
	
}

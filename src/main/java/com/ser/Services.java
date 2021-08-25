package com.ser;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class Services {

	String path = "C:\\Users\\Utsav Rami\\Desktop\\Royal Technosoft\\Spring_Web_MVC_CRUD_JDBC\\src\\main\\webapp\\WEB-INF\\upload";
	public String fileUpload(MultipartFile file) {
		String filename = file.getOriginalFilename();
		File file2 = new File(path + "\\" + filename);
		try {
			byte[] b = file.getBytes();
			FileUtils.writeByteArrayToFile(file2, b);
			System.out.println(path+"\\"+filename);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filename;
		
	}
	
	
}

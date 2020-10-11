package com.springbootRestAPI.Helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
//	private final String Upload_Dir = "C:\\Users\\saddam husain\\Documents\\workspace-spring-tool-suite-4-4.8.0.RELEASE\\springbootRestAPI\\src\\main\\resources\\static\\image";
	private final String Upload_Dir = new ClassPathResource("/static/image").getFile().getAbsolutePath();
	
	
	public FileUploadHelper() throws IOException {
		super();
		
	}


	public boolean uploadFile(MultipartFile file) {
		
		boolean flag=false;
		try {
			//read requested file
			InputStream is = file.getInputStream();
			byte[] data=new byte[is.available()];
			is.read(data);
			
			//write requested file to local resource folder i.e. in static/image
			FileOutputStream fos=new FileOutputStream(Upload_Dir+File.separator+file.getOriginalFilename());
			fos.write(data);
			
			fos.close();
			fos.flush();
			flag=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
		
	}
}

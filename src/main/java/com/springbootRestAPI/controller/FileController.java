package com.springbootRestAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springbootRestAPI.Helper.FileUploadHelper;

@RestController
public class FileController {
	@Autowired
	private FileUploadHelper fileHelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getContentType());
		System.out.println(file.getSize());

		if (file.isEmpty() || !file.getContentType().equals("image/jpeg")) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("file must required and it should be jpeg type");
		}

		// upload to local directory
		try {
			boolean b = this.fileHelper.uploadFile(file);
			if (b) {
//				return ResponseEntity.ok("File uploaded successfully...");
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/")
						.path(file.getOriginalFilename()).toUriString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong, Try Again !!");

	}

}

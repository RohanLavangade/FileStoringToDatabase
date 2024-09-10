package com.fileupload.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class fileuploadcontroller {

	@PostMapping("/upload-file")
	public String saveFile(@RequestParam("") MultipartFile file) throws Exception {

		System.out.println(file.getOriginalFilename());
		System.out.println(file.getName());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());

		String Path_Directory = "C:\\Users\\DELL\\Downloads\\FileUploadToDataBase\\FileUploadToDataBase\\src\\main\\resources\\static\\files";
//		String pathDirectory = new ClassPathResource("static/images/").getFile().getAbsolutePath();
        File destinationFile = new File(Path_Directory + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
        Files.copy(file.getInputStream(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		return "File Saved Sucessfully";
	}
}

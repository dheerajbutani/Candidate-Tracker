package com.example.demo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileService {
	private static final String FILE_DIRECTORY = "D:/";
	 
//	public void storeFile(MultipartFile file) throws IOException {
//		Path filePath = Paths.get(FILE_DIRECTORY + "/" + file.getOriginalFilename());
// 
//		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//		
//		
//	}
	
	/** ------------------------ save the file -------------------------------- */
	public boolean storeFile(MultipartFile file,String fileName) {
	
		System.out.println(file.getOriginalFilename());
		File uploadedFile = new File(FILE_DIRECTORY+"/"+fileName);

		try {
			uploadedFile.createNewFile();
			FileOutputStream fileOutputStream = new FileOutputStream(uploadedFile);
			fileOutputStream.write(file.getBytes());
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public String fileCheck(String fileName) {
		Path path = Paths.get(FILE_DIRECTORY + "/" +fileName );
		boolean fileExists = Files.exists(path);
		if(fileExists) {
//			fileName.
			fileName=null;
		}
		return fileName;
//		System.out.println(Files.exists(path))
		
	}
	/** ---------------------------------------------------------------------------------------- */

//	/** retrieve file, loadfile for storing at interviewer side*/
//	public Resource loadFile(String fileName) {
//        Path path = Paths.get(FILE_DIRECTORY + "/"+fileName);
//        Resource resource = null;
// 
//        try {
//           resource = new UrlResource(path.toUri());
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//		return resource;
//	}
	
	/** ------------------------download file-------------------------------------------- */
	
	private enum ResourceType {
		FILE_SYSTEM,
	}
	
	public Resource getFileSystem(String filename, HttpServletResponse response) throws FileNotFoundException {
		return getResource(filename, response, ResourceType.FILE_SYSTEM);
	}
	
	private Resource getResource(String filename, HttpServletResponse response, ResourceType resourceType) throws FileNotFoundException {
		
		Path path = Paths.get(FILE_DIRECTORY + "/" +filename );
		System.out.println(Files.exists(path));
		Resource resource=null;
		if(Files.exists(path)==false)	return resource;
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=" + filename);
		response.setHeader("filename", filename);
		
		resource = new FileSystemResource(FILE_DIRECTORY + filename);
		
		return resource;
	}
	/**---------------------------------------------------------------------------------------*/
}

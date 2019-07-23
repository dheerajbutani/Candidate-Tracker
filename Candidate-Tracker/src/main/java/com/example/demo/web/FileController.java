package com.example.demo.web;

import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Candidate;
import com.example.demo.model.CandidateCv;
import com.example.demo.service.CandidateCvService;
import com.example.demo.service.CandidateService;
import com.example.demo.service.FileService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping
public class FileController {

	@Autowired
	private FileService fileService;

	@Autowired
	private CandidateCvService candidateCvService;

	
	@Autowired
	private CandidateService candidateService;
//	@PostMapping(value = "/uploadFile")
//	@ResponseStatus(HttpStatus.OK)
//	public void handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
//		String fileName = file.getOriginalFilename();
//		if (fileName.contains("pdf") || fileName.contains("PDF")) {
//			fileService.storeFile(file);
//			System.out.println("uploaded");
//		}
//	}

//	 method for uploading single file
	@PostMapping(value = "/uploadFile/{email}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file,@PathVariable String email) {
//		System.out.println(file.getOriginalFilename());
//		String fileName = file.getOriginalFilename();
CandidateCv cv=		candidateCvService.getCandidateCv(email);

	cv.setFileVersion(cv.getFileVersion()+1);
	candidateCvService.saveCandidateCv(cv.getCandidateId(), cv.getFirstName(),cv.getLastName(), cv.getFileVersion(), cv.getEmail());
System.out.println(email);
		String fileName = cv.getCandidateId()+"v"+cv.getFileVersion()+".pdf";
		if (fileName.endsWith(".pdf") || fileName.endsWith(".PDF")) {
			boolean canUpload = fileService.storeFile(file,fileName);
			if (canUpload)
				return new ResponseEntity<Object>("file Uplaoded succesfully", HttpStatus.OK);
			else
				return new ResponseEntity<Object>("can't upload file", HttpStatus.OK);
		}
		else
			return new ResponseEntity<Object>("Please Upload PDF file only", HttpStatus.OK);
	}
	
	
	//downloading file
	@GetMapping(value = "/downloadFile/{id}", produces = "application/pdf")
	@ResponseStatus(HttpStatus.OK)
	public Resource getFileFromFileSystem(@PathVariable int id, HttpServletResponse response) throws FileNotFoundException {
	Candidate candidate=	candidateService.getCandidate(id);
	CandidateCv cv=	candidateCvService.getCandidateCv(candidate.getEmail());
	
	String filename=cv.getCandidateId()+"v"+cv.getFileVersion()+".pdf";
		return fileService.getFileSystem(filename, response);
	}


	// method for downloading file
//	@GetMapping(value = "/downloadFile/{fileName:.+}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//	public ResponseEntity<Object> downloadFile(@PathVariable String fileName, HttpServletResponse response) {
//
//		Resource resource = fileService.loadFile(fileName);
//
//		if (resource.exists()) {
//			return ResponseEntity.ok()
//					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//					.body(resource);
//
//			// return new ResponseEntity<Object>(resource, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<Object>("File Not Found ", HttpStatus.OK);
//		}
//	}
}
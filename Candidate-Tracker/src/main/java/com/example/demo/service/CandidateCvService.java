package com.example.demo.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CandidateCv;
import com.example.demo.repository.CandidateCvRepository;

@Service
public class CandidateCvService {

	@Autowired
	private CandidateCvRepository candidateCvRepository;
	
public void saveCandidateCv(int candidateId,String firstName,String lastName,int fileVersion,String email) {
CandidateCv cv=new CandidateCv();
cv.setCandidateId(candidateId);
cv.setFileVersion(fileVersion);
cv.setFirstName(firstName);
cv.setLastName(lastName);
cv.setEmail(email);
candidateCvRepository.save(cv);
}	
	public CandidateCv getCandidateCv(String email) {
		List<CandidateCv>candidate_cvs =candidateCvRepository.findByEmail(email);
	
return	candidate_cvs.stream().max(Comparator.comparingInt(CandidateCv::getFileVersion)).get();
	
	
	}
}

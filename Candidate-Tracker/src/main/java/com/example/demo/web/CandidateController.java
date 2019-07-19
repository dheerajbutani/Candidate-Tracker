package com.example.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CandidateResponse;
import com.example.demo.model.Candidate;
import com.example.demo.model.UserManager;
import com.example.demo.repository.UserManagerRepository;
import com.example.demo.service.CandidateService;
import com.example.demo.service.UserAccountService;

@CrossOrigin("*")
@RestController
public class CandidateController {

	
	@Autowired
	private CandidateService candidateService;
	
	
	
	@RequestMapping(value = "/createcandidate",method=RequestMethod.POST)
	public void createCandidate(@RequestBody CandidateRequest candidateRequest) {
		
		System.out.println(candidateRequest.getCandidate()+""+ candidateRequest.getParentid());
		candidateService.createCandidate(candidateRequest.getCandidate(), candidateRequest.getParentid());
	}
	
	@RequestMapping(value="/getcandidates/{userId}",method = RequestMethod.GET)
	
	public @ResponseBody List<CandidateResponse> loadMyCandidates( @PathVariable int userId){
	
		System.out.println(userId);
		List<CandidateResponse>candidates=candidateService.loadMyCandidates(userId);
	
		System.out.println(candidates);
	return candidates;
	}	 
}

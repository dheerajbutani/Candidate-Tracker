package com.example.demo.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CandidateResponse;
import com.example.demo.model.Candidate;
import com.example.demo.service.CandidateCvService;
import com.example.demo.service.CandidateService;

@CrossOrigin(origins= {"*"})
@RestController
public class CandidateController {

	
	@Autowired
	private CandidateService candidateService;
	
	
	@Autowired
	private CandidateCvService candidateCvService;
	
	@RequestMapping(value = "/createcandidate",method=RequestMethod.POST)
	public void createCandidate(@RequestBody CandidateRequest candidateRequest) {
		
		System.out.println(candidateRequest.getCandidate()+""+ candidateRequest.getParentid());
		candidateService.createCandidate(candidateRequest.getCandidate(), candidateRequest.getParentid());
		Candidate candidate=candidateRequest.getCandidate();
		candidateCvService.saveCandidateCv(candidate.getId(), candidate.getFirstName(), candidate.getLastName(), 0,candidate.getEmail());
		
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/getcandidates/{userId}",method = RequestMethod.GET)
	
	public @ResponseBody List<CandidateResponse> loadMyCandidates( @PathVariable int userId){
	
		System.out.println(userId);
		List<CandidateResponse>candidates=candidateService.loadMyCandidates(userId);
	
		System.out.println(candidates);
	return candidates;
	}	
	
	@RequestMapping(value="/offer/{candidateId}",method=RequestMethod.PATCH)
	public void offer(@PathVariable int candidateId) {
		candidateService.offer(candidateId);
	}
	@RequestMapping(value="/reject/{candidateId}",method=RequestMethod.PATCH)
	public void reject(@PathVariable int candidateId) {
		candidateService.reject(candidateId);
	}
	@RequestMapping(value="/hold/{candidateId}",method=RequestMethod.PATCH)
	public void hold(@PathVariable  int candidateId) {
		candidateService.hold(candidateId);
	}
	
	@RequestMapping(value="/getstats/{userId}",method=RequestMethod.GET)
	public Map<String,Long> getStats(@PathVariable int userId){
		return candidateService.getStats(userId);
	}
	
	
	@RequestMapping(value="/updatecandidate",method=RequestMethod.PATCH)
	public void updateCandidate(@RequestBody Candidate candidate) {
		candidateService.updateCandidate(candidate);
	}
	
}

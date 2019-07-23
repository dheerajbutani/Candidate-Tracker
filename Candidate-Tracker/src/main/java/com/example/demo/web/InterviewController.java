package com.example.demo.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.InterviewsDisplay;
import com.example.demo.model.InterviewStatus;
import com.example.demo.service.InterviewService;
@CrossOrigin("*")
@RestController
public class InterviewController {
@Autowired
private InterviewService interviewService;

@RequestMapping(value="/addinterview",method=RequestMethod.POST)
public void addInterview(@RequestBody InterviewRequest interviewRequest) {
	System.out.println(interviewRequest);
	interviewService.addInterview(interviewRequest);
}

@RequestMapping(value="/getinterview/{interviewerid}",method=RequestMethod.GET)
public List<InterviewsDisplay> getInterview(@PathVariable int interviewerid) {
return	interviewService.getMyInterviews(interviewerid);
}
}

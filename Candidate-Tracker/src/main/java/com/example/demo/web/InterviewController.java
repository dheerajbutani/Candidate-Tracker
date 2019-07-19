package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Interview;
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

//@RequestMapping(value="/getinterview/",method=RequestMethod.GET)
//public void addInterview(@RequestBody Interview interview) {
//	interviewService.addInterview(interview);
//}
}

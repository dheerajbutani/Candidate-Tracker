package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	
	
	
	
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public void getMessage() {
		System.out.println("idbs");
	}
	
	
	
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	@ResponseBody
	public String doLogIn(@RequestBody LoginRequest request){
	System.out.println(request.toString());
	boolean b=loginService.checkUser(request.getEmail(), request.getPassword());
	return b?"Login Success":"Login failed";
	
	
	}
}
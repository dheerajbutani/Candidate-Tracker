package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.LoginService;

@CrossOrigin(origins="*")
@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	
	
	
	
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public void getMessage() {
		System.out.println("idbs");
	}
	
	
	
	
	@RequestMapping(value = "/login",method = RequestMethod.POST,produces="application/json")
	public String doLogIn(@RequestBody LoginRequest request){
	System.out.println(request.toString());
	boolean b=loginService.checkUser(request.getEmail(), request.getPassword());
	//return b?"Login Success":"Login failed";
	//return "{sfsf}";

	if(b)
	return "{\"value\":\"success\"}";
	else return "{\"value\":\"failure\"}";

	}
}
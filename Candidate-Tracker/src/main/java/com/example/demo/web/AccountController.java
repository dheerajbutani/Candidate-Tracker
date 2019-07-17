package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.LoginUser;
import com.example.demo.service.UserAccountService;



@Controller
public class AccountController {

	@Autowired 
	private UserAccountService useraccountservice;
	
	@RequestMapping(value="/createaccount",method=RequestMethod.POST)
	@ResponseBody
	public AccountRequest createAccount(@RequestBody AccountRequest accountrequest){
		
		useraccountservice.createUserAccount(accountrequest.getLoginuser(), accountrequest.getParentid().getParentid());
		return accountrequest;
		
	}
	@RequestMapping(value="/deactivateaccount",method=RequestMethod.PATCH)
	@ResponseBody
	public String deactivateAccount(@RequestBody DeactivateRequest deactivateRequest) {
		
		String message=useraccountservice.deactivateAccount(deactivateRequest.getEmail(),deactivateRequest.getParentId());
		return message;
	}
	
}

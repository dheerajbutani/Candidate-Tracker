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

import com.example.demo.model.AccountStatus;
import com.example.demo.model.LoginUser;
import com.example.demo.service.UserAccountService;



@CrossOrigin("*")
@RestController
public class AccountController {

	@Autowired 
	private UserAccountService useraccountservice;
	
	@RequestMapping(value="/checkavailability/{emailJson}",method=RequestMethod.GET)
	public boolean checkAvailability(@PathVariable String emailJson) {
		System.out.println(emailJson);
return useraccountservice.checkAvailability(emailJson);
	}
	
//	@RequestMapping(value="/checkavailability",method=RequestMethod.POST)
//	public boolean checkAvailability(@RequestBody  email) {
//		System.out.println(email);
//return useraccountservice.checkAvailability(email);
//	}
//	
	
	@RequestMapping(value="/createaccount",method=RequestMethod.POST)
	@ResponseBody
	public AccountRequest createAccount(@RequestBody AccountRequest accountrequest){
		accountrequest.getLoginuser().setAccountStatus(AccountStatus.ACTIVE);
		useraccountservice.createUserAccount(accountrequest.getLoginuser(), accountrequest.getParentid().getParentid());
		return accountrequest;
		
	}
	@RequestMapping(value="/deactivateaccount",method=RequestMethod.PATCH)
	@ResponseBody
	public String deactivateAccount(@RequestBody DeactivateRequest deactivateRequest) {
		
		String message=useraccountservice.deactivateAccount(deactivateRequest.getEmail(),deactivateRequest.getParentId());
		return message;
	}
	
	
	
	@RequestMapping(value="/getactiveinterviewers",method=RequestMethod.GET)
	@ResponseBody
	public List<LoginUser> getActiveInterviewers() {

		
	return	useraccountservice.getActiveInterviewers();
	}
	
}

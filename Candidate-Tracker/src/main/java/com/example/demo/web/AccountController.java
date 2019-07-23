package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AccountDetails;
import com.example.demo.model.AccountStatus;
import com.example.demo.model.LoginUser;
import com.example.demo.service.EmailService;
import com.example.demo.service.PasswordService;
import com.example.demo.service.UserAccountService;



@CrossOrigin("*")
@RestController
public class AccountController {

	@Autowired
	private PasswordService passwordService;
	
	@Autowired
	private EmailService emailService;
	
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
	public void createAccount(@RequestBody AccountRequest accountrequest){
		accountrequest.getLoginuser().setAccountStatus(AccountStatus.ACTIVE);	
		String password=passwordService.generatePassword();
		String email=accountrequest.getLoginuser().getEmail();
		String subject ="Candidate Tracker";
		System.out.println(subject+email+password);
		accountrequest.getLoginuser().setPassword(password);
		useraccountservice.createUserAccount(accountrequest.getLoginuser(), accountrequest.getParentid().getParentid());
		System.out.println(emailService.sendMail(password, email, subject)); 
				
		
		
		
		
	}
	@RequestMapping(value="/changeaccountstatus/{id}",method=RequestMethod.PATCH)
	@ResponseBody
	public void changeAccountStatus(@PathVariable int id) {
		
		useraccountservice.changeAccountStatus(id);
		
	}
	
	
	
	@RequestMapping(value="/getactiveinterviewers",method=RequestMethod.GET)
	@ResponseBody
	public List<LoginUser> getActiveInterviewers() {

		
	return	useraccountservice.getActiveInterviewers();
	}
	
	
	@RequestMapping(value="/updateaccount",method=RequestMethod.PATCH)
	public void updateAccount(@RequestBody UpdateAccountRequest updateAccountRequest) {
		useraccountservice.updateAccount(updateAccountRequest);
	}
	
	@RequestMapping(value="/getrecruiterdetails",method=RequestMethod.GET)
	public List<AccountDetails> getRecruiterDetails(){
	return	useraccountservice.getRecruiterDetails();
	}
	@RequestMapping(value="/getmyrecruiterdetails/{recruiterId}",method=RequestMethod.GET)
	public List<AccountDetails> getMyRecruiterDetails(@PathVariable int recruiterId){
	return	useraccountservice.getMyRecruiterDetails(recruiterId);
	}
	
	@RequestMapping(value="/assignmanager",method=RequestMethod.POST)
	public void assignManager(@RequestBody Manager manager){
	useraccountservice.assignManager(manager.getChildId(),manager.getParentId());
	}
	
	
	@RequestMapping(value="/getmysubordinates/{userid}",method=RequestMethod.GET)
	public List<AccountDetails> getMySubordinates(@PathVariable int userid) {
		return useraccountservice.getMySubordinates(userid);
	}
	
}

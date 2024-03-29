package com.example.demo.service;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.LoginUser;
import com.example.demo.repository.UserRepository;

@Service
public class LoginService {

	public LoginService() {
	}
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public boolean checkUser(String email,String password) {
        
	System.out.println(email);
		Optional<LoginUser> u=userRepository.findByMyEmail(email);
		System.out.println(u);


		
                if(u.isPresent())
                	if(u.get().getPassword().equals(password))
                		{
                		System.out.println("success");
                		return true;
                		
                		}
                System.out.println("fail");
               return false;		
		}
	
	
	
	}






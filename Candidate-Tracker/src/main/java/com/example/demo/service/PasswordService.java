package com.example.demo.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class PasswordService {
	public String generatePassword() {
		// TODO Auto-generated method stub
		String letters="QWERTYUIOPASDFGHJKLZXCVBNMmnbvcxzaqwsderfgtyhjuiklop";
		String digits = "0987612345";
		String specialChars = "!@#*$";
		String pwdChars = letters+digits+specialChars;
		Random rand = new Random();
		int low=8;
		int high=12;
		int result = rand.nextInt(high-low) + low;

		char[] generatedPassword = new char[result];

		for(int i=0;i<result;i++) {
		generatedPassword[i] = pwdChars.charAt(rand.nextInt(pwdChars.length()));
		}


		String password=String.valueOf(generatedPassword);
		System.out.println(generatedPassword);
		return password;


		}

	
}

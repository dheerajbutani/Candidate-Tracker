package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.AccountStatus;
import com.example.demo.model.LoginUser;
import com.example.demo.model.Role;
import com.example.demo.model.UserManager;
import com.example.demo.repository.UserManagerRepository;
import com.example.demo.repository.UserRepository;

@Service
public class UserAccountService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserManagerRepository userManagerRepository;

	
	@Transactional
	public boolean checkAvailability(String email) {

		      
   	Optional<LoginUser> u=userRepository.findByMyEmail(email);
//	System.out.println(u.get());

	
            if(u.isPresent())
            {
            		System.out.println("success");
            		return true;
            		
            		}
            System.out.println("fail");
           return false;		
	}
	
	
	@Transactional
	public void createUserAccount(LoginUser user, int parent_id) {

		Optional<LoginUser> u = userRepository.findById(parent_id);

		
		
		UserManager userManager = new UserManager();
		System.out.println(user);
		if (u.isPresent()) {
			userRepository.save(user);
			List<Optional<UserManager>> um = userManagerRepository.findByChildId(u.get().getId());

			if (!um.isEmpty()) {
				for (Optional<UserManager> um1 : um) {

					System.out.println(um1.get().getParentId());
					UserManager userm = new UserManager();
					userm.setChildId(user.getId());
					userm.setParentId(um1.get().getParentId());
					System.out.println(userm.toString());
					userManagerRepository.save(userm);
				}

			}
			userManager.setChildId(user.getId());
			userManager.setParentId(parent_id);
			System.out.println(userManager.toString());
			userManagerRepository.save(userManager);

			UserManager usermanager1=new UserManager();
			usermanager1.setChildId(user.getId());
			usermanager1.setParentId(user.getId());
			userManagerRepository.save(usermanager1);
		}

	}

	public String deactivateAccount(String email, int parentId) {

		System.out.println(parentId);
		if (userRepository.findById(parentId).get().getAccountStatus().toString().equals("ACTIVE")) {
			List<UserManager> userManagers = userManagerRepository.findByParentId(parentId);
			LoginUser user = userRepository.findByEmail(email);
			if (user != null) {
				boolean isParent = userManagers.stream().anyMatch((x) -> x.getChildId() == user.getId());
				if(isParent) {
				user.setAccountStatus(AccountStatus.INACTIVE);
				userRepository.save(user);

				return "Account deactivated";
			}
				else return "You are not allowed to do this operation";
			}
			return "User does not exist";

		}

		return "You are not an ACTIVE user";
	}
	
	

	public List<LoginUser> getActiveInterviewers(){
		List<LoginUser>interviewers= userRepository.findByRoleAndAccountStatus(Role.INTERVIEWER,AccountStatus.ACTIVE);
		System.out.println(interviewers);
		return interviewers;
	}

}

package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.AccountDetails;
import com.example.demo.model.AccountStatus;
import com.example.demo.model.LoginUser;
import com.example.demo.model.Role;
import com.example.demo.model.UserManager;
import com.example.demo.repository.UserManagerRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.web.UpdateAccountRequest;

@Service
public class UserAccountService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserManagerRepository userManagerRepository;

	@Transactional
	public boolean checkAvailability(String email) {

		Optional<LoginUser> u = userRepository.findByMyEmail(email);
//	System.out.println(u.get());

		if (u.isPresent()) {
			System.out.println("success");
			return true;

		}
		System.out.println("fail");
		return false;
	}

	public AccountDetails getMyAccountDetails(int id) {

		Optional<LoginUser> user1 = userRepository.findById(id);
		LoginUser user = user1.get();
		AccountDetails accountDetails = new AccountDetails(id, user.getEmail(), user.getRole(), user.getAccountStatus(),
				user.getCreationDate(), user.getFirstName(), user.getLastName(), user.getMobile());
		return accountDetails;
	}

	public List<AccountDetails> getRecruiterDetails() {

		List<AccountDetails> recruiters=new ArrayList<AccountDetails>();
		List<LoginUser> users = userRepository.findByRoleAndAccountStatus(Role.RECRUITER, AccountStatus.ACTIVE);

		for(LoginUser user:users) {
		AccountDetails accountDetails = new AccountDetails(user.getId(), user.getEmail(), user.getRole(), user.getAccountStatus(),
				user.getCreationDate(), user.getFirstName(), user.getLastName(), user.getMobile());
		recruiters.add(accountDetails);
		}
		return recruiters;
	}
	
	public List<AccountDetails> getMyRecruiterDetails(int recruiterId) {

		
		List<AccountDetails> recruiters=new ArrayList<AccountDetails>();
		List<LoginUser> users = userRepository.findByRoleAndAccountStatus(Role.RECRUITER, AccountStatus.ACTIVE);
		
		List<UserManager> childrens=userManagerRepository.findByParentId(recruiterId);
		List<UserManager> parents=userManagerRepository.findByChildId(recruiterId);

		List<Integer>childIds=childrens.stream()
				.map((x)->{
					return x.getChildId();
				}).collect(Collectors.toList());
		List<Integer>parentIds=parents.stream()
				.map((x)->{
					return x.getParentId();
				}).collect(Collectors.toList());
		System.out.println("child "+childIds);
		System.out.println("parent "+parentIds);		
		for(LoginUser user:users) {
	
			System.out.println("user"+user);
			
		if(!childIds.contains(user.getId())&&!parentIds.contains(user.getId()))	
		{
		AccountDetails accountDetails = new AccountDetails(user.getId(), user.getEmail(), user.getRole(), user.getAccountStatus(),
				user.getCreationDate(), user.getFirstName(), user.getLastName(), user.getMobile());
		recruiters.add(accountDetails);
		}
		}
		return recruiters;
	}	
	
	
	
	
	
	
	
	
	
	
	
public List<AccountDetails> getMySubordinates(int userId) {

		
		List<AccountDetails> subordinates=new ArrayList<AccountDetails>();
		Optional<LoginUser> curruser = userRepository.findById(userId);
		
		LoginUser cuser=curruser.get();
		List<LoginUser> users=userRepository.findAll();
		List<UserManager> childrens=userManagerRepository.findByParentId(userId);
	

		List<Integer>childIds=childrens.stream()
				.map((x)->{
					return x.getChildId();
				}).collect(Collectors.toList());

	for(LoginUser user:users) {

		if(childIds.contains(user.getId())&&user.getId()!=userId)	{
		AccountDetails accountDetails = new AccountDetails(user.getId(), user.getEmail(), user.getRole(), user.getAccountStatus(),
				user.getCreationDate(), user.getFirstName(), user.getLastName(), user.getMobile());
		subordinates.add(accountDetails);
		}
		}
		return subordinates;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Transactional
	public void assignManager(int childId,int parentId) {
		UserManager userManager=new UserManager();
		userManager.setChildId(childId);
		userManager.setParentId(parentId);
		userManagerRepository.save(userManager);
	}
	
	
	@Transactional
	public void createUserAccount(LoginUser user, int parent_id) {

		
		Optional<LoginUser> u = userRepository.findById(parent_id);
		user.setCreationDate(LocalDate.now());
		userRepository.save(user);
		UserManager userManager = new UserManager();
		System.out.println(user);
		
		if (u.isPresent()) {
			
			List<UserManager> um = userManagerRepository.findByChildId(u.get().getId());

			if (!um.isEmpty()) {
				for (UserManager um1 : um) {

					System.out.println(um1.getParentId());
					UserManager userm = new UserManager();
					userm.setChildId(userRepository.findByEmail(user.getEmail()).getId());
					userm.setParentId(um1.getParentId());
					System.out.println(userm.toString());
					userManagerRepository.save(userm);
				}

			}
	

		}

		UserManager usermanager1 = new UserManager();
		usermanager1.setChildId(userRepository.findByEmail(user.getEmail()).getId());
		usermanager1.setParentId(userRepository.findByEmail(user.getEmail()).getId());
		System.out.println(usermanager1);
		userManagerRepository.save(usermanager1);
	}

	@Transactional
	public void changeAccountStatus(int id) {
Optional<LoginUser> user=userRepository.findById(id);


if(user.get().getAccountStatus().equals(AccountStatus.ACTIVE)) {
	user.get().setAccountStatus(AccountStatus.INACTIVE);
	
}
else
	user.get().setAccountStatus(AccountStatus.ACTIVE);


//(user.get().getAccountStatus().equals(AccountStatus.ACTIVE))?user.get().setAccountStatus(AccountStatus.INACTIVE):user.get().setAccountStatus(AccountStatus.ACTIVE);
	}

	@Transactional
	public void updateAccount(UpdateAccountRequest updateAccountRequest) {
		Optional<LoginUser> user = userRepository.findById(updateAccountRequest.getId());
		user.get().setEmail(updateAccountRequest.getEmail());
		user.get().setFirstName(updateAccountRequest.getFirstName());
		user.get().setLastName(updateAccountRequest.getLastName());
		user.get().setMobile(updateAccountRequest.getMobile());
		System.out.println(user);
		userRepository.save(user.get());
	}

	public List<LoginUser> getActiveInterviewers() {
		List<LoginUser> interviewers = userRepository.findByRoleAndAccountStatus(Role.INTERVIEWER,
				AccountStatus.ACTIVE);
		System.out.println(interviewers);
		return interviewers;
	}

}

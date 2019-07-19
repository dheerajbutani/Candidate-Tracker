package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AccountStatus;
import com.example.demo.model.LoginUser;
import com.example.demo.model.Role;

@Repository
public interface UserRepository extends JpaRepository<LoginUser, Integer>{

	@Query("from LoginUser u where u.email=?1")
    Optional<LoginUser> findByMyEmail(String email);

	LoginUser findByEmail(String email);

//	@Query("select u.id,u.email,u.")
	List<LoginUser> findByRoleAndAccountStatus(Role interviewer, AccountStatus active);
	
	
}

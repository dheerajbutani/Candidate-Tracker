package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LoginUser;

@Repository
public interface UserRepository extends JpaRepository<LoginUser, Integer>{

	@Query("select u from LoginUser u where u.email=?1")
    Optional<LoginUser> findByMyEmail(String email);

	LoginUser findByEmail(String email);
	
	
}

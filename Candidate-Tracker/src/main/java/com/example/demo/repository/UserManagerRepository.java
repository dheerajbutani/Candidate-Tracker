package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserManager;

@Repository
public interface UserManagerRepository extends JpaRepository<UserManager, Integer>{

	List<UserManager> findByChildId(int i);

	List<UserManager> findByParentId(int id);

	
	
}

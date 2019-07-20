package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Interview;
import com.example.demo.model.InterviewStatus;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Integer>{



	List<Interview> findByInterviewerAndStatus(int interviewer_id, InterviewStatus pending);

	List<Interview> findAllByCandidateId(int id);

	List<Interview> findByInterviewerIdAndStatus(int interviewer_id, InterviewStatus interviewStatus);
	
}

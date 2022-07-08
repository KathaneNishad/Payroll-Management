package com.leave.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leave.entity.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Long>{
	
}

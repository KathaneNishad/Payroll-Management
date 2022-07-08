package com.leave.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leave.entity.LeaveMaster;

public interface LeaveMasterRepository extends JpaRepository<LeaveMaster, Long>{

}

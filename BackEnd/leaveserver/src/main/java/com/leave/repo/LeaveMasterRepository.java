package com.leave.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.leave.entity.LeaveMaster;

public interface LeaveMasterRepository extends JpaRepository<LeaveMaster, Long>{
	@Query(value="select basic from payrollmaster where designation=:n",nativeQuery = true)
	public String getBasicByDesignation(@Param("n") String designation);
	
}

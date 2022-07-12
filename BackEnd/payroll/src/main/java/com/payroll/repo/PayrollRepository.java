package com.payroll.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.payroll.entity.Payroll;


public interface PayrollRepository extends JpaRepository<Payroll,Long>{
//	public Payroll findByUserId(Long user_id);
	
	@Query(value="select * from tbl_payroll where user_id=:u",nativeQuery = true)
	public Payroll findByUserId(@Param("u") Long user_id);
	
	@Transactional
	@Modifying
	@Query(value="update prog.tbl_payroll pt set payrollmaster_id=:d where user_id=:u",nativeQuery = true)
	public void setDesgignationInPayroll(@Param("u") Long user_id,@Param("d")Long pm); 

}

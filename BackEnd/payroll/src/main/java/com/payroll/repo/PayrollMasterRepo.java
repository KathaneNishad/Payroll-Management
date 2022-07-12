package com.payroll.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.payroll.entity.Payroll;
import com.payroll.entity.PayrollMaster;


public interface PayrollMasterRepo extends JpaRepository<PayrollMaster,Long>{
	public PayrollMaster findByDesignation(String Designation);
	
	@Query(value="select basic from payrollmaster where designation=:n",nativeQuery = true )
	public String getBasicByDesignation(@Param("n") String designation);
	
	@Query(value="select deduce_per_leave from payrollmaster where designation=:n",nativeQuery = true )
	public String getDeductionByDesignation(@Param("n") String designation);
	
	@Query(value="select pid from payrollmaster where designation=:d",nativeQuery = true)
	public Long getPayrollIdFromMaster(@Param("d")String designation);
	
	
	//to update basic in payroll table from payrollmaster using foriegn key
	@Transactional
	@Modifying
	@Query(value="update prog.tbl_payroll tp inner join prog.payrollmaster pm on tp.payrollmaster_id = pm.pid set tp.basic = pm.basic",nativeQuery = true)
	public  void updatePayrollBasicFromPayMaster();
	
	//to update basic in payroll table from payrollmaster using foriegn key
	@Transactional
	@Modifying
	@Query(value="update prog.tbl_payroll tp inner join prog.payrollmaster pm on tp.payrollmaster_id = pm.pid set tp.deduction = pm.deduce_per_leave",nativeQuery = true)
	public  void updatePayrollDeductionFromPayMaster();

}

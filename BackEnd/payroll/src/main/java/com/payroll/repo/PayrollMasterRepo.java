package com.payroll.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payroll.entity.PayrollMaster;

public interface PayrollMasterRepo extends JpaRepository<PayrollMaster,Long>{
	public PayrollMaster findByDesignation(String Designation);

}

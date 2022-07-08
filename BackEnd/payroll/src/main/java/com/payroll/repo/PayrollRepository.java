package com.payroll.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payroll.entity.Payroll;


public interface PayrollRepository extends JpaRepository<Payroll,Long>{
//	public Payroll findByUserId(Long user_id);

}

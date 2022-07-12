package com.payroll.service;

import java.util.List;

import com.payroll.entity.Payroll;

public interface PayrollService {
	//generate payroll
		public Payroll createPayroll(Payroll payroll) throws Exception;
		//view all Payroll records
		public List<Payroll> getAllPayrollRecords();
		//get payroll for particular user_id
		public Payroll getPayrollByUserId(Long user_id);
		//fetch no of leaves from Leave_Service
		//public PayrollLeaveMapper fetchNoofLeaves(Long user_id);
		
		//get basic from payroll master
		public String getBasicByDesignation(String designation);

}

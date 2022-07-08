package com.payroll.service;

import java.util.List;


import com.payroll.entity.PayrollMaster;

public interface MasterService {
	
	//generate payroll
	public PayrollMaster createPayroll(PayrollMaster pm);
	//view all Payroll records
	public List<PayrollMaster> getAllPayrollRecords();
	//get payroll for particular user_id
	//public PayrollMaster getPayrollByUserId(Long user_id);
	//update payroll information
	public PayrollMaster updatePayroll(Long id, PayrollMaster payroll);
	
	public PayrollMaster getPayrollByDesignation(String designation);
	
	

}

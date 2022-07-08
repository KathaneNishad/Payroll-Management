package com.payroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payroll.entity.PayrollMaster;
import com.payroll.service.MasterService;

import java.util.List;
@RestController
@RequestMapping("/PayrollMaster")
public class PayrollMasterController {
	
	@Autowired
	MasterService masterService;
	
	//create payroll
	@PostMapping("/create")
	public PayrollMaster generatePayroll(@RequestBody PayrollMaster payrollMaster) {
		return this.masterService.createPayroll(payrollMaster);
	}
	
	@GetMapping("/viewAll")
	public List<PayrollMaster> viewAllRecords()
	{
		return this.masterService.getAllPayrollRecords();
	}
	
	@GetMapping("/viewByDesig/{designation}")
	public PayrollMaster viewPayrollByDesignation(@PathVariable ("designation") String designation) {
	
	return this.masterService.getPayrollByDesignation(designation);
			
		
	}
	@PutMapping("/update")
	public PayrollMaster updatePayroll(@RequestBody PayrollMaster payrollMaster) {
		return this.masterService.updatePayroll(payrollMaster.getPid(), payrollMaster);
	}
	

}

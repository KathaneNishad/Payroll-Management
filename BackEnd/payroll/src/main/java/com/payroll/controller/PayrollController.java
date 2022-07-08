package com.payroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payroll.entity.Payroll;
import com.payroll.service.PayrollService;

@RestController
@RequestMapping("/Payroll")
public class PayrollController {
	@Autowired
	PayrollService payrollService;
	
	//create payroll
	@PostMapping("/create")
	public Payroll generatePayroll(@RequestBody Payroll payroll) {
		return this.payrollService.createPayroll(payroll);
	}
	
	@GetMapping("/viewAll")
	public List<Payroll> viewAllRecords()
	{
		return this.payrollService.getAllPayrollRecords();
	}
	
	@GetMapping("/viewById/{user_id}")
	public Payroll viewPayrollById(@PathVariable ("user_id") Long user_id) {
		return this.payrollService.getPayrollByUserId(user_id);
		
	}
	
	

}

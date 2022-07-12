package com.payroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.payroll.entity.Payroll;
import com.payroll.repo.PayrollRepository;
import com.payroll.service.PayrollService;

@RestController
@RequestMapping("/Payroll")
@CrossOrigin(origins ="http://localhost:4402",allowedHeaders ="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class PayrollController {
	
	@Autowired
	PayrollService payrollService;
	
	@Autowired
	PayrollRepository payrollRepository;
	
	//create payroll
	@PostMapping("/create")
	public Payroll generatePayroll(@RequestBody Payroll payroll) throws Exception {
		//this.payrollRepository.setDesgignationInPayroll(payroll.getUser_id(),1L);
		return payrollService.createPayroll(payroll);
	}
	
	
	
	@GetMapping("/viewAll")
	public List<Payroll> viewAllRecords()
	{
		return payrollService.getAllPayrollRecords();
	}
	
	
	@GetMapping("/viewById/{user_id}") 
	public Payroll viewPayrollById(@PathVariable ("user_id") Long user_id) {		  
		return payrollService.getPayrollByUserId(user_id);	  
	}
}

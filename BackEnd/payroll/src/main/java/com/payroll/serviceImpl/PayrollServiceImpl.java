package com.payroll.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.payroll.entity.Payroll;
import com.payroll.entity.PayrollMaster;
import com.payroll.helper.PayrollFoundException;
import com.payroll.repo.PayrollMasterRepo;
import com.payroll.repo.PayrollRepository;
import com.payroll.service.PayrollService;

@Service
public class PayrollServiceImpl implements PayrollService {
	
	@Autowired 
	PayrollRepository repo;
	
	@Autowired 
	PayrollMasterRepo masterRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Payroll createPayroll(Payroll payroll) throws Exception{
		//System.out.println("Payroll created");
		
		Payroll pay = this.repo.findByUserId(payroll.getUser_id());
		if(pay!=null) {
			System.out.println("Payroll for this User ID: "+payroll.getUser_id()+" already exists");
			throw new PayrollFoundException();
		}
		else {
			//generate payroll
			pay = payroll;
			//System.out.println("Here --> "+payroll.getDesignation());
			//System.out.println("Here --> "+pay.getDesignation());
			pay.setDeduction(masterRepo.getDeductionByDesignation(payroll.getDesignation()));
			pay.setBasic(masterRepo.getBasicByDesignation(payroll.getDesignation()));
			
			//get leaves from leave module
			int leaves_taken =
					  this.restTemplate.getForObject("http://localhost:8081/leave/leave-count-thismonth/"+
							  payroll.getUser_id(),int.class);
			pay.setLeavesTaken(leaves_taken);
			
			System.out.println(masterRepo.getPayrollIdFromMaster(payroll.getDesignation()));
			pay = this.repo.save(payroll);
			repo.setDesgignationInPayroll(payroll.getUser_id(),masterRepo.getPayrollIdFromMaster(payroll.getDesignation()));
		}
		
		return pay;
	}
	
	@Override
	public Payroll updatePayroll(Long pid) {
		Payroll pay = this.repo.findById(pid).get();
		int leaves_taken =
				  this.restTemplate.getForObject("http://localhost:8081/leave/leave-count-thismonth/"+
						  pay.getUser_id(),int.class);
		pay.setLeavesTaken(leaves_taken);
		pay = this.repo.save(pay);
		
		return pay;
	}
	
	

	@Override
	public List<Payroll> getAllPayrollRecords() {
		System.out.println("All records"+this.repo.findAll());
		return this.repo.findAll();
	}

	@Override
	public Payroll getPayrollByUserId(Long user_id) {
		System.out.println("User id "+user_id);
		//Payroll payroll = this.repo.findById(user_id).get();
		Payroll payroll = this.repo.findByUserId(user_id);
		
		return payroll;
	}

	@Override
	public String getBasicByDesignation(String Designation) {
		// TODO Auto-generated method stub
		PayrollMaster pm=this.masterRepo.findByDesignation(Designation);
		
		String basic=pm.getBasic();
		return basic;
	}


	

}

package com.payroll.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payroll.entity.Payroll;
import com.payroll.entity.PayrollMaster;
import com.payroll.repo.PayrollMasterRepo;
import com.payroll.repo.PayrollRepository;
import com.payroll.service.PayrollService;

@Service
public class PayrollServiceImpl implements PayrollService {
	
	@Autowired 
	PayrollRepository repo;
	
	@Autowired 
	PayrollMasterRepo masterRepo;
	
	@Override
	public Payroll createPayroll(Payroll payroll) {
		System.out.println("Payroll created");
		return this.repo.save(payroll);
	}

	@Override
	public List<Payroll> getAllPayrollRecords() {
		System.out.println("All records"+this.repo.findAll());
		return this.repo.findAll();
	}

	@Override
	public Payroll getPayrollByUserId(Long user_id) {
		System.out.println("User id"+user_id);
		Payroll payroll = this.repo.findById(user_id).get();
		
		return payroll;
	}

	@Override
	public String getBasicByDesignation(String Designation) {
		// TODO Auto-generated method stub
		PayrollMaster pm=this.masterRepo.findByDesignation(Designation);
		
		String basic=pm.getBasic();
		return basic;
	}

//	@Override
//	public PayrollLeaveMapper fetchNoofLeaves(Long user_id) {
//		
//		PayrollLeaveMapper plm=new PayrollLeaveMapper();
//		Payroll payroll=repo.findById(user_id).get();
//		Leave leave =restTemplate.getForObject("http://localhost:8081/leave/view-leave/"+payroll.getUser_id(), Leave.class);
//		
//		return null;
//	}

	

}

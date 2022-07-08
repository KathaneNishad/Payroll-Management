package com.payroll.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.payroll.entity.PayrollMaster;
import com.payroll.repo.PayrollMasterRepo;
import com.payroll.service.MasterService;

@Service
public class MasterServiceImpl implements MasterService{

	@Autowired
	private PayrollMasterRepo masterRepository;

	@Override
	public PayrollMaster createPayroll(PayrollMaster pm) {
		
		System.out.println("PayrollMaster created");
		return this.masterRepository.save(pm);
	}

	@Override
	public List<PayrollMaster> getAllPayrollRecords() {
		System.out.println(this.masterRepository.findAll());
		return this.masterRepository.findAll();
	}

	@Override
	public PayrollMaster getPayrollByDesignation(String designation) {
		PayrollMaster payrollMaster = this.masterRepository.findByDesignation(designation);
		
		return payrollMaster;
	}

	@Override
	public PayrollMaster updatePayroll(Long id, PayrollMaster payroll) {
		PayrollMaster record=this.masterRepository.findById(id).get();
		record.setBasic(payroll.getBasic());
		
		return this.masterRepository.save(record);
		
		
		
	}

}

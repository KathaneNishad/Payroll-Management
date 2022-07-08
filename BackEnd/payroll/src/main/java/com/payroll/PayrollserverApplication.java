package com.payroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.payroll.entity.Payroll;
import com.payroll.entity.PayrollMaster;
import com.payroll.service.MasterService;



@SpringBootApplication
public class PayrollserverApplication implements CommandLineRunner{
	
	/*
	 * @Autowired private MasterService masterService;
	 * 
	 * @Autowired private PayrollMaster payrollMaster;
	 */

	public static void main(String[] args) {
		SpringApplication.run(PayrollserverApplication.class, args);
		System.out.println("Payroll Working Fine");
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting Code");
		
		/*
		 * PayrollMaster master= new PayrollMaster();
		 * 
		 * master.setPid(3L); master.setDesignation("Architect");
		 * master.setBasic("55000"); master.setDeducePerLeave("750");
		 * 
		 * PayrollMaster master1 = this.masterService.createPayroll(master);
		 */
		
		/*
		 * Payroll pay= new Payroll();
		 * 
		 * pay.setDesignation("Architect"); pay.setLeavesTaken(5); pay.setUser_id(39L);
		 * pay.setPayrollMaster(payrollMaster.ge);
		 */
		
		
		
	}


	
}


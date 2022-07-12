package com.payroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.payroll.entity.Payroll;
import com.payroll.entity.PayrollMaster;
import com.payroll.repo.PayrollMasterRepo;
import com.payroll.repo.PayrollRepository;
import com.payroll.service.MasterService;
import com.payroll.service.PayrollService;



@SpringBootApplication
public class PayrollserverApplication implements CommandLineRunner{
	
//	@Autowired private PayrollMasterRepo payrollMasterRepo;
	
	//@Autowired private PayrollRepository payrollRepository;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	  //@Autowired private PayrollService payrollServicel;
	 
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
		 * pay.setDesignation("Tester"); pay.setUser_id(29L);
		 * pay.setBasic(payrollMasterRepo.getBasicByDesignation("Tester"));
		 * 
		 * payrollServicel.createPayroll(pay);
		 */
		 
		  
		  
		/*
		 * String b = payrollMasterRepo.getBasicByDesignation("Developer");
		 * 
		 * System.out.println("Here="+b);
		 */
		//this.payrollRepository.setDesgignationInPayroll(85L,1L);
		
		
		//System.out.println((payrollMasterRepo.getPayrollIdFromMaster("Tester")).getClass());
		
		
	}


	
}


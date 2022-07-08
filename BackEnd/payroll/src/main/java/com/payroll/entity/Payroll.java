package com.payroll.entity;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.Query;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;

@Entity
@Table(name="tbl_payroll")
public class Payroll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pay_id;
	
	@Column
	private Long user_id;//This should be unique
	private String designation;
	
	
	private String basic;//Gotta fetch from Payroll Master
	private int leavesTaken;
	private String deduction;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="payrollmaster_id")
	private PayrollMaster payrollMaster;
	
	
	public Payroll() {
		super();
	}


	public Payroll(Long pay_id, Long user_id, String designation, String basic, int leavesTaken, String deduction) {
		super();
		this.pay_id = pay_id;
		this.user_id = user_id;
		this.designation = designation;
		this.basic = basic;
		this.leavesTaken = leavesTaken;
		this.deduction = deduction;
	}


	public Long getPay_id() {
		return pay_id;
	}


	public void setPay_id(Long pay_id) {
		this.pay_id = pay_id;
	}


	public Long getUser_id() {
		return user_id;
	}


	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getBasic() {
		return basic;
	}

	//@Query("select pm.basic from payrollmaster pm join payroll p on p.payrollmaster_id=pm.pid where p.designation==pm.designation")
	public void setBasic(String basic) {
		this.basic = basic;
	}


	public int getLeavesTaken() {
		return leavesTaken;
	}


	public void setLeavesTaken(int leavesTaken) {
		this.leavesTaken = leavesTaken;
	}


	public String getDeduction() {
		return deduction;
	}


	public void setDeduction(String deduction) {
		this.deduction = deduction;
	}


	public PayrollMaster getPayrollMaster() {
		return payrollMaster;
	}


	public void setPayrollMaster(PayrollMaster payrollMaster) {
		this.payrollMaster = payrollMaster;
	}
	
	

	
	
	
	

}

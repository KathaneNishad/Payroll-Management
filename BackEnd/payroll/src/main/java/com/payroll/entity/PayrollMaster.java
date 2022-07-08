package com.payroll.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="payrollmaster")
public class PayrollMaster {
	
	
	@Id
	private Long pid;
	
	@Column
	private String designation;
	private String basic;
	private String deducePerLeave;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "payrollMaster")
	private List<Payroll> payroll;
	
	
	public PayrollMaster() {
		super();
	}

	


	public PayrollMaster(Long pid, String designation, String basic, String deducePerLeave, List<Payroll> payroll) {
		super();
		this.pid = pid;
		this.designation = designation;
		this.basic = basic;
		this.deducePerLeave = deducePerLeave;
		this.payroll = payroll;
	}




	public Long getPid() {
		return pid;
	}



	public void setPid(Long pid) {
		this.pid = pid;
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



	public void setBasic(String basic) {
		this.basic = basic;
	}



	public String getDeducePerLeave() {
		return deducePerLeave;
	}



	public void setDeducePerLeave(String deducePerLeave) {
		this.deducePerLeave = deducePerLeave;
	}




	public List<Payroll> getPayrolls() {
		return payroll;
	}




	public void setPayrolls(List<Payroll> payroll) {
		this.payroll = payroll;
	}
	
	
	
	

}

package com.leave.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_leavemaster")
public class LeaveMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long lmid;
	
	@Column
	private String leaveCategories;
	private int noOfLeaves;
	
	public LeaveMaster() {
		super();
	}

	public LeaveMaster(Long lmid, String leaveCategories, int noOfLeaves) {
		super();
		this.lmid = lmid;
		this.leaveCategories = leaveCategories;
		this.noOfLeaves = noOfLeaves;
	}

	public Long getLmid() {
		return lmid;
	}

	public void setLmid(Long lmid) {
		this.lmid = lmid;
	}

	public String getLeaveCategories() {
		return leaveCategories;
	}

	public void setLeaveCategories(String leaveCategories) {
		this.leaveCategories = leaveCategories;
	}

	public int getNoOfLeaves() {
		return noOfLeaves;
	}

	public void setNoOfLeaves(int noOfLeaves) {
		this.noOfLeaves = noOfLeaves;
	}	
	
}

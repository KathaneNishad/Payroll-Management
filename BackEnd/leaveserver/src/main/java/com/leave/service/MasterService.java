package com.leave.service;

import java.util.List;

import com.leave.entity.LeaveMaster;

public interface MasterService {
	//Add Leave Categories
	public LeaveMaster createLeaveCategories(LeaveMaster leaveMaster);
	
	//view All Leaves details
	public List<LeaveMaster> getAllLeaveCategories();
	
	//update existing leave categories details
	public LeaveMaster updateLeaveCategoryById(Long lmid,LeaveMaster leaveMaster);
}

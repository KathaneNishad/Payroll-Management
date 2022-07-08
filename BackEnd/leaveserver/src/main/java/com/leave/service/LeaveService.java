package com.leave.service;

import java.util.List;

import com.leave.entity.Leave;

public interface LeaveService {
	//generate leave
	public Leave createLeave(Leave leave);
	//view all leaves
	public List<Leave> getAllLeave();
	//get leaves for particular user_id
	public List<Leave> getLeavesByUserId(Long user_id);
	//Update leave Status
	public Leave updateLeaveStatus(Long lid,Leave leave);
	//Leave Count
	public int countOfLeavesByUser(Long user_id);

}

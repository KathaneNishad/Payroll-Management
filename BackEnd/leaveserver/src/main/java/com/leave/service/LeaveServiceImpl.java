package com.leave.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leave.entity.Leave;
import com.leave.repo.LeaveRepository;

@Service
public class LeaveServiceImpl implements LeaveService{
	
	@Autowired
	private LeaveRepository leaveRepository;
	
	@Override
	public Leave createLeave(Leave leave) {
		System.out.println("Leave created");
		return this.leaveRepository.save(leave);
	}

	@Override
	public List<Leave> getAllLeave() {
		System.out.println(this.leaveRepository.findAll());
		return this.leaveRepository.findAll();
	}

	@Override
	public List<Leave> getLeavesByUserId(Long user_id) {
		// TODO Auto-generated method stub
		System.out.println("User Id::"+user_id);
//		List<Long> users = Arrays.asList(user_id);
//		System.out.println(users);
//		List<Long> user =  Arrays.asList(35L);
		
		/*System.out.println(this.leaveRepository.findAllById(user));
		Iterable<Leave> userIt =this.leaveRepository.findAllById(user);
		System.out.println(userIt);*/
		
		List<Leave> leaveList = this.leaveRepository.findAll();
		List<Leave> userLeaves =new  ArrayList<>();
		for(Leave l:leaveList) {
			if((l.getUser_id())==user_id){
				System.out.println("Here an obj"+l);
				userLeaves.add(l);
				
			}
		}
		return userLeaves;
		//return this.leaveRepository.findAllById(users);
	}

	@Override
	public Leave updateLeaveStatus(Long lid, Leave leave) {
		Leave status = this.leaveRepository.findById(lid).get();
		status.setLeaveStatus(leave.getLeaveStatus());
		
		return this.leaveRepository.save(status);
	}
	
	//Count leaves for a User by its Id
	@Override
	public int countOfLeavesByUser(Long user_id) {
		List<Leave> leaveList = this.leaveRepository.findAll();
	//List<Leave> userLeaves =new  ArrayList<>();
		int leaveCount=0;
		for(Leave l:leaveList) {
			if((l.getUser_id())==user_id && (l.getLeaveStatus()).equals("Approved")) {
				leaveCount += l.getNumberOfLeave();
			//	System.out.println("Here-->"+l.getLeaveStatus());
				
			}
		}
		return leaveCount;
	}
	
	//Count leaves for user by id for current month
	@Override
	public int countLeaveForCurrentMonth(Long user_id) {
		List<Leave> leaveList = this.leaveRepository.countOfLeavesForCurrentMotnh(user_id);
		//List<Leave> userLeaves =new  ArrayList<>();
			int leaves=0;
			for(Leave l:leaveList) {
				if((l.getLeaveStatus()).equals("Approved")) {
					leaves += l.getNumberOfLeave();
					
				}
			}
		return leaves;
	}
	
	
	
	
	
}

package com.leave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leave.entity.Leave;
import com.leave.entity.LeaveMaster;
import com.leave.service.LeaveService;
import com.leave.service.MasterService;

@RestController
@RequestMapping("/leave")
@CrossOrigin(origins ="http://localhost:4402",allowedHeaders ="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class LeaveController {
	
	@Autowired
	LeaveService leaveService;
	
	@Autowired
	MasterService masterService;
	
	////Leave
	//Create A leave
	@PostMapping("/request-leave")
	public Leave generateLeave(@RequestBody Leave leave) {
		return this.leaveService.createLeave(leave);
	}
	
	//View all Leaves
	@GetMapping("/view-all-leaves")
	public List<Leave> viewAllLeave(){
		return this.leaveService.getAllLeave();
	}
	
	//View all leaves by a user
	@GetMapping("/view-leave/{user_id}")
	public List<Leave> viewAllLeaveByUserId(@PathVariable("user_id") Long user_id){
		return this.leaveService.getLeavesByUserId(user_id);
	}
	
	//Update Leave Status
	@PutMapping("/update-leave-status")
	public Leave updateLeave(@RequestBody Leave leave) {
		return leaveService.updateLeaveStatus(leave.getLid(), leave);
	}
	
	///Leave Master
	//add leave category
	@PostMapping("/add-category")
	public LeaveMaster createCatgegory(@RequestBody LeaveMaster leaveMaster) {
		return this.masterService.createLeaveCategories(leaveMaster);
	}
	
	//View all categories
	@GetMapping("/view-categories")
	public List<LeaveMaster> getAllCategories(){
		return this.masterService.getAllLeaveCategories();
	}
	
	//Update Existing Categories
	@PutMapping("/edit-categories")
	public LeaveMaster updateCategories(@RequestBody LeaveMaster leaveMaster) {
		return this.masterService.updateLeaveCategoryById(leaveMaster.getLmid(),leaveMaster);
	}
	
	//Get leaveCount for a user
	@GetMapping("/leave-count/{user_id}")
	public int leaveCount(@PathVariable("user_id") Long user_id) {
		return this.leaveService.countOfLeavesByUser(user_id);
	}
	
	//Get leaveCount for a user for current month
	@GetMapping("/leave-count-thismonth/{user_id}")
	public int leaveCountThisMonth(@PathVariable("user_id") Long user_id) {
		return this.leaveService.countLeaveForCurrentMonth(user_id);
	}
	
}

package com.leave.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leave.entity.LeaveMaster;
import com.leave.repo.LeaveMasterRepository;

@Service
public class MasterServiceImpl implements MasterService{

	@Autowired
	private LeaveMasterRepository leaveMasterRepository;
	
	@Override
	public LeaveMaster createLeaveCategories(LeaveMaster leaveMaster) {
		return this.leaveMasterRepository.save(leaveMaster);
	}

	@Override
	public List<LeaveMaster> getAllLeaveCategories() {
		return this.leaveMasterRepository.findAll();
	}

	@Override
	public LeaveMaster updateLeaveCategoryById(Long lmid,LeaveMaster leaveMaster) {
		LeaveMaster lmaster = this.leaveMasterRepository.findById(lmid).get();
		
		lmaster.setNoOfLeaves(leaveMaster.getNoOfLeaves());
		
		
		return this.leaveMasterRepository.save(lmaster);
	}

}

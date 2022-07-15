package com.leave.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.leave.entity.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Long>{
	//Leave Count for current month
	@Query(value="select *from prog.tbl_leave where monthname(start_date)=(select monthname(str_to_date(if(month(now())-1<>0,month(now())-1,12),'%m'))) and user_id=:id",nativeQuery = true)
	public List<Leave> countOfLeavesForCurrentMotnh(@Param("id")Long  user_id);
}

package com.leave.entity;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="tbl_leave")
public class Leave {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long lid;
	
	@Column
	private Long user_id;
	
	private String leaveDescription;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate startDate;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate endDate;
	
	private int numberOfLeave;
	
	private String leaveStatus ="Pending";

	public Leave() {
		super();
	}

	public Leave(Long lid, Long user_id, String leaveDescription, LocalDate startDate, LocalDate endDate,
			int numberOfLeave, String leaveStatus) {
		super();
		this.lid = lid;
		this.user_id = user_id;
		this.leaveDescription = leaveDescription;
		this.startDate = startDate;
		this.endDate = endDate;
		this.numberOfLeave = numberOfLeave;
		this.leaveStatus = leaveStatus;
	}

	public Long getLid() {
		return lid;
	}

	public void setLid(Long lid) {
		this.lid = lid;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getLeaveDescription() {
		return leaveDescription;
	}

	public void setLeaveDescription(String leaveDescription) {
		this.leaveDescription = leaveDescription;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getNumberOfLeave() {
		return numberOfLeave;
		
		
	}

	public void setNumberOfLeave(int numberOfLeave) {
		/*
		 * LocalDateTime date1 = getStartDate().atStartOfDay(); LocalDateTime date2 =
		 * getEndDate().atStartOfDay(); long daysBetween = Duration.between(date1,
		 * date2).toDays(); numberOfLeave= (int)daysBetween-1; //System.out.println
		 * ("Days: " + daysBetween);
		 */		
		this.numberOfLeave = numberOfLeave;
	}

	public String getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	
	 	
	
	

}

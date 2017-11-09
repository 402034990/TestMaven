package com.uc.wangzhe.dto;

import java.util.Date;


public class CurCourseDto {
	private Integer id;
	private String code;
	private Date curStartDate;
	private String curDesc;
	private String curMovieFile;
	private String curGoal;
	private String curTargetUser;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getCurStartDate() {
		return curStartDate;
	}
	public void setCurStartDate(Date curStartDate) {
		this.curStartDate = curStartDate;
	}
	public String getCurDesc() {
		return curDesc;
	}
	public void setCurDesc(String curDesc) {
		this.curDesc = curDesc;
	}
	public String getCurMovieFile() {
		return curMovieFile;
	}
	public void setCurMovieFile(String curMovieFile) {
		this.curMovieFile = curMovieFile;
	}
	public String getCurGoal() {
		return curGoal;
	}
	public void setCurGoal(String curGoal) {
		this.curGoal = curGoal;
	}
	public String getCurTargetUser() {
		return curTargetUser;
	}
	public void setCurTargetUser(String curTargetUser) {
		this.curTargetUser = curTargetUser;
	}
	
	
}

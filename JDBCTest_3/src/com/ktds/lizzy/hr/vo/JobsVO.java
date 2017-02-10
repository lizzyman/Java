package com.ktds.lizzy.hr.vo;

import com.ktds.lizzy.hr.dao.support.annotation.Types;

public class JobsVO {
	
	@Types
	private String jobId;
	@Types
	private String jobTitle;
	@Types
	private int minSalary;
	@Types
	private int masSalary;
	
	public String getJobId() {
		return jobId;
	}
	
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}
	
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public int getMinSalary() {
		return minSalary;
	}
	
	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}
	
	public int getMasSalary() {
		return masSalary;
	}
	
	public void setMasSalary(int masSalary) {
		this.masSalary = masSalary;
	}
	
}

package com.vasanthi.ibm.training;

import org.springframework.stereotype.Component;

@Component
public class Logindetails {

	private Integer accountNo;
	
	private String password;
	
	//private String status;

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}

	public Logindetails(Integer accountNo, String password) {
		
		this.accountNo = accountNo;
		this.password = password;
		//this.status = status;
	}

	public Logindetails() {
		
	}
	
	
}

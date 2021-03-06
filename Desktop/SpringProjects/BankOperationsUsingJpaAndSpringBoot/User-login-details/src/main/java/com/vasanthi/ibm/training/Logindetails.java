package com.vasanthi.ibm.training;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Logindetails {

	@Id
	private Integer accountNo;
	
	private String password;
	
	private String status;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Logindetails(Integer accountNo, String password, String status) {
		
		this.accountNo = accountNo;
		this.password = password;
		this.status = status;
	}

	public Logindetails() {
		
	}
	
	
}

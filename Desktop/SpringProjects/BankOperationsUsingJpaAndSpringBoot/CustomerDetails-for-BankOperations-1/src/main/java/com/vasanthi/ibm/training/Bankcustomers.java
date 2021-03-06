package com.vasanthi.ibm.training;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Bankcustomers {

	private String cutsomerName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountNo;
	
	private Integer amount;
	
	private String phoneNo;
	
	@Transient
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Bankcustomers(String cutsomerName, Integer accountNo, Integer amount, String phoneNo) {
		
		this.cutsomerName = cutsomerName;
		this.accountNo = accountNo;
		this.amount = amount;
		this.phoneNo = phoneNo;
	}

	public String getCutsomerName() {
		return cutsomerName;
	}

	public void setCutsomerName(String cutsomerName) {
		this.cutsomerName = cutsomerName;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Bankcustomers [cutsomerName=" + cutsomerName + ", accountNo=" + accountNo + ", amount=" + amount
				+ ", phoneNo=" + phoneNo + "]";
	}

	public Bankcustomers() {

	}
	
	
}


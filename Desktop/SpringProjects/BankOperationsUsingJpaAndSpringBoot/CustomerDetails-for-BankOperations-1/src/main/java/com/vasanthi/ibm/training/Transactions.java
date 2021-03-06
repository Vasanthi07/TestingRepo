package com.vasanthi.ibm.training;

import org.springframework.stereotype.Component;

@Component
public class Transactions {

	private Integer transAccount;
	
	private Integer fromAccount;
	
	private String status;
	
	private Integer amount;

	public Integer getTransAccount() {
		return transAccount;
	}

	public void setTransAccount(Integer transAccount) {
		this.transAccount = transAccount;
	}

	public Integer getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Integer fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Transactions(Integer transAccount, Integer fromAccount, String status, Integer amount) {
		this.transAccount = transAccount;
		this.fromAccount = fromAccount;
		this.status = status;
		this.amount = amount;
	}

	public Transactions() {
	}
	
	
}

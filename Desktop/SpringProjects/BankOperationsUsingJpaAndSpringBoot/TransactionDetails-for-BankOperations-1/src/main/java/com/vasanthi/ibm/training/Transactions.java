package com.vasanthi.ibm.training;



import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transactionId;
	
	private Integer transAccount;
	
	private Integer fromAccount;
	
	private String status;
	
	private Integer amount;
//	
////	@Column(name = "time", columnDefinition = "TIME")
////	private LocalTime localTime;
//////
////	@Column(name = "date", columnDefinition = "DATE")
////	private LocalDate localDate;
//	
//	@Column(nullable = false, updatable = false)
//    @Temporal(TemporalType.DATE)
//    //@CreatedDate
//	private Date date;
//	
//	@Column(nullable = false, updatable = false)
//	@Temporal(TemporalType.TIME)
//	private Date time;
//	

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}


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

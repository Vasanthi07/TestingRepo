package com.vasanthi.ibm.training;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository repo;
	
	List<Transactions> getAllRecords(){
		return (List<Transactions>) repo.findAll();
	}
	
	void newTransaction(Transactions theTransactions) {
		repo.save(theTransactions);
	}
	
	List<Transactions> getTransactionDetailsById(Integer accountNo) {
		return repo.findByTransAccount(accountNo);
	}
	
}

package com.vasanthi.ibm.training;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	@Autowired
	TransactionService service;
	
	@RequestMapping("/all")
	List<Transactions> getAllRecords(){
		return service.getAllRecords();
	}
	
	@PostMapping("/newTransaction")
	void newTransaction(@RequestBody Transactions theTransaction) {
		service.newTransaction(theTransaction);
	}
	
	@RequestMapping("/allTransactions/{accountNo}")
	List<Transactions> getTransactionByAccount(@PathVariable Integer accountNo){
		return service.getTransactionDetailsById(accountNo);
	}
}

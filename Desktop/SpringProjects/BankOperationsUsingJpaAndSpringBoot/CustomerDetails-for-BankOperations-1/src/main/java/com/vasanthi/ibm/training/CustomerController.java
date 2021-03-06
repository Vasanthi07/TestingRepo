package com.vasanthi.ibm.training;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class CustomerController {

	@Autowired
	CustomerService theService;
	
	//to get all customers from a bank
	@RequestMapping("/customers/all")
	List<Bankcustomers> getAllCustomers(){
		return theService.getAllCustomers();
	}
	
	//to get specific person details by using his account number..
	@RequestMapping("/customers/{id}")
	Optional<Bankcustomers> getEmployeeByAccountNo(@PathVariable int id) {
		return theService.getCustomerByAccountNo(id);
	}
	
	//to add new customer to the existing database bank customers
	@PostMapping("/customers")
	String addNewCustomer(@RequestBody Bankcustomers theCustomer) {
		return theService.addNewCustomer(theCustomer);
	}
	
	//update an existing customer based on accountNo
	@PutMapping("/customers/{id}")
	void updateCustomer(@RequestBody Bankcustomers theCustomer,@PathVariable int id) {
		theService.updateCustomer(theCustomer, id);
	}
	
	//find a customer by phone number
	@RequestMapping("/customers/phoneNo/{phoneNo}")
	boolean getCustomerByPhoneNo(@PathVariable String phoneNo){
		return theService.getCustomerByPhoneNo(phoneNo);
	}
	
	//get amount based on accountNo
	@RequestMapping("/customer/accountNo/{accountNo}")
	Object checkBalance(@PathVariable Integer accountNo) {
		
		return theService.checkBalance(accountNo);
	}

	//deposit money into a specified account
	@PutMapping("/customer/depositMoney/{accountNo}/{amount}")
	String depositMoney(@PathVariable Integer accountNo,@PathVariable Integer amount) {
		return theService.depositMoney(accountNo, amount);
	}
	
	//withdraw money from specified account
	@PutMapping("/customer/withdrawMoney/{accountNo}/{amount}")
	String withdrawMoney(@PathVariable Integer accountNo,@PathVariable Integer amount) {
		return theService.withdrawMoney(accountNo, amount);
	}
	
	//fund transferring- transferring amount from one account to another...
	@PutMapping("customer/fromAccountNo/{fromAccountNo}/toAccountNo/{toAccountNo}/amount/{amount}")
	String fundTransfer(@PathVariable Integer fromAccountNo,@PathVariable Integer toAccountNo,@PathVariable Integer amount) {
		return theService.fundTransfer(fromAccountNo, toAccountNo, amount);
	}
	
	//get all transactions done by an account..
	@RequestMapping("/allTransactions/{accountNo}")
	List<Object> getTransactionByAccount(@PathVariable Integer accountNo){
		return theService.getTransactionDetailsById(accountNo);
	}
	
	//check login status of an account...i.e., whether it is logged in or logged out...
	
	@RequestMapping("/checkStatus/{accountNo}")
	String checkStatus(@PathVariable Integer accountNo) {
		return theService.checkStatus(accountNo);
	}
	
}

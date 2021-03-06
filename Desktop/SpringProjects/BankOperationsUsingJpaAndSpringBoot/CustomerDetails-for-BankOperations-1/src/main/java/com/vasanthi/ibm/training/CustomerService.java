package com.vasanthi.ibm.training;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {
	
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	Transactions transactions;
	
	@Autowired
	CustomersRepository repo;
	
	@Autowired
	Logindetails login;

	List<Bankcustomers> getAllCustomers() {
		return (List<Bankcustomers>) repo.findAll();
	}

	Optional<Bankcustomers> getCustomerByAccountNo(int id) {
		return repo.findById(id);
	}
	

	String addNewCustomer(Bankcustomers theCustomer) {
		if(getCustomerByPhoneNo(theCustomer.getPhoneNo()))
			return "already exists with same phoneNo";
		else {
			repo.save(theCustomer);
			login.setAccountNo(theCustomer.getAccountNo());
			login.setPassword(theCustomer.getPassword());
			String urlToLogin = "http://localhost:8078/login/newUser";
			restTemplate.postForObject(urlToLogin, login, Object[].class);
			return "Customer account created succesfully with accountNo : "+theCustomer.getAccountNo();
		}
	}

	void updateCustomer(Bankcustomers theCustomer, int id) {
		repo.save(theCustomer);
	}

	boolean getCustomerByPhoneNo(String phoneNo) {
		List<Bankcustomers> customer= repo.findByPhoneNo(phoneNo);
		if(customer.size()>0) {
			return true;
		}
		return false;
	}

	Object checkBalance(Integer accountNo) {
		if(checkStatus(accountNo).equals("active")) {
		return repo.checkBalance(accountNo);}
		return "Please login to your account";
	}
	
	String checkStatus(Integer accountNo) {
		
		String urlToCheckLoginStatus ="http://localhost:8078/login/checkStatus/"+accountNo;
		return restTemplate.getForObject(urlToCheckLoginStatus, String.class);
	}


	String depositMoney(Integer accountNo, Integer depositAmount) {

		if(checkStatus(accountNo).equals("active")) {
		Integer amount = repo.checkBalance(accountNo) + depositAmount;
		repo.updateMoney(accountNo, amount);
		transactions.setTransAccount(accountNo);
		transactions.setFromAccount(accountNo);
		transactions.setStatus("credited");
		transactions.setAmount(depositAmount);
		
		String urlForAddingTransaction = "http://localhost:8077/transactions/newTransaction";
		restTemplate.postForObject(urlForAddingTransaction, transactions,Object[].class);
		return "Available balance after depositing is : " + amount;
		}
		else {
			return "Please login to your account";
		}
	}
	
	String withdrawMoney(Integer accountNo, Integer withdrawAmount) {

		if(checkStatus(accountNo).equals("active")) {
		Integer amount = repo.checkBalance(accountNo);
		if (amount > withdrawAmount) {
			amount = amount - withdrawAmount;
			repo.updateMoney(accountNo, amount);
			transactions.setTransAccount(accountNo);
			transactions.setFromAccount(accountNo);
			transactions.setStatus("debited");
			transactions.setAmount(withdrawAmount);
			
			String urlForAddingTransaction = "http://localhost:8077/transactions/newTransaction";
			restTemplate.postForObject(urlForAddingTransaction, transactions,Object[].class);
			return "Available balance after withdrawing is : " + amount;
		}
		return "Low Balance";}
		return "Please login to your account";
	}
	
	String fundTransfer(Integer fromAccountNo,Integer toAccountNo,Integer amount) {
		
		if(checkStatus(fromAccountNo).equals("active")) {
		Integer fromAmount = repo.checkBalance(fromAccountNo);
		if(fromAmount>amount) {
			fromAmount = fromAmount - amount;
			repo.updateMoney(fromAccountNo, fromAmount);
			Integer toAmount = repo.checkBalance(toAccountNo)+amount;
			repo.updateMoney(toAccountNo, toAmount);
			transactions.setTransAccount(fromAccountNo);
			transactions.setFromAccount(toAccountNo);
			transactions.setStatus("debited");
			transactions.setAmount(amount);
			
			String urlForAddingTransaction = "http://localhost:8077/transactions/newTransaction";
			restTemplate.postForObject(urlForAddingTransaction, transactions,Object[].class);
			
			transactions.setTransAccount(toAccountNo);
			transactions.setFromAccount(fromAccountNo);
			transactions.setStatus("credited");
			transactions.setAmount(amount);
			
			String urlForAddinganotherTransaction = "http://localhost:8077/transactions/newTransaction";
			restTemplate.postForObject(urlForAddinganotherTransaction, transactions,Object[].class);
			return "Successfully Transferred...\n Available balance after transferring is: "+fromAmount+"\nAvailable balance after crediting is: "+toAmount;
		}
		return "low balance";}
		return "please login to your account";
	}

	public List<Object> getTransactionDetailsById(Integer accountNo) {
		
		if(checkStatus(accountNo).equals("active")) {
		String urlForDisplayingTransaction = "http://localhost:8077/transactions/allTransactions/"+accountNo;
		Object[] fetchedRecords = restTemplate.getForObject(urlForDisplayingTransaction, Object[].class);
		return Arrays.asList(fetchedRecords);
		}
		return Arrays.asList("please login to your account");
	}
}

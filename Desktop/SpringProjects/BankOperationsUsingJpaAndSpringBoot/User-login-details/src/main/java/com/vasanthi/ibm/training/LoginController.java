package com.vasanthi.ibm.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService service;

	@PostMapping("/newUser")
	String addNewLoginDetails(@RequestBody Logindetails login) {

		return service.addNewLoginDetails(login);
	}
	
	@PutMapping("/user/{accountNo}")
	String loginToUser(@RequestBody Logindetails login, @PathVariable Integer accountNo) {
		return service.loginToUser(login,accountNo);
		
	}
	
	
	@RequestMapping("/logout/{accountNo}")
	void logoff(@PathVariable Integer accountNo) {
		service.logoffUser(accountNo);
	}
	
	@RequestMapping("/checkStatus/{accountNo}")
	String checkStatus(@PathVariable Integer accountNo) {
		return service.checkStatus(accountNo);
	}
	
	
}

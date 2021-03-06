package com.vasanthi.ibm.training;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	@Autowired
	LoginRepository repo;

	public static boolean validate(String password) {
		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";

		Pattern p = Pattern.compile(regex);

		if (password == null) {
			return false;
		}

		Matcher m = p.matcher(password);

		return m.matches();
	}

	String addNewLoginDetails(Logindetails login) {
		//System.out.println(login.getPassword());
		//System.out.println(validate(login.getPassword()));
		login.setStatus("inactive");
		if (validate(login.getPassword())) {
			repo.save(login);
		} else {
			return "password is not in correct format";
		}
		return "";

	}
	String loginToUser(Logindetails login, Integer accountNo) {
		
		String comparePassword = login.getPassword();
		System.out.println(login.getPassword());
		System.out.println(login.getAccountNo());
		String userPassword = repo.getUserPassword(login.getAccountNo());
		if(userPassword.equals(comparePassword)) {
			//login.setStatus("active");
			repo.updateStatus(accountNo);
			return "logged in succesfully";
		}
		else {
			return "incorrect password";
		}
	}
	
	String checkStatus(Integer accountNo) {
		return repo.checkStatus(accountNo);
	}
	
	void logoffUser(Integer accountNo) {
		repo.logoff(accountNo);
	}
}

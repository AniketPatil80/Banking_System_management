package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.Account;
import com.cdac.entity.Registration;
import com.cdac.repository.AccountRepository;
import com.cdac.service.AccountService;

@CrossOrigin
@RestController
public class AccountController {
	@Autowired
	public AccountService rr;
	@PostMapping("/add-account")
	public String add(@RequestBody Account user) {
		rr.add(user);
		return null;
	
	}
	
	@GetMapping("/deposit")
	public String deposit(@RequestParam int accountNumber, @RequestParam double amount) {
	    boolean depositSuccessful = rr.deposit(accountNumber, amount);
	    if (depositSuccessful) {
	        return "Deposit successful";
	    } else {
	        return "Failed to deposit";
	    }
	}

	
	@GetMapping("/withdraw")
	public String withdraw(@RequestParam int accountNumber, @RequestParam double amount, @RequestParam int pin) {
	    boolean withdrawSuccessful = rr.withdraw(accountNumber, amount, pin);
	    if (withdrawSuccessful) {
	        return "Withdraw successful";
	    } else {
	        return "Failed to Withdraw";
	    }
	}
	
	@GetMapping("/transfer")
	public String withdraw(@RequestParam int fromAccountNumber,@RequestParam int toAccountNumber, @RequestParam double amount, @RequestParam int pin) {
	    boolean transferSuccessful = rr.transfer(fromAccountNumber, toAccountNumber, amount, pin);
	    if (transferSuccessful) {
	        return "transfer successful";
	    } else {
	        return "Failed to transfer";
	    }
	}
	
	@GetMapping("/balance")
	public double getBalance(@RequestParam int AccountNumber) {
	    
	 return rr.getBalance(AccountNumber);
	}
	



}
	




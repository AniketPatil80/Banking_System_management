package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.Transaction;
import com.cdac.service.TransactionService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TransactionController {

	@Autowired
	private TransactionService rr;
	
	@GetMapping("/mini")
	public List<Transaction> miniStatement(@RequestParam int accountNumber) {
	     List<Transaction> miniStatement = rr.miniStatement(accountNumber);
	     return miniStatement;
	}
}

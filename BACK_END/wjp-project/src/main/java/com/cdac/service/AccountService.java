package com.cdac.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.Account;
import com.cdac.entity.Transaction;
import com.cdac.repository.AccountRepository;
import com.cdac.repository.TransactionRepository;
import com.cdac.exception.Exception;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepo;

//	@Autowired
//	private Transaction tx;

	@Autowired
	private TransactionRepository transactionRepo;

	public void add(Account account) {
		if (account.getBalance() < 5000)
			throw new Exception("Cannot open Account. Minimum Balance required is 5000 Rs!");
		else {
			accountRepo.save(account);
		}

	}

	public boolean withdraw(int acno, double amount, int pin) {
		// balance should get updated in the account table
		// one record should get inserted in transaction table

		Account account = (Account) accountRepo.findByAcno(acno);
		if (amount > account.getBalance()  ) {
			throw new Exception("Cannot Withdraw. Insufficient Balance! or Invalid Pin");
			}
		else if(account.getPin() != pin) {
			throw new Exception("Invalid Pin");
		}
		else {
			account.setBalance(account.getBalance() - amount);
			accountRepo.save(account);

			Transaction tx = new Transaction();
			tx.setType("Withdraw");
			tx.setAmount(amount);
			tx.setDateAndTime(LocalDateTime.now());
			tx.setAccount(account);

			transactionRepo.save(tx);
			return true;
		}
	}
	
	public boolean deposit(int acno, double amount) {
		// balance should get updated in the account table
		// one record should get inserted in transaction table

		Account account = (Account) accountRepo.findByAcno(acno);
	
			account.setBalance(account.getBalance() + amount);
			accountRepo.save(account);

			Transaction tx = new Transaction();
			tx.setType("Deposit");
			tx.setAmount(amount);
			tx.setDateAndTime(LocalDateTime.now());
			tx.setAccount(account);

			transactionRepo.save(tx);
			return true;
		
	}
	
	
	public boolean transfer(int fromAcno, int toAcno, double amount, int pin) {
		//withdraw(fromAcno,  amount);
		//deposit(toAcno, amount);
		
		Account fromAccount = (Account) accountRepo.findByAcno(fromAcno);
		Account toAccount = (Account) accountRepo.findByAcno(toAcno);
		if(amount > fromAccount.getBalance()) {
			throw new Exception("Cannot Transfer. Insufficient Balance!");
			}
		else if(fromAccount.getPin() != pin){
			throw new Exception("Invalid Pin!");
		}
		else {
			fromAccount.setBalance(fromAccount.getBalance() - amount);
			toAccount.setBalance(toAccount.getBalance() + amount);

			Transaction tx1 = new Transaction();
			tx1.setType("FUND TRANSFER");
			tx1.setAmount(amount);
			tx1.setDateAndTime(LocalDateTime.now());
			tx1.setAccount(fromAccount);
			Transaction tx2 = new Transaction();
			tx2.setType("FUND RECEIVED");
			tx2.setAmount(amount);
			tx2.setDateAndTime(LocalDateTime.now());
			tx2.setAccount(toAccount);
			
		
			
			accountRepo.save(fromAccount);
			accountRepo.save(toAccount);
			transactionRepo.save(tx1);
			transactionRepo.save(tx2);
			
			return true;
		}
	}
	
	public double getBalance(int acno) {
		Account account = (Account) accountRepo.findByAcno(acno);
		
		return account.getBalance();
	}

}

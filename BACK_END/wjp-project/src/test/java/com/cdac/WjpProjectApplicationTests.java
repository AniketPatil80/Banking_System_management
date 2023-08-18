package com.cdac;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cdac.entity.Account;
import com.cdac.entity.User;
import com.cdac.repository.AccountRepository;
import com.cdac.repository.UserRepository;
import com.cdac.service.AccountService;


@SpringBootTest
class WjpProjectApplicationTests {

	@Autowired
	private UserRepository userRepo;
	
	@Test
	void addUser() {
		User user = new User();
		user.setFirstName("sohel");
		user.setLastName("khan");
		user.setEmail("sohel@gmail.com");
		user.setPhoneNumber(79525840L);
		user.setPassword("@sohel1234");
		user.setGender("male");
		
		
		userRepo.save(user);	
		
	}
	
	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private AccountService accountService;
	
	@Test
	void addAccount() {
		Account account = new Account();
		account.setFirstName("Aniket");
		account.setLastName("patil");
		account.setEmail("aniketpatil@gmail.com");
		account.setAddress("kalyan");
		account.setAccountType("Saving");
		account.setPin(8181);
		account.setBalance(6000);
		account.setPhoneNumber(799855588L);
		account.setAadharNumber(525554845L);
		
		accountService.add(account);
		
	}
	
	@Test
	public void testing_withdraw() {
		
		accountService.withdraw(1, 1000, 8281);
	}
	
	@Test
	public void testing_deposit() {
		accountService.deposit(1, 6000);
	}
	
	
	
	@Test
	public void testing_transfer() {
		accountService.transfer(1, 2, 1000, 8282);
	}
	
}

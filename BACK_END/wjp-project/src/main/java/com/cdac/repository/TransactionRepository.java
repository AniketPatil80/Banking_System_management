package com.cdac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cdac.entity.Account;
import com.cdac.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
  //List<Transaction> findByAccountNumber(int accountNumber);
	
	@Query(value = "select t from Transaction t where t.account.acno = :acno")
	public List<Transaction> findByAccountAcno(@Param("acno") int acno);
	
}

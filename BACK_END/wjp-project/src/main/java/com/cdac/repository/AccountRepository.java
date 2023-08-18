package com.cdac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cdac.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
  // @Query("select a from Account a where a.acno = ?1")
	public Account findByAcno(int account);
	
	
}

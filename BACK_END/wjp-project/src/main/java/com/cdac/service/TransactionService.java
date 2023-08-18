package com.cdac.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.Transaction;
import com.cdac.repository.TransactionRepository;
import com.cdac.util.JPAUtil;


@Service
public class TransactionService {
//	
//	public List<Transaction> miniStatement(int acno){
//		EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
//		EntityManager em = null;
//		try {
//			em = emf.createEntityManager();
//			//select * from tbl_transaction where acc_num = 1;
//			Query q = em.createQuery("select t from Transaction t join t.account a where a.accountNumber = :acc");
//			q.setParameter("acc", acno);
//			List<Transaction> list = q.getResultList();
//			return list;
//		} finally {
//			em.close();
//		}
//	}
	
	@Autowired
	private TransactionRepository transactionRepo;
	
	
	public List<Transaction> miniStatement(int acno){
		return transactionRepo.findByAccountAcno(acno);
	
	}
}

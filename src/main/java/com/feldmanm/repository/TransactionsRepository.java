package com.feldmanm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.feldmanm.model.Transaction;

public interface TransactionsRepository extends CrudRepository<Transaction, Integer> {

	 @Query("select account_code from Transaction c where c.account_code = account_code")
	List<Transaction> findListOfTransactionsByAccountCode(int account_code); 
}

package com.feldmanm.repository;

import org.springframework.data.repository.CrudRepository;

import com.feldmanm.model.Transaction;

public interface TransactionsRepository extends CrudRepository<Transaction, Integer> {

}

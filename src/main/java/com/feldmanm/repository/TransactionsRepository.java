package com.feldmanm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feldmanm.model.Transaction;

public interface TransactionsRepository extends JpaRepository<Transaction, Integer> {

}

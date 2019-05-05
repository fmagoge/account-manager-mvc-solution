package com.feldmanm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feldmanm.model.Transaction;
import com.feldmanm.repository.TransactionsRepository;

@Service
public class TransactionsService {

	@Autowired
	public TransactionsRepository transactionsRepository;
	
	public List<Transaction>findListOfTransactionsByAccountCode(int code){
		return transactionsRepository.findListOfTransactionsByAccountCode(code);
	}
	
	public List<Transaction> getAllTransactions() {
		return (List<Transaction>) transactionsRepository.findAll();
	}
	
	public List<Transaction> getTransactionsByAccountId(List<Integer> ids) {
		return (List<Transaction>) transactionsRepository.findAllById(ids);
	}
	
	public Optional<Transaction> getTransactionById(int id) {
		return transactionsRepository.findById(id);
	}
	
	public void deleteTransaction(Transaction transaction) {
		transactionsRepository.delete(transaction);
	}
	
	public void deleteTransactionById(int id) {
		transactionsRepository.deleteById(id);
	}
	
}

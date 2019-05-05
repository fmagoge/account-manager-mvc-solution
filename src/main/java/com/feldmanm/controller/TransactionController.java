package com.feldmanm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.feldmanm.repository.TransactionsRepository;

@Controller
public class TransactionController {

	@Autowired
	private TransactionsRepository transactionsRepository;

	private String getTransactionsByAccountCode(@PathVariable String code, Model model) {
		// List<Transaction> transactions = transactionsRepository.
		return "";
	}
}

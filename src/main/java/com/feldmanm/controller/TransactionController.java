package com.feldmanm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.feldmanm.model.Transaction;
import com.feldmanm.repository.TransactionsRepository;
import com.feldmanm.service.TransactionsService;

@Controller
public class TransactionController {

	@Autowired
	private TransactionsService transactionsService;

	@RequestMapping(value ="/account/{account_code}/transactions")
	public String getTransactionsByAccountCode(@PathVariable String account_code, Model model) {
		 List<Transaction> transactions = 
				 transactionsService.findListOfTransactionsByAccountCode(Integer.parseInt(account_code));
		 model.addAttribute("transactions", transactions);
		return "showtransactiondetails";
	}
	
}

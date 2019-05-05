package com.feldmanm.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.feldmanm.model.Account;
import com.feldmanm.model.Transaction;
import com.feldmanm.service.AccountsService;

@Controller
public class AccountController {

	@Autowired
	private AccountsService accountsService;

	public List<Account> getAccounts() {
		return accountsService.getAllAccounts();
	}

	@RequestMapping("/accounts/show/{id}")
	public String getAccountById(@PathVariable String id, Model model) {
		Optional<Account> accountOptional = accountsService.getAccountById(Integer.valueOf(id));
		
		Account account = null;
		if (accountOptional.isPresent()) {
			account = accountOptional.get();
			
			Set<Transaction> transactions = account.getListOfTransactions();
//			if (transactions.size() > 0) {
//				model.addAttribute("transactions", transactions);
//			}
		}
		model.addAttribute("account", account);
		return "showaccounts";
	}
	

	public void deleteAccount(Account account) {
		accountsService.deleteAccount(account);
	}

	public void saveAccount(Account account) {
		accountsService.saveAccount(account);
	}

	public void saveAllAccounts(List<Account> accounts) {
		accountsService.saveAllAccounts(accounts);
	}

}

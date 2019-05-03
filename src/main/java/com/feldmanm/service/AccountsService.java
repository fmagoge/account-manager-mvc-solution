package com.feldmanm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feldmanm.model.Account;
import com.feldmanm.repository.AccountsRepository;

@Service
public class AccountsService {

	@Autowired
	private AccountsRepository accountsRepository;
	
	
	public List<Account> getAllAccounts() {
		return (List<Account>) accountsRepository.findAll();
	}
	
	
	public Optional<Account> getAccountById(int id) {
		return accountsRepository.findById(id);
	}
	
	
	public void saveAccount(Account account) {
		accountsRepository.save(account);
	}
	
	public void saveAllAccounts(List<Account> listOfAccounts) {
		accountsRepository.saveAll(listOfAccounts);
	}
	
	public void deleteAccount(Account account) {
		accountsRepository.delete(account);
	}
	
}

package com.feldmanm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.feldmanm.model.Account;

public interface AccountsRepository extends CrudRepository<Account, Integer> {

}

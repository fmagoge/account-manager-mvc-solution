package com.feldmanm.repository;

import org.springframework.data.repository.CrudRepository;

import com.feldmanm.model.Person;

public interface PersonsRepository extends CrudRepository<Person, Integer> {

}

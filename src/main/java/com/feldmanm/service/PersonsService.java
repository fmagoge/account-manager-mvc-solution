package com.feldmanm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feldmanm.model.Person;
import com.feldmanm.repository.PersonsRepository;

@Service
public class PersonsService {
	
	@Autowired
	private PersonsRepository personsRepository;
	
	public List<Person> getAllPersons(){
		return (List<Person>) personsRepository.findAll();
	}
	
	public Optional<Person> getPersonById(int id) {
		return personsRepository.findById(id);
	}
	
	
	public void deletePersonById(int id) {
		personsRepository.deleteById(id);
	}
	
	public void deletePerson(Person person) {
		personsRepository.delete(person);
	}
	
	public void savePerson(Person person) {
		personsRepository.save(person);
	}
	
	public Person savePersonObj(Person person) {
		personsRepository.save(person);
		return person;
	}

}

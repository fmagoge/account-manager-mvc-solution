package com.feldmanm.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.feldmanm.model.Account;
import com.feldmanm.model.Person;
import com.feldmanm.model.Transaction;
import com.feldmanm.service.PersonsService;

@Controller
public class PersonController {

	
	

	@Autowired
	private PersonsService personsService;

	@RequestMapping("/")
	public String redirToList() {
		return "redirect:/all";
	}

	@RequestMapping("/all")
	public String getAllPersons(Model model) {
		model.addAttribute("persons", personsService.getAllPersons());
		return "index";
	}

	@RequestMapping("/entry/new")
	public String newPerson(Model model) {
		model.addAttribute("person", new Person());
		return "enterperson";
	}

	@RequestMapping(value = "/entry", method = RequestMethod.POST)
	public String saveOrUpdatePerson(@Valid Person person, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "/all";
		}

		Person person1 = personsService.savePersonObj(person);

		return "redirect:/person/show/" + person1.getCode();
	}

	@RequestMapping("/person/show/{id}")
	public String getPerson(@PathVariable String id, Model model) {
		Optional<Person> personOptional = personsService.getPersonById(Integer.valueOf(id));
		Person person = null;
		if (personOptional.isPresent()) {
			person = personOptional.get();
			Set<Account>accounts = person.getListOfAccounts();
			
			if (accounts.size() > 0) { model.addAttribute("accounts", accounts); }			 

		}

		model.addAttribute("person", person);
		return "showperson";
	}

	

}
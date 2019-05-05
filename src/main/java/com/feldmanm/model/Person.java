package com.feldmanm.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Persons")
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int code;
	private String name;
	private String surname;
	private String id_number;
	
	@JsonBackReference
	@OneToMany(mappedBy = "person_code", targetEntity = Account.class, 
			cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Account> listOfAccounts = new HashSet<Account>();		
	
	public Person() {
		super();
	}

	public Person(int code, String name, String surname, String id_number, Set<Account> listOfAccounts) {
		super();
		this.code = code;
		this.name = name;
		this.surname = surname;
		this.id_number = id_number;
		this.listOfAccounts = listOfAccounts;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getId_number() {
		return id_number;
	}

	public void setId_number(String id_number) {
		this.id_number = id_number;
	}

	public Set<Account> getListOfAccounts() {
		return listOfAccounts;
	}

	public void setListOfAccounts(Set<Account> listOfAccounts) {
		this.listOfAccounts = listOfAccounts;
	}

	@Override
	public String toString() {
		return "Persons [code=" + code + ", name=" + name + ", surname=" + surname + ", id_number=" + id_number
				+ ", listOfAccounts=" + listOfAccounts + "]";
	}
	
	
	
	

}

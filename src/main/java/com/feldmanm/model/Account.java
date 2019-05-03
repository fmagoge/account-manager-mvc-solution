package com.feldmanm.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Accounts")
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int code;
	
	@JsonManagedReference
	@ManyToOne
    @JoinColumn(name="person_code")
    private Person person_code;
	private String account_number;
	private double outstanding_balance;	
	
	@JsonBackReference
	@OneToMany(mappedBy = "account_code", targetEntity = Transaction.class, 
			cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Transaction> listOfTransactions = new HashSet<Transaction>();

	public Account() {
		super();
	}

	public Account(int code, Person person_code, String account_number, double outstanding_balance,
			Set<Transaction> listOfTransactions) {
		super();
		this.code = code;
		this.person_code = person_code;
		this.account_number = account_number;
		this.outstanding_balance = outstanding_balance;
		this.listOfTransactions = listOfTransactions;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Person getPerson_code() {
		return person_code;
	}

	public void setPerson_code(Person person_code) {
		this.person_code = person_code;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public double getOutstanding_balance() {
		return outstanding_balance;
	}

	public void setOutstanding_balance(double outstanding_balance) {
		this.outstanding_balance = outstanding_balance;
	}

	public Set<Transaction> getListOfTransactions() {
		return listOfTransactions;
	}

	public void setListOfTransactions(Set<Transaction> listOfTransactions) {
		this.listOfTransactions = listOfTransactions;
	}

	@Override
	public String toString() {
		return "Account [code=" + code + ", person_code=" + person_code + ", account_number=" + account_number
				+ ", outstanding_balance=" + outstanding_balance + ", listOfTransactions=" + listOfTransactions + "]";
	}	
	
}

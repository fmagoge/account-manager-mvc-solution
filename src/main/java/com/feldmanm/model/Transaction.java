package com.feldmanm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Transactions")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int code;
	
	@JsonManagedReference
	@ManyToOne
    @JoinColumn(name="account_code")
	private Account account_code;
	
	private String transaction_date;
	private String capture;
	private double amount;
	private String description;
	
	public Transaction() {
		super();
	}

	public Transaction(int code, Account account_code, String transaction_date, String capture, double amount,
			String description) {
		super();
		this.code = code;
		this.account_code = account_code;
		this.transaction_date = transaction_date;
		this.capture = capture;
		this.amount = amount;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Account getAccount_code() {
		return account_code;
	}

	public void setAccount_code(Account account_code) {
		this.account_code = account_code;
	}

	public String getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}

	public String getCapture() {
		return capture;
	}

	public void setCapture(String capture) {
		this.capture = capture;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Transaction [code=" + code + ", account_code=" + account_code + ", transaction_date=" + transaction_date
				+ ", capture=" + capture + ", amount=" + amount + ", description=" + description + "]";
	}
	
}

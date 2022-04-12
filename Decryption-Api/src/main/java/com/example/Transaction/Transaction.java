package com.example.Transaction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transaction {
	
	@Id @GeneratedValue
	private int id;
	private String account_number;
	private String type;
	private String amount;
	private String currency;
	private String accountFrom;
	public Transaction() {
		super();
	}
	public Transaction(int id, String account_number, String type, String amount, String currency, String accountFrom) {
		super();
		this.id = id;
		this.account_number = account_number;
		this.type = type;
		this.amount = amount;
		this.currency = currency;
		this.accountFrom = accountFrom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAccountFrom() {
		return accountFrom;
	}
	public void setAccountFrom(String accountFrom) {
		this.accountFrom = accountFrom;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", account_number=" + account_number + ", type=" + type + ", amount=" + amount
				+ ", currency=" + currency + ", accountFrom=" + accountFrom + "]";
	}
	
	
	

}

package com.example.Transaction;


public class Transaction {
	
	private String account_number;
	private String type;
	private String amount;
	private String currency;
	private String accountFrom;
	public Transaction() {
		super();
	}
	public Transaction(String account_number, String type, String amount, String currency, String accountFrom) {
		super();
		this.account_number = account_number;
		this.type = type;
		this.amount = amount;
		this.currency = currency;
		this.accountFrom = accountFrom;
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
		return "Transaction [account_number=" + account_number + ", type=" + type + ", amount=" + amount + ", currency="
				+ currency + ", accountFrom=" + accountFrom + "]";
	}
	
	

}

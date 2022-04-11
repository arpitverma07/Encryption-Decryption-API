package com.example.Controller;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.Queue;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.AES.AESEncryption;
import com.example.Transaction.Transaction;

@RestController
public class Controller {
	
	private Queue<Transaction> queue = new LinkedList<>();
	
	@Autowired
	private AESEncryption aesEncryption;
	
	@GetMapping("/get-encrypted-transaction")
	public Transaction getDetails() {
		return queue.poll();
	}
	
	@PostMapping("/get-plain-transaction")
	public Transaction getDetails(@RequestBody Transaction transaction) throws InvalidKeyException, 
	NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, BadPaddingException, 
	IllegalBlockSizeException, IOException 
	{
		transaction.setAccount_number(aesEncryption.encrypted(transaction.getAccount_number()));
		transaction.setAccountFrom(aesEncryption.encrypted(transaction.getAccountFrom()));
		transaction.setAmount(aesEncryption.encrypted(transaction.getAmount()));
		transaction.setCurrency(aesEncryption.encrypted(transaction.getCurrency()));
		transaction.setType(aesEncryption.encrypted(transaction.getType()));
		queue.add(transaction);
		return transaction;
	}
}

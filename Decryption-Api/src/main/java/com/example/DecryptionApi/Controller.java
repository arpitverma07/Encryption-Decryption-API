package com.example.DecryptionApi;

import java.io.IOException;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;




@RestController
@ComponentScan("com.example.Controller")
public class Controller {
	
	@Autowired
	private TransRepo transactionRepo;
	
	@Autowired
	private AESDecryption aesDecryption;
	
	@Autowired
	private FeignClientProxy clientProxy;
	
	
	
	@GetMapping("/RestTemplate/save-plain-transaction")
	public Transaction getDetails() throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException, IOException {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl
		  = "http://localhost:8081/get-encrypted-transaction";
		ResponseEntity<Transaction> response
		  = restTemplate.getForEntity(fooResourceUrl, Transaction.class);
		Transaction transaction = response.getBody();
//		System.out.println(transaction);
		transaction.setAccount_number(aesDecryption.decrypted(transaction.getAccount_number()));
		transaction.setAccountFrom(aesDecryption.decrypted(transaction.getAccountFrom()));
		transaction.setAmount(aesDecryption.decrypted(transaction.getAmount()));
		transaction.setCurrency(aesDecryption.decrypted(transaction.getCurrency()));
		transaction.setType(aesDecryption.decrypted(transaction.getType()));
		transactionRepo.save(transaction);
//		System.out.println(transaction);
		return transaction;
		
	}
	
	@GetMapping("/feign-client/save-plain-transaction")
	public Transaction getDetailsFeign() throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException, IOException {
		
		Transaction transaction = clientProxy.retrieveTrans();
//		System.out.println(transaction);
		transaction.setAccount_number(aesDecryption.decrypted(transaction.getAccount_number()));
		transaction.setAccountFrom(aesDecryption.decrypted(transaction.getAccountFrom()));
		transaction.setAmount(aesDecryption.decrypted(transaction.getAmount()));
		transaction.setCurrency(aesDecryption.decrypted(transaction.getCurrency()));
		transaction.setType(aesDecryption.decrypted(transaction.getType()));
		transactionRepo.save(transaction);
//		System.out.println(transaction);
		return transaction;
		
	}

}

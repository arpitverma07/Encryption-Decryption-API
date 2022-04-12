package com.example.Transaction;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "encryption-service")
public interface FeignClientProxy {
	
	@GetMapping("/get-encrypted-transaction")
	public Transaction retrieveTrans();

}

package com.navyug.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/account")
public interface AccountController {
	
	@GetMapping("/withdraw/{accNum}/{amount}")
	public ResponseEntity<String> withdrawAmmount(int accountNumber,double amount);

	@GetMapping("/deposit/{accNum}/{amount}")
	public ResponseEntity<String> depositAmmount(int accountNumber,double amount);

	@GetMapping("/balance/{accNum}")
	public ResponseEntity<String> checkBalance(int accountNumber);

}

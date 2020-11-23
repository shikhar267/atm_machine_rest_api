package com.navyug.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.navyug.service.AccountService;

@RestController
public class AccountControllerImpl implements AccountController {
 
	@Autowired
	AccountService accountService;

	@Override
	public ResponseEntity<String> withdrawAmmount(@PathVariable(value = "accNum") int accountNumber,
			@PathVariable(value = "amount") double amount) {
		try {
			if (amount > 0) {
				return accountService.withdraw(accountNumber, amount);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Ammount should be greater than 0. Please swiper again");
			}
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("something went wrong" + ex.getMessage().toString());
		}

	}

	@Override
	public ResponseEntity<String> depositAmmount(@PathVariable(value = "accNum") int accountNumber,
			@PathVariable(value = "amount") double amount) {
		try {
			if (amount > 0) {
				return accountService.deposit(accountNumber, amount);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Ammount should be greater than 0. Please swiper again");
			}
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("something went wrong" + ex.getMessage().toString());
		}
	}

	@Override
	public ResponseEntity<String> checkBalance(@PathVariable(value = "accNum") int accountNumber) {
		try {
			return accountService.checkBalance(accountNumber);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("something went wrong" + ex.getMessage().toString());
		}
	}

}

package com.navyug.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.navyug.exception.AccountException;
import com.navyug.model.Account;
import com.navyug.repository.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepo accountRepo;

	@Override
	public ResponseEntity<String> withdraw(int accountNumber, double amount) throws AccountException {
		try {
			Optional<Account> accountOp = accountRepo.findById(accountNumber);
			if (accountOp.isPresent()) {
				Account account = accountOp.get();
				double balance = account.getAmmount();
				if (balance >= amount) {
					account.setAmmount(balance - amount);
					accountRepo.save(account);
					return ResponseEntity.status(HttpStatus.OK).body("Cash withdrwal is done please enjoy");
				} else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not enough balance");
				}
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Account is not found. Please swipe again");
			}
		} catch (Exception ex) {
			throw new AccountException(ex.getMessage());
		}
	}

	@Override
	public ResponseEntity<String> deposit(int accountNumber, double amount) throws AccountException {
		try {
			Optional<Account> accountOp = accountRepo.findById(accountNumber);
			if (accountOp.isPresent()) {
				Account account = accountOp.get();
				double balance = account.getAmmount();

				account.setAmmount(balance + amount);
				accountRepo.save(account);
				return ResponseEntity.status(HttpStatus.OK).body("Cash deposit is done please enjoy");

			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Account is not found. Please swipe again");
			}
		} catch (Exception ex) {
			throw new AccountException(ex.getMessage());
		}
	}

	@Override
	public ResponseEntity<String> checkBalance(int accountNumber) throws AccountException {
		try {
			Optional<Account> accountOp = accountRepo.findById(accountNumber);
			if (accountOp.isPresent()) {
				Account account = accountOp.get();
				return ResponseEntity.status(HttpStatus.OK).body("Your balance is::" + account.getAmmount());
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Account is not found. Please swipe again");
			}
		} catch (Exception ex) {
			throw new AccountException(ex.getMessage());

		}

	}
}

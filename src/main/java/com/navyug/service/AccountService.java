package com.navyug.service;

import org.springframework.http.ResponseEntity;

import com.navyug.exception.AccountException;

public interface AccountService {

	ResponseEntity<String> withdraw(int accountNumber, double amount)throws AccountException;

	ResponseEntity<String> deposit(int accountNumber, double amount)throws AccountException;

	ResponseEntity<String> checkBalance(int accountNumber) throws AccountException;

}

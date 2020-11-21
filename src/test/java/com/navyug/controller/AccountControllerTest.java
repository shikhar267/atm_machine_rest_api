package com.navyug.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.navyug.service.AccountService;

public class AccountControllerTest {

	
	@InjectMocks
	AccountController accountController;
	
	@Mock
	AccountService accountService;
	@Test
	public void depositAmmountTest() {
		ResponseEntity<String> ss = accountController.depositAmmount(1, -50);
		//assertEquals(400, ss.getStatusCode());
	}
	
	
}

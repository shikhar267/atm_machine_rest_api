package com.navyug.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.navyug.service.AccountService;
@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {

	
	@InjectMocks
	AccountControllerImpl accountController;
	
	@Mock
	AccountService accountService;

	@Test
	public void depositAmmountTest() {
		ResponseEntity<String> ss = accountController.depositAmmount(1, -50);
		assertEquals(400, ss.getStatusCodeValue());
	}
	
	@Test
	public void withdrawAmmountTest() {
		ResponseEntity<String> ss = accountController.withdrawAmmount(1, -50);
		assertEquals(400, ss.getStatusCodeValue());
	}
	
	
}

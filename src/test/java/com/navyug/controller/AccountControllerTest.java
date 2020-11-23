package com.navyug.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.navyug.exception.AccountException;
import com.navyug.service.AccountService;
@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class)
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
	public void depositAmmountTest2() throws AccountException {
		ResponseEntity<String> entity = new ResponseEntity<>(HttpStatus.OK);
		Mockito.when(accountService.deposit(22, 11)).thenReturn(entity);
		 accountController.depositAmmount(1, 220);
		assertEquals(200, entity.getStatusCodeValue());
	}
	
	
	@Test
	public void withdrawTest() throws AccountException {
		ResponseEntity<String> entity = new ResponseEntity<>(HttpStatus.OK);
		Mockito.when(accountService.withdraw(22, 11)).thenReturn(entity);
		 accountController.withdrawAmmount(1, 220);
		assertEquals(200, entity.getStatusCodeValue());
	}
	
	@Test
	public void withdrawAmmountTest() {
		ResponseEntity<String> ss = accountController.withdrawAmmount(1, -50);
		assertEquals(400, ss.getStatusCodeValue());
	}
	
	
}

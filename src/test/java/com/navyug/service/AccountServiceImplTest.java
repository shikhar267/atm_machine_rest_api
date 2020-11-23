package com.navyug.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.navyug.exception.AccountException;
import com.navyug.model.Account;
import com.navyug.repository.AccountRepo;

@ExtendWith(MockitoExtension.class)
public class AccountServiceImplTest {
	
	@InjectMocks
	AccountServiceImpl accountServiceImpl;
	
	@Mock
	AccountRepo accountRepo;
   
	@Test
	public void withdrawTest() throws AccountException {
		Account account=new Account();
		account.setAmmount(2000.00);
		account.setPin("1223");
		account.setAccountId(1);
		account.setVersion(1l);
		Optional<Account> accountOp=Optional.of(account);
		Mockito.when(accountRepo.findById(Mockito.anyInt())).thenReturn(accountOp);
		ResponseEntity<String> response = accountServiceImpl.withdraw(2, 2000);
		assertEquals(200, response.getStatusCodeValue());
	}
	@Test
	public void withdrawTestElseLowBalance() throws AccountException {
		Account account=new Account();
		account.setAmmount(1000.00);
		account.setPin("1223");
		account.setAccountId(1);
		account.setVersion(1l);
		Optional<Account> accountOp=Optional.of(account);
		
		Mockito.when(accountRepo.findById(Mockito.anyInt())).thenReturn(accountOp);
		ResponseEntity<String> response = accountServiceImpl.withdraw(2, 2000);
		assertEquals(400, response.getStatusCodeValue());
		assertEquals("Not enough balance",response.getBody());
	}
	
	@Test
	public void depositTest() throws AccountException {
		Account account=new Account();
		account.setAmmount(2000.00);
		account.setPin("1223");
		account.setAccountId(1);
		account.setVersion(1l);
		Optional<Account> accountOp=Optional.of(account);
		Mockito.when(accountRepo.findById(Mockito.anyInt())).thenReturn(accountOp);
		ResponseEntity<String> response = accountServiceImpl.deposit(2, 2000);
		assertEquals(200, response.getStatusCodeValue());
	}


	@Test
	public void checkBalance() throws AccountException {
		Account account=new Account();
		account.setAmmount(2000.00);
		account.setPin("1223");
		account.setAccountId(1);
		account.setVersion(1l);
		Optional<Account> accountOp=Optional.of(account);
		Mockito.when(accountRepo.findById(Mockito.anyInt())).thenReturn(accountOp);
		ResponseEntity<String> response = accountServiceImpl.checkBalance(2);
		assertEquals("Your balance is::2000.0", response.getBody());
	}


	
	
	
}

package com.navyug.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.navyug.dto.AccountDto;
import com.navyug.dto.CustomerDetail;
import com.navyug.exception.CustomerException;
import com.navyug.service.CustomerService;
import com.navyug.validation.ValidationUtil;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

	@InjectMocks
	CustomerControllerImpl customerController;
	
	@Mock
	CustomerService customerService;
	
	@Mock
	ValidationUtil validationUtil;

	@Test
	public void createCustomerTest() throws CustomerException {
		CustomerDetail customerDetail = new CustomerDetail();
		List<AccountDto> account = new ArrayList<>();
		AccountDto acc = new AccountDto();
		acc.setAmmount(500.00);
		acc.setPin("1234");
		account.add(acc);
		customerDetail.setAccount(account);
		customerDetail.setAddress("address");
		customerDetail.setContactDetails("86567");
		customerDetail.setFirstName("firstname");
		customerDetail.setLastName("lastname");
		StringBuilder value = new StringBuilder();
		ResponseEntity<Object> ss = new ResponseEntity<>(HttpStatus.OK);
		Mockito.when(customerService.createCustomer(customerDetail)).thenReturn(ss);
		Mockito.when(validationUtil.validateMandatoryFields(customerDetail)).thenReturn(value);
		Mockito.when(validationUtil.validateInputFields(customerDetail)).thenReturn(value);
		customerController.createCustomer(customerDetail);

		assertEquals(200, ss.getStatusCodeValue());
	}
	

	
	
}

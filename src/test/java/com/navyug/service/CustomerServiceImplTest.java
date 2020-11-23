package com.navyug.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.navyug.dto.AccountDto;
import com.navyug.dto.CustomerDetail;
import com.navyug.exception.CustomerException;
import com.navyug.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

	
	@InjectMocks
	CustomerServiceImpl customerServiceImpl;
	
	@Mock
	CustomerRepository customerRepositroy;
   
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
		customerDetail.setAccount(account );
		ResponseEntity<Object> response = customerServiceImpl.createCustomer(customerDetail);
		assertEquals(201, response.getStatusCodeValue());
		
	}
}

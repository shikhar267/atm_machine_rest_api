package com.navyug.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.navyug.dto.CustomerDetail;
import com.navyug.exception.CustomerException;
import com.navyug.model.Account;
import com.navyug.model.Customer;
import com.navyug.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepositroy;

	@Override
	public ResponseEntity<Object> createCustomer(CustomerDetail customerDetail) throws CustomerException {
		
		try {
			Customer customer = convertCustomerToEntity(customerDetail);
			customerRepositroy.save(customer);
			return ResponseEntity.status(HttpStatus.CREATED).body("Added the account");
		} catch (Exception ex) {
			throw new CustomerException(ex.getMessage());
		}
	}

	private Customer convertCustomerToEntity(CustomerDetail customerDetail) {
		Customer customer = new Customer();
		Account account =new Account();
		List<Account> accountList =new ArrayList<>();
		customer.setFirstName(customerDetail.getFirstName());
		customer.setLastName(customerDetail.getLastName());
		customer.setAddress(customerDetail.getAddress());
		customer.setContactDetails(customerDetail.getContactDetails());
		if(null!=customerDetail.getAccount() && customerDetail.getAccount().size() >0) {
			account.setPin(customerDetail.getAccount().get(0).getPin());
			account.setAmmount(customerDetail.getAccount().get(0).getAmmount());
		}
		accountList.add(account);
		customer.setAccount(accountList);
		return customer;

	}

}

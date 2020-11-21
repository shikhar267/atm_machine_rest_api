package com.navyug.service;

import org.springframework.http.ResponseEntity;

import com.navyug.dto.CustomerDetail;
import com.navyug.exception.CustomerException;

public interface CustomerService {

	ResponseEntity<Object> createCustomer(CustomerDetail customerDetail) throws CustomerException;

}

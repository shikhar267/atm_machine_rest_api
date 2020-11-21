package com.navyug.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.navyug.dto.CustomerDetail;

@RequestMapping("/api")
public interface CustomerController {
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Object> createCustomer(@RequestBody CustomerDetail customerDetail);

}

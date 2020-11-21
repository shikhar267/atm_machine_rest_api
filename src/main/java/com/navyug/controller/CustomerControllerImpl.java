package com.navyug.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.navyug.dto.CustomerDetail;
import com.navyug.service.CustomerService;
import com.navyug.validation.ValidationUtil;

@RestController
public class CustomerControllerImpl implements CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	ValidationUtil validationUtil;

	@Override
	public ResponseEntity<Object> createCustomer(@RequestBody CustomerDetail customerDetail) {
		try {
			StringBuilder mandatoryVal = validationUtil.validateMandatoryFields(customerDetail);
			if (mandatoryVal.length() == 0) {
				StringBuilder inputValidation = validationUtil.validateInputFields(customerDetail);
				if (inputValidation.length() == 0) {
					return customerService.createCustomer(customerDetail);

				} else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body("Please check the inputs {} ::" + inputValidation.toString());
				}

			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Missing mandatory fields {} ::" + mandatoryVal.toString());
			}
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Something went wrong {} ::" + ex.getMessage().toString());

		}
	}
}

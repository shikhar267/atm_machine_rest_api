package com.navyug.validation;

import java.util.List;

import org.springframework.stereotype.Component;

import com.navyug.dto.AccountDto;
import com.navyug.dto.CustomerDetail;

@Component
public class ValidationUtil {

	public StringBuilder validateMandatoryFields(CustomerDetail customerDetail) {
		StringBuilder sb =new StringBuilder();
	
		if(null==customerDetail.getAddress()) {
		sb.append("address,");
		} if(null== customerDetail.getFirstName()) {
			sb.append("first Name,");
		} if(null==customerDetail.getLastName()) {
			System.out.println("ss");
			sb.append("Last Name,");
		} if(null==customerDetail.getContactDetails()) {
			sb.append("contact detail,");
		} if(null==customerDetail.getAccount()) {
			sb.append("add account detail,");
		}else {
			   List<AccountDto> account = customerDetail.getAccount();
				for (AccountDto accountDto : account) {
					if(accountDto.getPin()==null) {
						sb.append("set pin");
					}
				}
			}
		
		return sb;
		
	}
	public StringBuilder validateInputFields(CustomerDetail customerDetail) {
		  StringBuilder sb =new StringBuilder();
		  if(customerDetail.getAddress().length()>30 || customerDetail.getAddress().length()<1) {
				sb.append("address should be between 1 to 30");
		  }
		   if(customerDetail.getFirstName().length()>10 || customerDetail.getFirstName().length()<1) {
				sb.append("first name should be between 1 to 10");
		  }else {
			  List<AccountDto> account = customerDetail.getAccount();
			  for (AccountDto accountDto : account) {
				if(accountDto.getPin().length()<=3 || accountDto.getPin().length()>=5) {
					sb.append("pin should be of 4 digit");
				}
			}
		  }
		return sb;
	}
		


}

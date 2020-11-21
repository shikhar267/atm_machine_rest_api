package com.navyug.dto;

import java.util.List;

public class CustomerDetail {
	private String firstName;
	private String lastName;
	private String address;
	private String ContactDetails;
	List<AccountDto> account;
	
	
	public List<AccountDto> getAccount() {
		return account;
	}
	public void setAccount(List<AccountDto> account) {
		this.account = account;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactDetails() {
		return ContactDetails;
	}
	public void setContactDetails(String contactDetails) {
		ContactDetails = contactDetails;
	}
	


}

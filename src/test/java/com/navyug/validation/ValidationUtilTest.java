package com.navyug.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.navyug.dto.AccountDto;
import com.navyug.dto.CustomerDetail;

@ExtendWith(MockitoExtension.class)
public class ValidationUtilTest {

	@InjectMocks
	ValidationUtil validationUtil;
	
	@Test
	public void validateMandatoryFieldsTest() {
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
	//	customerDetail.setAccount(account );
		StringBuilder sb=validationUtil.validateMandatoryFields(customerDetail);
//		assertEquals(0, sb.length()==0);
	}
	
	@Test
	public void validateMandatoryFieldsTest2() {
		CustomerDetail customerDetail = new CustomerDetail();
		List<AccountDto> account = new ArrayList<>();
		AccountDto acc = new AccountDto();
		acc.setAmmount(500.00);
		acc.setPin("1234");
		account.add(acc);
		//customerDetail.setAccount(null);
		customerDetail.setAddress(null);
		customerDetail.setContactDetails(null);
		customerDetail.setFirstName(null);
		customerDetail.setLastName(null);
		customerDetail.setAccount(account );
		StringBuilder sb=validationUtil.validateMandatoryFields(customerDetail);
		assertEquals(true, sb.length()>0);
	}
	@Test
	public void validateMandatoryFieldsTest3() {
		CustomerDetail customerDetail = new CustomerDetail();
		List<AccountDto> account = new ArrayList<>();
		AccountDto acc = new AccountDto();
		acc.setAmmount(500.00);
		acc.setPin("1234");
		account.add(acc);
		customerDetail.setAccount(null);
		customerDetail.setAddress(null);
		customerDetail.setContactDetails(null);
		customerDetail.setFirstName(null);
		customerDetail.setLastName(null);
	//	customerDetail.setAccount(account );
		StringBuilder sb=validationUtil.validateMandatoryFields(customerDetail);
		assertEquals(true, sb.length()>0);
	}
	
	@Test
	public void validateMandatoryFieldsTest4() {
		CustomerDetail customerDetail = new CustomerDetail();
		List<AccountDto> account = new ArrayList<>();
		AccountDto acc = new AccountDto();
		acc.setAmmount(500.00);
		acc.setPin(null);
		account.add(acc);
		customerDetail.setAccount(account);
		customerDetail.setAddress("address");
		customerDetail.setContactDetails("86567");
		customerDetail.setFirstName("firstname");
		customerDetail.setLastName("lastname");
		StringBuilder sb=validationUtil.validateMandatoryFields(customerDetail);
		assertEquals("set pin", sb.toString());
	}
	
	
	@Test
	public void validateInputFieldsTest() {
		CustomerDetail customerDetail = new CustomerDetail();
		List<AccountDto> account = new ArrayList<>();
		AccountDto acc = new AccountDto();
		acc.setAmmount(500.00);
		acc.setPin("1234");
		account.add(acc);
		customerDetail.setAccount(account);
		customerDetail.setAddress("12345678901234567890123456789011");
		customerDetail.setContactDetails("86567");
		customerDetail.setFirstName("firstname");
		customerDetail.setLastName("lastname");
		StringBuilder sb=validationUtil.validateInputFields(customerDetail);
		assertEquals("address should be between 1 to 30", sb.toString());
	}
	
	@Test
	public void validateInputFieldsTest1() {
		CustomerDetail customerDetail = new CustomerDetail();
		List<AccountDto> account = new ArrayList<>();
		AccountDto acc = new AccountDto();
		acc.setAmmount(500.00);
		acc.setPin("1234");
		account.add(acc);
		customerDetail.setAccount(account);
		customerDetail.setAddress("12345678456789011");
		customerDetail.setContactDetails("86567");
		customerDetail.setFirstName("firstnam111111e");
		customerDetail.setLastName("lastname");
		StringBuilder sb=validationUtil.validateInputFields(customerDetail);
		assertEquals("first name should be between 1 to 10", sb.toString());
	}
	
	@Test
	public void validateInputFields3() {
		CustomerDetail customerDetail = new CustomerDetail();
		List<AccountDto> account = new ArrayList<>();
		AccountDto acc = new AccountDto();
		acc.setAmmount(500.00);
		acc.setPin("34");
		account.add(acc);
		customerDetail.setAccount(account);
		customerDetail.setAddress("1234569011");
		customerDetail.setContactDetails("86567");
		customerDetail.setFirstName("fam11111e");
		customerDetail.setLastName("lastname");
		StringBuilder sb=validationUtil.validateInputFields(customerDetail);
		assertEquals("pin should be of 4 digit", sb.toString());
	}
}

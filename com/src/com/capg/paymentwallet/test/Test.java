package com.capg.paymentwallet.test;

import org.junit.BeforeClass;

public class Test {
	@BeforeClass
	public static void createInstance(){
		IAccountService service = new AccountServiceImpl();
	}
	public void testCreateAccountPositive() throws PaytmException {
		Customer customer = new Customer();
		customer.setFirstName("aditi");
		customer.setLastName("kathare");
		customer.setPhnNo("8121198399");
		customer.setMail("aditikathare@gmail.com");
		customer.setPin(1234);
		boolean res = service.validate(customer);
		assertTrue(res);
	}

	@org.junit.Test(expected = CustomerException.class)
	public void testCreateAccountForFirstNameLength() throws PaytmException {
		Customer customer = new Customer();
		customer.setFirstName("ad");
		customer.setLastName("kathare");
		customer.setPhnNo(9059900989l);

		customer.setMail("aditikathare@gmail.com");
		customer.setPin(1234);
		service.validate(customer);
	}

	@org.junit.Test(expected = CustomerException.class)
	public void testCreateAccountForLastNameLength() throws PaytmException {
		Customer customer = new Customer();
		customer.setFirstName("aditi");
		customer.setLastName("ka");
		customer.setPhnNo(9059900989l);
		customer.setAdharNo(355960351676l);
		customer.setMail("aditikathare@gmail.com");
		customer.setPin(1234);
		service.validate(customer);
	}

	@org.junit.Test(expected = CustomerException.class)
	public void testCreateAccountLastNameFornumbers() throws PaytmException {
		Customer customer = new Customer();
		customer.setFirstName("aditi");
		customer.setLastName("kath123re");
		customer.setPhnNo(9059900989l);
		customer.setAdharNo(355960351676l);
		customer.setMail("aditikathare@gmail..com");
		customer.setPin(1234);
		service.validate(customer);
	}

	@org.junit.Test(expected = PaytmException.class)
	public void testCreateAccountForFirstNameFornumbers() throws PaytmException {
		Customer customer = new Customer();
		customer.setFirstName("rohi123ni");
		customer.setLastName("thunuguntla");
		customer.setPhnNo(9059900989l);
		customer.setAdharNo(355960351676l);
		customer.setMail("rohini6rani@gmail.com");
		customer.setPin(1234);
		service.validate(customer);
	}

	@org.junit.Test(expected = PaytmException.class)
	public void testCreateAccountForPhnNoLength() throws PaytmException {
		Customer customer = new Customer();
		customer.setFirstName("rohini");
		customer.setLastName("thunuguntla");
		customer.setPhnNo(90599009l);
		customer.setAdharNo(355960351676l);
		customer.setMail("rohini6rani@gmail.com");
		customer.setPin(1234);
		service.validate(customer);
	}

	@org.junit.Test(expected = PaytmException.class)
	public void testCreateAccountForAdharNolength() throws PaytmException {
		Customer customer = new Customer();
		customer.setFirstName("rohini");
		customer.setLastName("thunuguntla");
		customer.setPhnNo(9059900989l);
		customer.setAdharNo(3559603516l);
		customer.setMail("rohini6rani@gmail.com");
		customer.setPin(1234);
		service.validate(customer);
	}

	@org.junit.Test(expected = PaytmException.class)
	public void testCreateAccountForEmail() throws PaytmException {
		Customer customer = new Customer();
		customer.setFirstName("rohini");
		customer.setLastName("thunuguntla");
		customer.setPhnNo(9059900989l);
		customer.setAdharNo(355960351676l);
		customer.setMail("rohini6ranigmail.com");
		customer.setPin(1234);
		service.validate(customer);
	}

	@org.junit.Test(expected = PaytmException.class)
	public void testCreateAccountForEmailForLength() throws PaytmException {
		Customer customer = new Customer();
		customer.setFirstName("rohini");
		customer.setLastName("thunuguntla");
		customer.setPhnNo(9059900989l);
		customer.setAdharNo(355960351676l);
		customer.setMail("rohin@gmail.com");
		customer.setPin(1234);
		service.validate(customer);
	}

	@org.junit.Test(expected = PaytmException.class)
	public void testCreateAccountForEmailForMailLength() throws PaytmException {
		Customer customer = new Customer();
		customer.setFirstName("rohini");
		customer.setLastName("thunuguntla");
		customer.setPhnNo(9059900989l);
		customer.setAdharNo(355960351676l);
		customer.setMail("rohini@gil.com");
		customer.setPin(1234);
		service.validate(customer);
	}

	@org.junit.Test(expected = PaytmException.class)
	public void testCreateAccountForEmailForDotcom() throws PaytmException {
		Customer customer = new Customer();
		customer.setFirstName("rohini");
		customer.setLastName("thunuguntla");
		customer.setPhnNo(9059900989l);
		customer.setAdharNo(355960351676l);
		customer.setMail("rohini@gmail");
		customer.setPin(1234);
		service.validate(customer);
	}

	@org.junit.Test
	public void testDeposit() {
		double amount = 100;
		boolean res=service.deposit(amount);
		assertTrue(res);
	}

	@org.junit.Test
	public void testDepositForNegative() {
		double amount =-100;
		service.deposit(amount);
		
	}
	@org.junit.Test
	public void testWithdraw() {
		double amount = 100;
		boolean res=service.withDraw(amount);
		assertTrue(res);
	}

	@org.junit.Test
	public void testWithDrawForNegative() {
		double amount =-100;
		service.withDraw(amount);
		
	}
	
	@org.junit.Test
	public void testfundstransfer() throws PaytmException {
		double amount = 100;
		Long transphnNo=9247144559l;
		boolean res=service.fundTransfer(amount, transphnNo);
		assertTrue(res);
	}


		
	}
	
}


package csc131.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals; 
 
import org.junit.rules.ExpectedException; 
import org.junit.Test; 


class GiftCardTest {

	@Test
	public void getIssuingStore()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getIssuingStore()", issuingStore, card.getIssuingStore());
	}

	@Test
	public void getBalance()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getBalance()", balance, card.getBalance(), 0.001);
	}
	
	@Test
	public void deduct_RemainingBalance()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		String expected;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		expected = "Remaining Balance: " + String.format("%6.2f", 90.00);
		assertEquals("deduct(10.00)", expected, card.deduct(10.0));
		
	}
	
	@Test
	public void deduct_InvalidTransaction()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		String expected;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		expected = "Invalid Transaction";
		assertEquals("deduct 10.00", expected, card.deduct(-10.0));
	}
	
	@Test
	public void deduct_AmountDue()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		String expected;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		expected = "Amount Due: " + String.format("%6.2f", 10.00);
		assertEquals("deduct 110.00", expected, card.deduct(110.0));
	}
	
	
	@Test
	public void constructor_IncorrectBallance()
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});
	}
	
	
	@Test
	public void constructor_IncorrectID_Low() 
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-1,100.00);});
	}
	
	@Test
	public void constructor_IncorrectID_High() 
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(100000,100.00);});
	}
	
}

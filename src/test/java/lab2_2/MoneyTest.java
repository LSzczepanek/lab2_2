package lab2_2;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MoneyTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testMoneyHaveProperFormat(){
		Money mon = new Money(10, "USD");
		
		assertThat(mon.toString(), is(equalTo("10,00 USD")));
	}
	
	@Test
	public void testIsMultiplayWorkingGood(){
		Money moneyA = new Money (20, "EUR");
		Money result = moneyA.multiplyBy(5.0);
		
		assertThat(result.toString(), is(equalTo("100,00 EUR")));
	}
	
	@Test
	public void testIsMultiplayWorkingWithTypicalDoubleValue(){
		Money moneyA = new Money (20.50, "EUR");
		Money result = moneyA.multiplyBy(4.0);
		
		assertThat(result.toString(), is(equalTo("82,00 EUR")));
	}
	
	@Test
	public void testAddMoney(){
		Money a = new Money(50.00, "USD");
		Money b = new Money(30.00, "USD");
		
		Money result = a.add(b);
	
		assertThat(result.toString(), is(equalTo("80,00 USD")));
	}
	
	 
	@Test
	public void throwsExceptionWhenNegativeNumbersAreGiven() {
		Money a = new Money(40.00, "USD");
		Money b = new Money(20.00, "EUR");
	    // arrange
	    thrown.expect(IllegalArgumentException.class);
	    thrown.expectMessage(equalTo("Currency mismatch"));
	    // act
	    a.add(b);
	}

}

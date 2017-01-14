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
	public void testNegativeMoneyHaveProperFormat(){
		Money mon = new Money(-10, "USD");
		
		assertThat(mon.toString(), is(equalTo("-10,00 USD")));
	}
	
	@Test
	public void testDefaultCurrency(){
		Money mon = new Money(1000);
		
		assertThat(mon.toString(), is(equalTo("1000,00 EUR")));
	}
	
	@Test
	public void testRoundingUpCurrency(){
		Money mon = new Money(20.006, "USD");
		
		assertThat(mon.toString(), is(equalTo("20,01 USD")));
	}
	
	@Test
	public void testRoundingDownCurrency(){
		Money mon = new Money(20.005, "USD");
		
		assertThat(mon.toString(), is(equalTo("20,00 USD")));
	}
	
	@Test
	public void testRoundingUpNegativeCurrency(){
		Money mon = new Money(-20.005, "USD");
		
		assertThat(mon.toString(), is(equalTo("-20,00 USD")));
	}
	
	@Test
	public void testRoundingDownNegativeCurrency(){
		Money mon = new Money(-20.006, "USD");
		
		assertThat(mon.toString(), is(equalTo("-20,01 USD")));
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
	public void testThrowsExceptionWhenDiffCurrencyAreGiven() {
		Money a = new Money(40.00, "USD");
		Money b = new Money(20.00, "EUR");
	    // arrange
	    thrown.expect(IllegalArgumentException.class);
	    thrown.expectMessage(equalTo("Currency mismatch"));
	    // act
	    a.add(b);
	}
	
	@Test 
	public void testSubstractMoney(){
		Money a = new Money(50.00, "USD");
		Money b = new Money(30.00, "USD");
		
		Money result = a.subtract(b);
	
		assertThat(result.toString(), is(equalTo("20,00 USD")));
	}
	
	@Test
	public void testSubstractWhenDiffCurrencyAreGiven(){
		Money a = new Money(40.00, "USD");
		Money b = new Money(20.00, "EUR");

	    thrown.expect(IllegalArgumentException.class);
	    thrown.expectMessage(equalTo("Currency mismatch"));
	    
	    a.subtract(b);
	}
	
	@Test 
	public void testSubstractMoneyWhenSubstrahendIsHigher(){
		Money a = new Money(30.00, "USD");
		Money b = new Money(50.00, "USD");
		
		Money result = a.subtract(b);
	
		assertThat(result.toString(), is(equalTo("-20,00 USD")));
	}
	

}

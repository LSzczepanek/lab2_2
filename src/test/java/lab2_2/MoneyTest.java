package lab2_2;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MoneyTest {
	
	
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

}

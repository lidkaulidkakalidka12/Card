package Card;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CreditCardTest {
    private Card creditCard;
    private static final BigDecimal money = new BigDecimal("42.0");
    private static final BigDecimal money1 = new BigDecimal("82.0");

    @Before
    public void setUp() throws Exception {
        creditCard = new CreditCard("Lida", new BigDecimal("62.0"));
    }
    @After
    public void tearDown() throws Exception {
        creditCard = null;
    }
    @Test
    public void testSubtractBalance() {
        creditCard.subtractBalance(money);
        BigDecimal actual = creditCard.getBalance();
        BigDecimal expected = new BigDecimal("20.0");
        assertEquals(actual, expected);
    }
    @Test
    public void testSubtractBalanceMoneyMoreThanBalance() {
        creditCard.subtractBalance(money1);
        BigDecimal actual = creditCard.getBalance();
        BigDecimal expected = new BigDecimal("-20.0");
        assertEquals(actual, expected);
    }
}

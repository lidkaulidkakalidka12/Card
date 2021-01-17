package Card;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DebitCardTest {
    private Card debitCard;
    private static final BigDecimal money = new BigDecimal("42.0");
    private static final BigDecimal money1 = new BigDecimal("82.0");
    private static final BigDecimal converter = new BigDecimal("2.5");

    @Before
    public void setUp() throws Exception {
        debitCard = new DebitCard("Lida", new BigDecimal("62.0"));
    }

    @After
    public void tearDown() throws Exception {
        debitCard = null;
    }

    @Test
    public void testSubtractBalance() {
        debitCard.subtractBalance(money);
        BigDecimal actual = debitCard.getBalance();
        BigDecimal expected = new BigDecimal("20.0");
        assertEquals(actual, expected);
    }

    @Test (expected = InvalidDateException.class)
    public void testSubtractBalanceMoneyMoreThanBalance() {
        debitCard.subtractBalance(money1);

    }

    @Test
    public void testAddBalance() {
        debitCard.addBalance(money);
        BigDecimal actual = debitCard.getBalance();
        BigDecimal expected = new BigDecimal("104.0");
        assertEquals(actual, expected);

    }

    @Test
    public void testConvertBalance() {
        BigDecimal actual = debitCard.convertBalance(converter);
        BigDecimal expected = new BigDecimal("24.80000");
        assertEquals(actual, expected);
    }
}

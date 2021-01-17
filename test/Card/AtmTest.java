package Card;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AtmTest {
    private Atm atm;
    private Card card;
    private Card card2;
    private static final BigDecimal money = new BigDecimal("24.0");
    private static final BigDecimal money2 = new BigDecimal("82.0");

    @Before
    public void setUp() throws Exception {
        card = new CreditCard("Lida", new BigDecimal("62.0"));
        card2 = new DebitCard("Lida", new BigDecimal("42.0"));
        atm = new Atm(card);
    }
    @After
    public void tearDown() throws Exception {
        atm = null;
    }
    @Test
    public void testGetBalanceCard() {
        BigDecimal actual = atm.getBalanceCard();
        BigDecimal expected = new BigDecimal("62.0");
        assertEquals(actual, expected);
    }

    @Test
    public void testAddBalance() {
        atm.addBalance(money);
        BigDecimal actual = atm.getBalanceCard();
        BigDecimal expected = new BigDecimal("86.0");
        assertEquals(actual, expected);
    }

    @Test
    public void testSubtractBalanceCreditCard() {
        atm.subtractBalance(money);
        BigDecimal actual = atm.getBalanceCard();
        BigDecimal expected = new BigDecimal("38.0");
        assertEquals(actual, expected);
    }

    @Test
    public void testSubtractBalanceCreditCardMoneyMoreThanBalance() {
        atm.subtractBalance(money2);
        BigDecimal actual = atm.getBalanceCard();
        BigDecimal expected = new BigDecimal("-20.0");
        assertEquals(actual, expected);
    }

    @Test
    public void testSubtractBalanceDebitCard() {
        atm.setCard(card2);
        atm.subtractBalance(money);
        BigDecimal actual = atm.getBalanceCard();
        BigDecimal expected = new BigDecimal("18.0");
        assertEquals(actual, expected);
    }

    @Test
    public void testSubtractBalanceDebitCardMoneyMoreThanBalance() {
        atm.setCard(card2);
        atm.subtractBalance(money2);
        BigDecimal actual = atm.getBalanceCard();
        BigDecimal expected = new BigDecimal("42.0");
        assertEquals(actual, expected);
    }
}

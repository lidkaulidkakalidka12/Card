import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<Card> cards = new ArrayList<>();
        cards.add(new CreditCard("Ihor", new BigDecimal("1234.45")));
        cards.add(new CreditCard("Ihor"));
        cards.add(new DebitCard("Lida", new BigDecimal("4111.45")));
        cards.add(new DebitCard("Lida"));
        Card creditCardWithMoney = new CreditCard("Ihor", new BigDecimal("1234.45"));
        Card creditCard = new CreditCard("Ihor");
        Card debitCardWithMoney = new DebitCard("Lida", new BigDecimal("1234.45"));
        Card debitCard = new DebitCard("Lida");


        cards.forEach(System.out::println);

        Atm atm = new Atm(creditCardWithMoney);
        Atm atm2 = new Atm(debitCardWithMoney);
        Atm atm3 = new Atm(null);

        System.out.println(atm2.subtractBalance(new BigDecimal("456456")));
        System.out.println(atm2.addBalance(new BigDecimal("456456")));

        System.out.println(atm.subtractBalance(new BigDecimal("456456")));
        System.out.println(atm3.subtractBalance(new BigDecimal("456456")));

    }
}

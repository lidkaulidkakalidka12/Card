package Card;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public abstract class Card {
    protected String name;
    protected BigDecimal balance;

    public Card(String name) {
        this.name = name;
    }
    public Card(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }
    public BigDecimal getBalance() {
        return balance;
    }

    public void addBalance(BigDecimal money) {
        balance = balance.add(money);
    }
    public abstract void subtractBalance(BigDecimal money);

    public void getNameAndBalance(String name, BigDecimal balance) {
        System.out.println(name + "\n" + balance);
    }
    public BigDecimal convertBalance(BigDecimal converter) {
        return balance.divide(converter, 5, RoundingMode.DOWN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(name, card.name) &&
                Objects.equals(balance, card.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, balance);
    }
}


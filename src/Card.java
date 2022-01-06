import java.math.BigDecimal;
import java.util.Objects;

public abstract class Card {

    protected String name;
    protected BigDecimal balance;

    public Card(String name) {
        this.balance = BigDecimal.ZERO;
        this.name = name;
    }

    public Card(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal addBalance(BigDecimal money) {
        return balance.add(money);
    }

    public abstract BigDecimal subtractBalance(BigDecimal money) throws InsufficientFundsException;

    public BigDecimal converterBalance(BigDecimal conversionRate) {
        return balance.multiply(conversionRate);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(name, card.name) && Objects.equals(balance, card.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, balance);
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}

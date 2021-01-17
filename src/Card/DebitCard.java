package Card;

import java.math.BigDecimal;

public class DebitCard extends Card{

    public DebitCard(String name) {
        super(name);
    }

    public DebitCard(String name, BigDecimal balance) {
        super(name, balance);
    }

    @Override
    public void subtractBalance(BigDecimal money) {
        if (balance.compareTo(money) >= 0) {
            balance = balance.subtract(money);
        } else {
            throw new InvalidDateException("You don't have enough funds");
        }
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}


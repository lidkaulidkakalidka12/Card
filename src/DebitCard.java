import java.math.BigDecimal;

public class DebitCard extends Card {

    public DebitCard(String name) {
        super(name);
    }

    public DebitCard(String name, BigDecimal balance) {
        super(name, balance);
    }

    @Override
    public BigDecimal subtractBalance(BigDecimal money) throws InsufficientFundsException {
        if (balance.compareTo(money) >= 0) {
            return balance.subtract(money);
        } else {
            throw new InsufficientFundsException("У вас не достаточно средств");
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

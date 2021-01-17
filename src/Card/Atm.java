package Card;

import java.math.BigDecimal;
import java.util.Objects;

public class Atm {
    private Card card;

    public Atm(Card card) {
        validateInputDade(card);
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public BigDecimal getBalanceCard() {
        return card.getBalance();
    }

    public void addBalance(BigDecimal money) {
        card.addBalance(money);
    }

    public void subtractBalance(BigDecimal money) {
        card.subtractBalance(money);
    }

    private void validateInputDade (Card card) {
        if (card == null) {
            throw new InvalidDateException("");
        }
        if (card.getName().isEmpty()) {
            throw new InvalidDateException("Card name not initialized");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atm atm = (Atm) o;
        return Objects.equals(card, atm.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(card);
    }

    @Override
    public String toString() {
        return "Atm{" +
                "card=" + card +
                '}';
    }
}


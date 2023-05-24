package mk.ukim.finki.emt.sharedkernel.domain.financial;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;


@Embeddable
@Getter
public class Money implements ValueObject {

    @Enumerated(value = EnumType.STRING)
    private final Currency currency;

    private final double amount;

    protected Money() {
        this.currency = null;
        this.amount = 0;
    }

    public Money(@NonNull Currency currency, @NonNull double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    // Factory method - креирање на нов објект
    public static Money valueOf(Currency currency, double amount) {
        return new Money(currency, amount);
    }

    // Додавање на парична вредност
    public Money add(Money money) {
        if (!currency.equals(money.currency)) {
            throw new IllegalArgumentException("Cannot add different currencies");
        }
        return new Money(currency, amount + money.amount);
    }

    // Одземање на парична вредност
    public Money subtract(Money money) {
        if (!currency.equals(money.currency)) {
            throw new IllegalArgumentException("Cannot subtract different currencies");
        }
        return new Money(currency, amount - money.amount);
    }

    // Множење на парична вредност
    public Money multiply(int m) {
        return new Money(currency, amount * m);
    }


}

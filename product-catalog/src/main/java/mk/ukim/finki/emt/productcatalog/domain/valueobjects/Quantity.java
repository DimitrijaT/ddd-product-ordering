package mk.ukim.finki.emt.productcatalog.domain.valueobjects;

import jakarta.persistence.Embeddable;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
public class Quantity implements ValueObject {
    private final int quantity;

    protected Quantity() {
        this.quantity = 0;
    }
}




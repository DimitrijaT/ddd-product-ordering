package mk.ukim.finki.emt.ordermanagement.domain.model;


import jakarta.persistence.*;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends AbstractEntity<OrderId> {

    private Instant orderedOn; //Instant is a class that represents a moment in time in the UTC time zone

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    private Money total; //We will use total to model a business invariant - business logic

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<OrderItem> orderItemList;

    public Order() {

    }

}

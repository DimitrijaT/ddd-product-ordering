package mk.ukim.finki.emt.productcatalog.domain.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import mk.ukim.finki.emt.productcatalog.domain.valueobjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;


@Entity
public class Product extends AbstractEntity<ProductId> {
    private String productName;


    //Quantity нема да ни треба во овој проект.
    //private Quantity quantity;

    private int sales;

    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "price_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "price_currency"))
    })
    private Money price;

    public Product() {
        super(ProductId.randomId(ProductId.class));
    }

    //Builder method на оваа класа.
    public static Product build(String productName, Money price, int sales) {
        Product p = new Product();
        p.price = price;
        p.productName = productName;
        p.sales = sales;
        return p;
    }


    //Ќе ни треба подоцна за комуникација меѓу OrderItem-от и Product-от
    //Кога ќе се избрише ставка да му биде кажено на Product-от да ја намали ставката
    //Ќе имаме некој eventListener.
    public void addSales(int qty) {
//        this.sales = this.sales - qty;
        this.sales += qty;
    }

    public void removeSales(int qty) {
        this.sales -= qty; // Нарачал корисникот а се откажал од истите.
    }
}



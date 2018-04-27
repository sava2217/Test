package com.store.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ClothesInCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private Clothes clothes;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private ShoppingCart shoppingCart;

    private BigDecimal totalPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "ClothesInCard{" +
                "id=" + id +
                ", clothes=" + clothes +
                ", quantity=" + quantity +
                '}';
    }
}
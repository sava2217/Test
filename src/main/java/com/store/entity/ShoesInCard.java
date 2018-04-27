package com.store.entity;

import javax.persistence.*;

@Entity
public class ShoesInCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private Shoes shoes;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private ShoppingCart shoppingCart;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Shoes getClothes() {
        return shoes;
    }

    public void setShoes(Shoes shoes) {
        this.shoes = shoes;
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

    @Override
    public String toString() {
        return "ShoesInCard{" +
                "id=" + id +
                ", shoes=" + shoes +
                ", quantity=" + quantity +
                '}';
    }
}
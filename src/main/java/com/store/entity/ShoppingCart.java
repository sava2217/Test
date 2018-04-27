package com.store.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "shoppingCart")
    private List<User> userList = new ArrayList<>();


    @OneToMany(mappedBy = "shoppingCart", fetch = FetchType.LAZY)
    private List<ClothesInCard> clothesInCards = new ArrayList<>();

    @OneToMany(mappedBy = "shoppingCart", fetch = FetchType.LAZY)
    private List<ShoesInCard> shoesInCards = new ArrayList<>();

    private BigDecimal totalPrice;

    public ShoppingCart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }


    public List<ClothesInCard> getClothesInCards() {
        return clothesInCards;
    }

    public void setClothesInCards(List<ClothesInCard> clothesInCards) {
        this.clothesInCards = clothesInCards;
    }

    public List<ShoesInCard> getShoesInCards() {
        return shoesInCards;
    }

    public void setShoesInCards(List<ShoesInCard> shoesInCards) {
        this.shoesInCards = shoesInCards;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
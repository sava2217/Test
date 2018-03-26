package com.store.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class Accessories extends AbstractEntity{
    private BigDecimal price;

    @ManyToOne(fetch=FetchType.LAZY)
    private Brand brand;
    @ManyToOne(fetch = FetchType.LAZY)
    private Color color;

    private Accessories(){

    }
 public Accessories(BigDecimal price, Brand brand, Color color) {
    this.price = price;
    this.brand = brand;
    this.color = color;
}

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}



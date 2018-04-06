package com.store.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
@Entity
public class Shoes extends AbstractEntity {

    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Color color;
    @ManyToOne(fetch = FetchType.LAZY)
    private  Brand brand;
    @ManyToOne(fetch = FetchType.LAZY)
    private Gender gender;
    @ManyToOne(fetch = FetchType.LAZY)
    private  Season season;
    @ManyToOne(fetch = FetchType.LAZY)
    private ShoesMaterial shoesMaterial;
    @ManyToOne(fetch = FetchType.LAZY)
    private ShoesSize shoesSize;

    public Shoes() {

    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public ShoesMaterial getShoesMaterial() {
        return shoesMaterial;
    }

    public void setShoesMaterial(ShoesMaterial shoesMaterial) {
        this.shoesMaterial = shoesMaterial;
    }

    public ShoesSize getShoesSize() {
        return shoesSize;
    }

    public void setShoesSize(ShoesSize shoesSize) {
        this.shoesSize = shoesSize;
    }
}
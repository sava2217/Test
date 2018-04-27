package com.store.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Shoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    private Color color;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    private Gender gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    private Season season;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    private ShoesMaterial shoesMaterial;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    private ShoesSize shoesSize;

    private String description;
    private BigDecimal price;
    private String path;
    public Shoes() {
    }


    public Shoes(Long id, Color color, Brand brand, Gender gender, Season season, ShoesMaterial shoesMaterial, ShoesSize shoesSize, String description, BigDecimal price, String path) {
        this.id = id;
        this.color = color;
        this.brand = brand;
        this.gender = gender;
        this.season = season;
        this.shoesMaterial = shoesMaterial;
        this.shoesSize = shoesSize;
        this.description = description;
        this.price = price;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    @Override
    public String toString() {
        return "Furniture{" +
                "id=" + id +
                ", color=" + color +
                ", brand=" + brand +
                ", gender=" + gender +
                ", season=" + season +
                ", shoesMaterial=" + shoesMaterial +
                ", shoesSize" + shoesSize +
                ", path='" + path + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

}

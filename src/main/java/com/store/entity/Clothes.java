
package com.store.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Clothes {

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
    private ClothesMaterial clothesMaterial;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    private ClothesSize clothesSize;

    private String path;

    private String description;

    private BigDecimal price;

    public ClothesMaterial getClothesMaterial() {
        return clothesMaterial;
    }

    public void setClothesMaterial(ClothesMaterial clothesMaterial) {
        this.clothesMaterial = clothesMaterial;
    }

    public Clothes(Long id, Color color, Brand brand, Gender gender, Season season, ClothesMaterial clothesMaterial, ClothesSize clothesSize, String path, String description, BigDecimal price) {
        this.id = id;
        this.color = color;
        this.brand = brand;
        this.gender = gender;
        this.season = season;
        this.clothesMaterial = clothesMaterial;
        this.clothesSize = clothesSize;
        this.path = path;
        this.description = description;
        this.price = price;
    }

    public Clothes() {


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public ClothesSize getClothesSize() {
        return clothesSize;
    }

    public void setClothesSize(ClothesSize clothesSize) {
        this.clothesSize = clothesSize;
    }
    @Override
    public String toString() {
        return "Furniture{" +
                "id=" + id +
                ", color=" + color +
                ", brand=" + brand +
                ", gender=" + gender +
                ", season=" + season +
                ", clothesMaterial=" + clothesMaterial +
                ", clothesSize" + clothesSize +
                ", path='" + path + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
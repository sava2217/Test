package com.store.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Clothes> clothes = new ArrayList<>();

    public Brand() {
    }

    public Brand(String name, List<Clothes> clothes) {
        this.name = name;
        this.clothes = clothes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Clothes> getClothes() {
        return clothes;
    }

    public void setClothes(List<Clothes> clothes) {
        this.clothes = clothes;
    }
    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
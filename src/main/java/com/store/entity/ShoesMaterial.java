package com.store.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoesMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "shoesMaterial")
    private List<Shoes> shoes = new ArrayList<>();

    public ShoesMaterial() {
    }

    public ShoesMaterial(String name, List<Shoes> shoes) {
        this.name = name;
        this.shoes = shoes;
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

    public List<Shoes> getShoes() {
        return shoes;
    }

    public void setShoes(List<Shoes> shoes) {
        this.shoes = shoes;
    }
    @Override
    public String toString() {
        return "ShoesMaterial{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
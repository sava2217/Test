package com.store.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoesSize  extends AbstractEntity{
    private String ssname;
    @OneToMany(mappedBy = "shoesSize")
    private List<Shoes> shoesList = new ArrayList<>();

    public ShoesSize() {
    }

    public ShoesSize(String ssname, List<Shoes> shoesList) {
        this.ssname = ssname;
        this.shoesList = shoesList;
    }

    public String getSsname() {
        return ssname;
    }

    public void setSsname(String ssname) {
        this.ssname = ssname;
    }

    public List<Shoes> getShoesList() {
        return shoesList;
    }

    public void setShoesList(List<Shoes> shoesList) {
        this.shoesList = shoesList;
    }
}
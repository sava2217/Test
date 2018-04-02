package com.store.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Brand extends AbstractEntity{
    private String bName;

    @OneToMany(mappedBy = "brand")
    private List<Clothes> clothesList = new ArrayList<>();

    public Brand() {

    }

    public Brand(String bName, List<Brand> brandList){
        this.bName = bName;
        this.clothesList = clothesList;
    }


    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public List<Clothes> getClothesList() {
        return clothesList;
    }

    public void setClothesList(List<Clothes> clothesList) {
        this.clothesList = clothesList;
    }
}
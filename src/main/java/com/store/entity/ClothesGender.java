package com.store.entity;

import javax.persistence.Entity;

@Entity
public class ClothesGender extends AbstractEntity{
    private String bName;

    public ClothesGender() {

    }
    public ClothesGender(String bName){
        this.bName = bName;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }
}

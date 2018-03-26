package com.store.entity;

import javax.persistence.Entity;

@Entity
public class Brand extends AbstractEntity{
    private String bName;

    public Brand() {

    }
    public Brand(String bName){
        this.bName = bName;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }
}

package com.store.entity;

import javax.persistence.Entity;

@Entity
public class Season extends AbstractEntity {
    private String dName;

    public Season() {
}

    public Season(String dName) {
        this.dName = dName;
    }

    public String getcName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

}
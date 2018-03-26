package com.store.entity;

import javax.persistence.Entity;

@Entity
public class Color extends AbstractEntity {
    private String cName;

    public Color() {
    }

    public Color(String cName) {
        this.cName = cName;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

}

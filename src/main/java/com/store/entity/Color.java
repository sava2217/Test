package com.store.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Color extends AbstractEntity {
    private String cName;

    @OneToMany(mappedBy = "color")
    private List<Clothes> clothesList = new ArrayList<>();

    public Color() {
    }

    public Color(String cName, List<Clothes> clothesList) {
        this.cName = cName;
        this.clothesList = clothesList;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public List<Clothes> getClothesList() {
        return clothesList;
    }

    public void setClothesList(List<Clothes> clothesList) {
        this.clothesList = clothesList;
    }
}
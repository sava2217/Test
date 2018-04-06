package com.store.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Gender extends AbstractEntity{
    private String gName;

    @OneToMany(mappedBy = "gender")
    private List<Clothes> clothesList = new ArrayList<>();

    public Gender() {

    }
    public Gender(String bName, List<Clothes> clothesList){
        this.gName = bName;
        this.clothesList = clothesList;
    }

    public String getbName() {
        return gName;
    }

    public void setbName(String bName) {
        this.gName = bName;
    }

    public List<Clothes> getClothesList() {
        return clothesList;
    }

    public void setClothesList(List<Clothes> clothesList) {
        this.clothesList = clothesList;
    }
}
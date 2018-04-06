package com.store.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
public class ShoesMaterial extends AbstractEntity {
    private String smName;
    @OneToMany(mappedBy = "shoesMaterial")
    private List<Shoes> shoesList = new ArrayList<>();

    public ShoesMaterial() {

    }
    public ShoesMaterial (String smname, List<Shoes> shoesList){
        this.smName = smname;
        this.shoesList = shoesList;
    }

    public String getSmname() {
        return smName;
    }

    public void setSmname(String smname) {
        this.smName = smname;
    }

    public List<Shoes> getShoesList() {
        return shoesList;
    }

    public void setShoesList(List<Shoes> shoesList) {
        this.shoesList = shoesList;
    }
}
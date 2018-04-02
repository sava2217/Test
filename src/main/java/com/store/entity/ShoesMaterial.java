package com.store.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
public class ShoesMaterial extends AbstractEntity {
    private String smname;
    @OneToMany(mappedBy = "shoesMaterial")
    private List<Shoes> shoesList = new ArrayList<>();

    ShoesMaterial() {

    }
    public ShoesMaterial (String smname, List<Shoes> shoesList){
        this.smname = smname;
        this.shoesList = shoesList;
    }

    public String getSmname() {
        return smname;
    }

    public void setSmname(String smname) {
        this.smname = smname;
    }

    public List<Shoes> getShoesList() {
        return shoesList;
    }

    public void setShoesList(List<Shoes> shoesList) {
        this.shoesList = shoesList;
    }
}
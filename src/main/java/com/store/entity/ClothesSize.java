
package com.store.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ClothesSize extends AbstractEntity{
    private String csName;
    @OneToMany(mappedBy = "clothesSize")
    private List<Clothes> clothesList = new ArrayList<>();

    public ClothesSize() {

    }

    public ClothesSize(String csName, List<Clothes> clothesList) {
        this.csName = csName;
        this.clothesList = clothesList;
    }

    public String getcsName() {
        return csName;
    }

    public void setcsName(String csName) {
        this.csName = csName;
    }

    public List<Clothes> getClothesList() {
        return clothesList;
    }

    public void setClothesList(List<Clothes> clothesList) {
        this.clothesList = clothesList;
    }
}
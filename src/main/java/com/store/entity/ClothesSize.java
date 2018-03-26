
package com.store.entity;

import javax.persistence.Entity;

@Entity
public class ClothesSize extends AbstractEntity{
    private String bName;

    public ClothesSize() {

    }
    public ClothesSize(String bName){
        this.bName = bName;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }
}

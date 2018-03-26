
package com.store.entity;

import javax.persistence.Entity;

@Entity
public class ClothesMaterial extends AbstractEntity{
    private String bName;

    public ClothesMaterial() {

    }
    public ClothesMaterial(String bName){
        this.bName = bName;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }
}

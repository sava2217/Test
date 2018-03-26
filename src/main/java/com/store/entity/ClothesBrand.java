
package com.store.entity;

import javax.persistence.Entity;

@Entity
public class ClothesBrand extends AbstractEntity{
    private String bName;

    public ClothesBrand() {

    }
    public ClothesBrand(String bName){
        this.bName = bName;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }
}

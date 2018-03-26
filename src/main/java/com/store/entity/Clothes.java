
package com.store.entity;

        import javax.persistence.Entity;
        import javax.persistence.FetchType;
        import javax.persistence.ManyToOne;
        import java.math.BigDecimal;

@Entity
public class Clothes extends AbstractEntity{
    private final ClothesBrand ClothesBrand;
    private BigDecimal price;

    @ManyToOne(fetch=FetchType.LAZY)
    private ClothesBrand clothesBrand;
    @ManyToOne(fetch = FetchType.LAZY)
    private Color color;

    private Clothes(com.store.entity.ClothesBrand clothesBrand){

        ClothesBrand = clothesBrand;
    }
    public Clothes(BigDecimal price, Brand brand, Color color) {
        this.price = price;
        this.ClothesBrand = clothesBrand;
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ClothesBrand getBrand() {
        return clothesBrand;
    }

    public void setBrand(Brand brand) {
        this.clothesBrand = clothesBrand;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}


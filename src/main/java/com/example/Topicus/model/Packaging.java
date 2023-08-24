package com.example.Topicus.model;
import jakarta.persistence.*;

@Embeddable
public class Packaging {
    private String type;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int unitsPerPackage;

    @Column(nullable = false)
    private String amountPerUnit;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUnitsPerPackage() {
        return unitsPerPackage;
    }

    public void setUnitsPerPackage(int unitsPerPackage) {
        this.unitsPerPackage = unitsPerPackage;
    }

    public String getAmountPerUnit() {
        return amountPerUnit;
    }

    public void setAmountPerUnit(String amountPerUnit) {
        this.amountPerUnit = amountPerUnit;
    }
}

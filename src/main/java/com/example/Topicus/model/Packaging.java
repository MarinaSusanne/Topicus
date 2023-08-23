package com.example.Topicus.model;
import jakarta.persistence.*;

@Embeddable
public class Packaging {
    private String type;
    private int unitsPerPackage;
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

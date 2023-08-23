package com.example.Topicus.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PackagingDto {
    private String type;
    private int unitsPerPackage;
    private String amountPerUnit;
}

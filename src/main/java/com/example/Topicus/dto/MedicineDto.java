package com.example.Topicus.dto;
import com.example.Topicus.model.Packaging;
import com.example.Topicus.model.Prescription;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class MedicineDto {

    private Long id;
    private String name;
    private Set<Prescription> prescriptions;
    private PackagingDto packaging;

}

package com.example.Topicus.dto;
import com.example.Topicus.model.Medicine;
import com.example.Topicus.model.Patient;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class PrescriptionDto {

    private Long id;
    private LocalDate prescriptionDate;
    private LocalDate endDate;
    private String prescriptionInfo;
    private String deliveryMethod;
    private Long patientId;
    private List<Medicine> medicines;
}

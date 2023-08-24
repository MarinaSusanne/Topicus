package com.example.Topicus.dto;
import com.example.Topicus.model.Medicine;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PrescriptionDto {

    private Long id;
    private LocalDate prescriptionDate;
    private LocalDate endDate;

    @NotNull(message = "Info is required")
    private String prescriptionInfo;

    private String deliveryMethod;

    @NotNull(message = "Patient is required")
    private Long patientId;

    private List<Long> medicineIds;
}

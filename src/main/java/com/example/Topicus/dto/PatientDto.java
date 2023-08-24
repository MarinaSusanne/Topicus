package com.example.Topicus.dto;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientDto {
    private Long id;

    @NotNull(message = "BSN is required")
    private String bsn;

    @NotNull(message = "Name is required")
    private String name;

}

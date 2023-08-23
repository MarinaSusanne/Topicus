package com.example.Topicus.controller;
import com.example.Topicus.dto.PatientDto;
import com.example.Topicus.service.MedicineService;
import com.example.Topicus.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService=patientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getPatient(@PathVariable Long id) {
        PatientDto patientDto = patientService.getPatient(id);
        return ResponseEntity.ok(patientDto);
    }

    @PostMapping()
    public ResponseEntity<PatientDto> createPatient(@Valid @RequestBody PatientDto patientDto) {
        PatientDto createdPatient = patientService.createPatient(patientDto);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + createdPatient.getId()).toUriString());
        return ResponseEntity.created(uri).body(createdPatient);
    }

}

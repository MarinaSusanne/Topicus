package com.example.Topicus.controller;
import com.example.Topicus.dto.PrescriptionDto;
import com.example.Topicus.service.PrescriptionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService){
        this.prescriptionService=prescriptionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrescriptionDto> getPrescription(@PathVariable Long Id) {
        PrescriptionDto prescriptionDto = prescriptionService.getPrescription(Id);
        return ResponseEntity.ok(prescriptionDto);
    }

    @GetMapping("/patients/{patientId}")
    public ResponseEntity <List<PrescriptionDto>> getAllPrescriptionByPatientId(@PathVariable Long patientId) {
        List<PrescriptionDto> prescriptions = prescriptionService.getAllPrescriptionByPatientId(patientId);
        return ResponseEntity.ok(prescriptions);
    }

    @PostMapping()
    public ResponseEntity<PrescriptionDto> createPrescription(@Valid @RequestBody PrescriptionDto prescriptionDto) {
        PrescriptionDto createdPrescription = prescriptionService.createPrescription(prescriptionDto);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + createdPrescription.getId()).toUriString());
        return ResponseEntity.created(uri).body(createdPrescription);
    }
}

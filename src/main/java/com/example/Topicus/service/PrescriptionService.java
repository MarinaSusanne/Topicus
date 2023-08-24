package com.example.Topicus.service;

import com.example.Topicus.dto.PrescriptionDto;
import com.example.Topicus.exception.NotFoundException;
import com.example.Topicus.mapper.PrescriptionMapper;
import com.example.Topicus.model.Prescription;
import com.example.Topicus.repository.MedicineRepository;
import com.example.Topicus.repository.PrescriptionRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;

    private final MedicineRepository medicineRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository, MedicineRepository medicineRepository) {
        this.prescriptionRepository = prescriptionRepository;
        this.medicineRepository = medicineRepository;
    }

    //no use of modelmapper since there is a set within the dto which can go wrong in a modelmapper
    public PrescriptionDto getPrescription(Long id) {
        Prescription prescription = prescriptionRepository.findById(id).orElseThrow(() -> new NotFoundException("Prescription not found"));
        PrescriptionDto prescriptionDto = PrescriptionMapper.prescriptionToPrescriptionDto(prescription);
        return prescriptionDto;
    }


    @PostMapping()
    public ResponseEntity<PrescriptionDto> createPrescription(@Valid @RequestBody PrescriptionDto prescriptionDto) {
        PrescriptionDto createdPrescription = prescriptionService.createPrescription(prescriptionDto);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + createdPrescription.getId()).toUriString());
        return ResponseEntity.created(uri).body(createdPrescription);
    }

}
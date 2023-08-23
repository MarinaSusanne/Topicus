package com.example.Topicus.service;

import com.example.Topicus.dto.PatientDto;
import com.example.Topicus.exception.NotFoundException;
import com.example.Topicus.model.Patient;
import com.example.Topicus.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    public PatientService(PatientRepository patientRepository, ModelMapper modelMapper) {
        this.patientRepository = patientRepository;
        this.modelMapper = modelMapper;
    }

    public PatientDto getPatient(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new NotFoundException("Patient not found"));
        return modelMapper.map(patient, PatientDto.class);
    }

    public PatientDto createPatient(PatientDto patientDto) {
        Patient patient = modelMapper.map(patientDto, Patient.class);
        Patient createdPatient = patientRepository.save(patient);
        return modelMapper.map(createdPatient, PatientDto.class);
    }

}

package com.example.Topicus.repository;
import com.example.Topicus.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository <Prescription, Long> {
    List<Prescription> findAllByPatientId(Long patientId);
}

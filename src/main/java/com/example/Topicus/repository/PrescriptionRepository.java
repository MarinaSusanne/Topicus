package com.example.Topicus.repository;
import com.example.Topicus.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository <Prescription, Long> {
}

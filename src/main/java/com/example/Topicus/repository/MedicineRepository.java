package com.example.Topicus.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Topicus.model.Medicine;

public interface MedicineRepository extends JpaRepository <Medicine, Long> {

}
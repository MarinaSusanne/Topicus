package com.example.Topicus.repository;
import com.example.Topicus.model.Recept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceptRepository extends JpaRepository <Recept, Long> {
}

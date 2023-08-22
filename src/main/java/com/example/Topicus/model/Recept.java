package com.example.Topicus.model;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;


@Entity
@Table(name = "recepten")
public class Recept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate voorschrijfDatum;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate eindDatum;

    private String afleverMethode;

    //maar hoe zit dat nu met die relaties? Officieel toch aan 1 kant?
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;


    public LocalDate getVoorschrijfDatum() {
        return voorschrijfDatum;
    }

    public void setVoorschrijfDatum(LocalDate voorschrijfDatum) {
        this.voorschrijfDatum = voorschrijfDatum;
    }

    public LocalDate getEindDatum() {
        return eindDatum;
    }

    public void setEindDatum(LocalDate eindDatum) {
        this.eindDatum = eindDatum;
    }

    public String getAfleverMethode() {
        return afleverMethode;
    }

    public void setAfleverMethode(String afleverMethode) {
        this.afleverMethode = afleverMethode;
    }
}

package com.example.Topicus.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "patienten")
public class Patient {
    @Id
    private Long ISBN;

    @Column(nullable = false, unique = true)
    private String naam;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<Recept> recepten;


    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}

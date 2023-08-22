package com.example.Topicus.model;

import jakarta.persistence.*;

@Entity
@Table(name = "medicijnen")
public class Medicijn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String naam;

//hoe de verpakkings gegevens doen? Ken je embedded?
    private String verpakkingsEenheid;

    private String verpakkingsHoeveelheid;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}

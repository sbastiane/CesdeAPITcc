package com.example.LogisticAPP.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "merchandises")
public class Merchandise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iup;

    @Column(name = "occupied_volume", nullable = false, unique = false)
    private Double occupiedVolume;
    @Column(name = "occupied_weight", nullable = false, unique = false)
    private Double occupiedWeight;
    @Column(name = "names", nullable = false)
    private String names;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "entry_date", nullable = false)
    private LocalDate entryDate;
    @Column(name = "departure_date",nullable = true)
    private LocalDate departureDate;

    public Merchandise() {
    }

    public Merchandise(Integer iup, double occupiedVolume, double occupiedWeight, String names, String description, LocalDate entryDate, LocalDate departureDate) {
        this.iup = iup;
        this.occupiedVolume = occupiedVolume;
        this.occupiedWeight = occupiedWeight;
        this.names = names;
        this.description = description;
        this.entryDate = entryDate;
        this.departureDate = departureDate;
    }

    public Integer getIup() {
        return iup;
    }

    public void setIup(Integer iup) {
        this.iup = iup;
    }

    public Double getOccupiedVolume() {
        return occupiedVolume;
    }

    public void setOccupiedVolume(Double occupiedVolume) {
        this.occupiedVolume = occupiedVolume;
    }

    public Double getOccupiedWeight() {
        return occupiedWeight;
    }

    public void setOccupiedWeight(Double occupiedWeight) {
        this.occupiedWeight = occupiedWeight;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

//remitente
    //destinatario
    //zonaUbicacionBodega
}

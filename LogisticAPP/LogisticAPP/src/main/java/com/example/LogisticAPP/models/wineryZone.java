package com.example.LogisticAPP.models;

import jakarta.persistence.*;
@Entity
@Table(name = "winery_zones")
public class wineryZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer zoneId;

    @Column(name = "zone_name", nullable = false) //50 caracteres
    private String zoneName;

    @Column(name = "max_volume", nullable = false) //Solo positivo
    private Double maxVolume;

    @Column(name = "max_weight", nullable = false) //Solo positivo
    private Double maxWeight;

    @Column(name = "occupied_volume", nullable = false)// Solo positivo
    private Double occupiedVolume;

    @Column(name = "occupied_weight", nullable = false)// Solo positivo
    private Double occupiedWeight;

    public wineryZone() {
    }

    public wineryZone(Integer zoneId, String zoneName, Double maxVolume, Double maxWeight, Double occupiedVolume, Double occupiedWeight) {
        this.zoneId = zoneId;
        this.zoneName = zoneName;
        this.maxVolume = maxVolume;
        this.maxWeight = maxWeight;
        this.occupiedVolume = occupiedVolume;
        this.occupiedWeight = occupiedWeight;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Double getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(Double maxVolume) {
        this.maxVolume = maxVolume;
    }

    public Double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Double maxWeight) {
        this.maxWeight = maxWeight;
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
}

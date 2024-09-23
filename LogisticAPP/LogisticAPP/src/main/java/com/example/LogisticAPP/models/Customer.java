package com.example.LogisticAPP.models;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "names", nullable = false)
    private String names;

    @Column(name = "departament", nullable = false)
    private String departament;

    @Column(name = "town", nullable = false)
    private String town;

    @Column(name = "address", nullable = false)
    private Integer address;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "rol", nullable = false)
    private String rol;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    public Customer() {
    }

    public Customer(Integer id, String names, String departament, String town, Integer address, String postalCode, String rol, String email, String phone) {
        this.id = id;
        this.names = names;
        this.departament = departament;
        this.town = town;
        this.address = address;
        this.postalCode = postalCode;
        this.rol = rol;
        this.email = email;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

package com.intouncommon.backend.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
public class pendingProducers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contact;
    private String email;
    private String address;
    private String whatsapp;

    @OneToMany(mappedBy = "pendingProducers", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("producer-image")
    @ToString.Exclude
    private List<pendingProducts> pendingProducts;

    public pendingProducers() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
 public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<com.intouncommon.backend.Entity.pendingProducts> getPendingProducts() {
        return pendingProducts;
    }

    public void setPendingProducts(List<com.intouncommon.backend.Entity.pendingProducts> pendingProducts) {
        this.pendingProducts = pendingProducts;
    }
}

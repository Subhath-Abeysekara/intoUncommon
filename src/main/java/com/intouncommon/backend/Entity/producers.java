package com.intouncommon.backend.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
public class producers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long producerId;
    private String name;
    private String basicDetails;
    private String contact="0779421354";
    private String whatsApp = "";
    private String nicNo;
    private String email;

    @OneToMany(mappedBy = "producers", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference("producer-producerCategory")
    @ToString.Exclude
    private List<producerCategories> producerCategories;

    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("producer-product")
    @ToString.Exclude
    private List<productions> productions;



    public producers() {
    }

    public List<com.intouncommon.backend.Entity.productions> getProductions() {
        return productions;
    }

    public void setProductions(List<com.intouncommon.backend.Entity.productions> productions) {
        this.productions = productions;
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

    public String getWhatsApp() {
        return whatsApp;
    }

    public void setWhatsApp(String whatsApp) {
        this.whatsApp = whatsApp;
    }

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }
    public List<com.intouncommon.backend.Entity.producerCategories> getProducerCategories() {
        return producerCategories;
    }

    public void setProducerCategories(List<com.intouncommon.backend.Entity.producerCategories> producerCategories) {
        this.producerCategories = producerCategories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBasicDetails() {
        return basicDetails;
    }

    public void setBasicDetails(String basicDetails) {
        this.basicDetails = basicDetails;
    }

  /*  public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }*/

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }
}

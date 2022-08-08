package com.intouncommon.backend.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
public class requestedProducers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long producerId;
    private String name;
    private String basicDetails;
    private String contact="0779421354";
    private String whatsApp = "";
    private String nicNo;
    private String nicUrl;



    public requestedProducers() {
    }


    public String getNicUrl() {
        return nicUrl;
    }

    public void setNicUrl(String nicUrl) {
        this.nicUrl = nicUrl;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

package com.intouncommon.backend.Entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class productions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uses;
    private String specialData;
    private String primaryData;
    private int amount=0;


    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "producer",referencedColumnName = "producerId")
    private producers producer;



    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "category",referencedColumnName = "categoryId")
    private categories category;

    public productions() {
    }

    public producers getProducer() {
        return producer;
    }

    public void setProducer(producers producer) {
        this.producer = producer;
    }

    public categories getCategory() {
        return category;
    }

    public void setCategory(categories category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimaryData() {
        return primaryData;
    }

    public void setPrimaryData(String primaryData) {
        this.primaryData = primaryData;
    }

    public String getUses() {
        return uses;
    }

    public void setUses(String uses) {
        this.uses = uses;
    }

    public String getSpecialData() {
        return specialData;
    }

    public void setSpecialData(String specialData) {
        this.specialData = specialData;
    }
}

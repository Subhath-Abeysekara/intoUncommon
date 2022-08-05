package com.intouncommon.backend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.ToString;

import javax.persistence.*;

@Entity
public class pendingProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "pendingProducers", foreignKey = @ForeignKey(name = "producer_image_fk1"))
    @JsonBackReference(value = "producer-image")
    @ToString.Exclude
    private pendingProducers pendingProducers;

    public pendingProducts() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public com.intouncommon.backend.Entity.pendingProducers getPendingProducers() {
        return pendingProducers;
    }

    public void setPendingProducers(com.intouncommon.backend.Entity.pendingProducers pendingProducers) {
        this.pendingProducers = pendingProducers;
    }
}

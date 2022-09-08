package com.intouncommon.backend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.ToString;

import javax.persistence.*;

@Entity
public class uploadProductImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "uploadProducts", foreignKey = @ForeignKey(name = "uploadProducts_image_fk1"))
    @JsonBackReference(value = "uploadProduct-image")
    @ToString.Exclude
    private uploadProducts uploadProducts;

    public uploadProductImages() {
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

    public com.intouncommon.backend.Entity.uploadProducts getUploadProducts() {
        return uploadProducts;
    }

    public void setUploadProducts(com.intouncommon.backend.Entity.uploadProducts uploadProducts) {
        this.uploadProducts = uploadProducts;
    }
}

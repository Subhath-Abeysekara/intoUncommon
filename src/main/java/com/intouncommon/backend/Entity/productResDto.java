package com.intouncommon.backend.Entity;

import lombok.Data;

import java.util.List;

@Data
public class productResDto {

    private Long id;
    private String uses;
    private String specialData;
    private String size;
    private String color;
    private String price;
    private String material;
    private String options;
    private String warranty;
    private String delivery;
    private String brand;
    private int amount=0;
    private List<productImages> productImages;
    private String specialUsage;
    private String madeIn;
    private String designBy;
    private String inventBy;
    private String qualityOf;
    private String addDate;
    private categoryDto category;
    private producerDto producer;
    private stateCodeDto statecodes;


    public productResDto() {
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSpecialUsage() {
        return specialUsage;
    }

    public void setSpecialUsage(String specialUsage) {
        this.specialUsage = specialUsage;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public String getDesignBy() {
        return designBy;
    }

    public void setDesignBy(String designBy) {
        this.designBy = designBy;
    }

    public String getInventBy() {
        return inventBy;
    }

    public void setInventBy(String inventBy) {
        this.inventBy = inventBy;
    }

    public String getQualityOf() {
        return qualityOf;
    }

    public void setQualityOf(String qualityOf) {
        this.qualityOf = qualityOf;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public categoryDto getCategory() {
        return category;
    }

    public void setCategory(categoryDto category) {
        this.category = category;
    }

    public producerDto getProducer() {
        return producer;
    }

    public void setProducer(producerDto producer) {
        this.producer = producer;
    }

    public stateCodeDto getStatecodes() {
        return statecodes;
    }

    public void setStatecodes(stateCodeDto statecodes) {
        this.statecodes = statecodes;
    }

    public List<com.intouncommon.backend.Entity.productImages> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<com.intouncommon.backend.Entity.productImages> productImages) {
        this.productImages = productImages;
    }
}

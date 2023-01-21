package com.intouncommon.backend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class productions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String addDate;

    private Long cat = 0L;
    private String cat_type="";

    private String cat_material = "";

    private String producer_name = "";

    private String producer_basicDetails = "";

    private String repayColor = "";

    private String changeColor = "";

    private String warrantyColor="";

    private String discountColor = "";



    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "producer", foreignKey = @ForeignKey(name = "product_producer_fk1"))
    @JsonBackReference(value = "producer-product")
    @ToString.Exclude
    private producers producer;



   @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "category", foreignKey = @ForeignKey(name = "product_category_fk1"))
    @JsonBackReference(value = "category-product")
    @ToString.Exclude
    private categories category;

    @OneToMany(mappedBy = "productions", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("product-image")
    @ToString.Exclude
    private List<productImages> productImages;

    public productions() {
    }

    public producers getProducer() {
        return producer;
    }

    public void setProducer(producers producer) {
        this.producer = producer;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public List<com.intouncommon.backend.Entity.productImages> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<com.intouncommon.backend.Entity.productImages> productImages) {
        this.productImages = productImages;
    }

    public String getCat_type() {
        return cat_type;
    }

    public void setCat_type(String cat_type) {
        this.cat_type = cat_type;
    }

    public String getCat_material() {
        return cat_material;
    }

    public void setCat_material(String cat_material) {
        this.cat_material = cat_material;
    }

    public String getProducer_name() {
        return producer_name;
    }

    public void setProducer_name(String producer_name) {
        this.producer_name = producer_name;
    }

    public String getRepayColor() {
        return repayColor;
    }

    public void setRepayColor(String repayColor) {
        this.repayColor = repayColor;
    }

    public String getChangeColor() {
        return changeColor;
    }

    public void setChangeColor(String changeColor) {
        this.changeColor = changeColor;
    }

    public String getWarrantyColor() {
        return warrantyColor;
    }

    public void setWarrantyColor(String warrantyColor) {
        this.warrantyColor = warrantyColor;
    }

    public String getDiscountColor() {
        return discountColor;
    }

    public void setDiscountColor(String discountColor) {
        this.discountColor = discountColor;
    }

    public String getProducer_basicDetails() {
        return producer_basicDetails;
    }

    public void setProducer_basicDetails(String producer_basicDetails) {
        this.producer_basicDetails = producer_basicDetails;
    }

    public Long getCat() {
        return cat;
    }

    public void setCat(Long cat) {
        this.cat = cat;
    }
}

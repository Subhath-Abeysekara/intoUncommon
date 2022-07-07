package com.intouncommon.backend.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
public class statecodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stateId;
    private String state_type;
    private String repayColor = "red";
    private String changeColor = "red";
    private String warrantyColor = "red";
    private String discountColor="red";


    @OneToMany(mappedBy = "statecodes", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("statecode-product")
    @ToString.Exclude
    private List<uncommonProduct> uncommonProducts;


    public statecodes() {
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

    public List<uncommonProduct> getUncommonProducts() {
        return uncommonProducts;
    }

    public void setUncommonProducts(List<uncommonProduct> uncommonProducts) {
        this.uncommonProducts = uncommonProducts;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getState_type() {
        return state_type;
    }

    public void setState_type(String state_type) {
        this.state_type = state_type;
    }
}

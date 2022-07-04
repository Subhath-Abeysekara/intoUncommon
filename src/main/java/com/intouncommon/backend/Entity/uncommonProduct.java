package com.intouncommon.backend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.ToString;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "uncommon_fk1"))
public class uncommonProduct extends productions {

   private String specialUsage;
   private String madeIn;
   private String designBy;
   private String inventBy;
   private String qualityOf;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "statecode", foreignKey = @ForeignKey(name = "product_statecode_fk1"))
    @JsonBackReference(value = "statecode-product")
    @ToString.Exclude
    private  statecodes statecodes;

    public uncommonProduct() {
    }


    public com.intouncommon.backend.Entity.statecodes getStatecodes() {
        return statecodes;
    }

    public void setStatecodes(com.intouncommon.backend.Entity.statecodes statecodes) {
        this.statecodes = statecodes;
    }

    public String getSpecialUsage() {
        return specialUsage;
    }

//    public com.intouncommon.backend.Entity.statecodes getStatecodes() {
//        return statecodes;
//    }
//
//    public void setStatecodes(com.intouncommon.backend.Entity.statecodes statecodes) {
//        this.statecodes = statecodes;
//    }

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
}

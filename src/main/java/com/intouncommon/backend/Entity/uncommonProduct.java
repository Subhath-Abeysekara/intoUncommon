package com.intouncommon.backend.Entity;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "uncommon_fk1"))
public class uncommonProduct extends productions {

   private String specialUsage;
   private String responsibility;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "statecodes",referencedColumnName = "stateId")
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

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }
}

package com.intouncommon.backend.Entity;

import lombok.Data;

@Data
public class productResDto {

    private productions productions;
    private categories categories;
    private producers producers;

    public productResDto() {
    }

    public com.intouncommon.backend.Entity.productions getProductions() {
        return productions;
    }

    public void setProductions(com.intouncommon.backend.Entity.productions productions) {
        this.productions = productions;
    }

    public com.intouncommon.backend.Entity.categories getCategories() {
        return categories;
    }

    public void setCategories(com.intouncommon.backend.Entity.categories categories) {
        this.categories = categories;
    }

    public com.intouncommon.backend.Entity.producers getProducers() {
        return producers;
    }

    public void setProducers(com.intouncommon.backend.Entity.producers producers) {
        this.producers = producers;
    }
}

package com.intouncommon.backend.Entity;

import lombok.Data;

@Data
public class productionDto {

    private productions productions;
    private Long categoryId=1L;
    private Long producerId=1L;

    public productionDto() {
    }

    public com.intouncommon.backend.Entity.productions getProductions() {
        return productions;
    }

    public void setProductions(com.intouncommon.backend.Entity.productions productions) {
        this.productions = productions;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }
}

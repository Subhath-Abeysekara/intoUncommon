package com.intouncommon.backend.Entity;

import lombok.Data;

@Data
public class uncommonProductDto {

    private uncommonProduct uncommonProduct;
    private Long categoryId=1L;
    private Long producerId=1L;
    private Long stateId=1L;

    public uncommonProductDto() {
    }

    public com.intouncommon.backend.Entity.uncommonProduct getUncommonProduct() {
        return uncommonProduct;
    }

    public void setUncommonProduct(com.intouncommon.backend.Entity.uncommonProduct uncommonProduct) {
        this.uncommonProduct = uncommonProduct;
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

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }
}

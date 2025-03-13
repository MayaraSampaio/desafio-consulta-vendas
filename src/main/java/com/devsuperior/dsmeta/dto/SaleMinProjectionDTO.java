package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.projections.SaleMinProjection;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaleMinProjectionDTO {
    @JsonProperty("sellerName")
    private String name;
    @JsonProperty("total")
    private Double amount;

    public SaleMinProjectionDTO(String name, Double amount) {
        this.name = name;
        this.amount = amount;
    }

    public SaleMinProjectionDTO(SaleMinProjection projection) {
        name = projection.getName();
        amount = projection.getAmount();
    }

    public String getName() {
        return name;
    }

    public Double getAmount() {
        return amount;
    }


}

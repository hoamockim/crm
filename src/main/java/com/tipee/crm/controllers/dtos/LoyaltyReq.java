package com.tipee.crm.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tipee.crm.services.loyalty.LoyaltyType;

import lombok.Data;

@Data
public class LoyaltyReq {
    
    @JsonProperty
    Integer point;

    @JsonProperty
    LoyaltyType type;

    @JsonProperty
    String description;

}

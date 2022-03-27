package com.tipee.crm.services.loyalty;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.kafka.common.protocol.types.Field.Int8;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("loyalty")
public class Loyalty implements Serializable {
    @Id
    Integer id;
   
    @JsonProperty("code")
    @Column("code")
    String code;

    @JsonProperty("type")
    @Column("type")
    LoyaltyType type;

    @JsonProperty("point")
    @Column("point")
    Int8 point;

    @JsonProperty("description")
    @Column("description")
    private String description;
}

package com.tipee.crm.services.loyalty;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("loyalty")
public class Loyalty implements Serializable {
    @Id
    Long id;
   
    @JsonProperty("code")
    @Column()
    String code;

    @JsonProperty("type")
    @Column()
    LoyaltyType type;

    @JsonProperty("point")
    @Column()
    Integer point;

    @JsonProperty("description")    
    @Column()
    String description;

    @JsonIgnore
    @Column("created_on")
    private Long createdOn;

    @JsonIgnore
    @Column("updated_on")
    private Long updatedOn;
}

package com.tipee.crm.services.campaign;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("campgain")
public class Campaign implements Serializable {
    @Id
    Long id;

    @Column
    String code;

    @Column
    String description;

    @JsonIgnore
    @Column("created_at")
    private Long createdAt;

    @JsonIgnore
    @Column("updated_at")
    private Long updatedAt;
}

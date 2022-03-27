package com.tipee.crm.services.campaign;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampainRepository extends R2dbcRepository<Campaign, Integer> {
    
}

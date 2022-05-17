package com.tipee.crm.services.survey;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface SurveyRepository extends ReactiveCrudRepository<Survey, Long> {
    
}

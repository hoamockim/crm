package com.tipee.crm.services.loyalty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LoyaltyService {

    @Autowired
    LoyaltyRepository repository;
    
    public Mono<Loyalty> getLoyaltyByCode(String code) {
        return repository.getByCode(code);
    }

    public Flux<Loyalty> fetchLoaylties(List<String> codes){
        return repository.findAll();
    }

    public Mono<Loyalty> create(String code, String description) {
        Loyalty loyalty = new Loyalty();
        loyalty.setCode(code);
        loyalty.setDescription(description);
        return repository.save(loyalty);
    }

    public Mono<Loyalty> update(String code, String description) {
        return null;
    }
}

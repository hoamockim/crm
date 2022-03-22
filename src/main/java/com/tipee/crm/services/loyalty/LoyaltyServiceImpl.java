package com.tipee.crm.services.loyalty;

import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class LoyaltyServiceImpl  implements LoyaltyService{

    @Override
    public Flux<Loyalty> getLoyalties() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Flux<Loyalty> fetchLoaylties(List<String> codes) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mono<Loyalty> getLoyaltyByCode(String code) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mono<Loyalty> create(String description) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mono<Loyalty> delete(String code) {
        // TODO Auto-generated method stub
        return null;
    }
    
}

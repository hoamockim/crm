package com.tipee.crm.services.loyalty;

import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LoyaltyService {
    Flux<Loyalty>  getLoyalties();
    Flux<Loyalty> fetchLoaylties(List<String> codes);
    Mono<Loyalty> getLoyaltyByCode(String code);
    Mono<Loyalty> create(String description) ;
    Mono<Loyalty> delete(String code);
}

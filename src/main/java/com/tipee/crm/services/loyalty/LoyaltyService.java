package com.tipee.crm.services.loyalty;

import java.util.Date;
import java.util.List;

import com.tipee.crm.util.StringUtil;

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

    public Mono<Loyalty> getById(Long id) {
        return repository.findById(id)
        .switchIfEmpty(Mono.error(new LoyaltyException(id)));
    }

    public Flux<Loyalty> fetchLoaylties(List<String> codes){
        return repository.findAll();
    }

    public Mono<Loyalty> save(String description, Integer point, LoyaltyType loyaltyType) {
        return repository.save(this.create(description, point, loyaltyType));
    }

    private Loyalty create(String description, Integer point, LoyaltyType loyaltyType) {
        Loyalty loyalty = new Loyalty();
        loyalty.setCode(StringUtil.random(30));
        loyalty.setDescription(description);
        loyalty.setPoint(point);
        loyalty.setType(loyaltyType);
        loyalty.setCreatedOn(StringUtil.convertDateToSeconds(new Date()));
        loyalty.setUpdatedOn(StringUtil.convertDateToSeconds(new Date()));
        return loyalty;
    }

    public Mono<Loyalty> update(String code, String description) {
        return null;
    }
}

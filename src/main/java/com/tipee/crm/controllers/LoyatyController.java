package com.tipee.crm.controllers;

import com.tipee.crm.Route;
import com.tipee.crm.controllers.dtos.ResponseDto;
import com.tipee.crm.services.loyalty.LoyaltyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(Route.app + "loyalty")
public class LoyatyController {

    @Autowired
    LoyaltyService loyaltyService;
    
    @GetMapping("{code}")
    public Mono<ResponseDto> getById(@PathVariable(name = "code") String code){
        return ResponseDto.getMonoInstance(loyaltyService.getLoyaltyByCode(code)) ;
    }
}

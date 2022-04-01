package com.tipee.crm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

import com.tipee.crm.Route;
import com.tipee.crm.controllers.dtos.ResponseDto;
import com.tipee.crm.services.campaign.CampaignService;

@RestController
@RequestMapping(Route.app + "campaign")
public class CampaignController {
    
    @Autowired
    CampaignService campaignService;

    @GetMapping("{id}")
    public Mono<ResponseDto> get(@PathVariable(name = "id") Long id){
        return Mono.empty();
    }
}

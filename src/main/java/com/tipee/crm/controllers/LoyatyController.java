package com.tipee.crm.controllers;

import com.tipee.crm.Route;
import com.tipee.crm.controllers.dtos.LoyaltyReq;
import com.tipee.crm.controllers.dtos.ResponseDto;
import com.tipee.crm.services.loyalty.LoyaltyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(Route.app + "loyalty")
public class LoyatyController {

  @Autowired
  LoyaltyService loyaltyService;
  
  @GetMapping("{id}")
  public Mono<ResponseDto> getById(@PathVariable(name = "id") Long id){
    return loyaltyService.getById(id)
    .flatMap(l ->  ResponseDto.getMonnoInstanceFromData(l, "loyalty", "Ok"))
    .onErrorResume(e ->  ResponseDto.getMonnoInstanceFromData(null, "loyalty", e.getMessage()));
  }

  @PostMapping()
  public Mono<ResponseDto> create(@RequestBody LoyaltyReq bodyReq){
    return loyaltyService.save(
      bodyReq.getDescription(), 
      bodyReq.getPoint(),  
      bodyReq.getType())
    .flatMap(l -> ResponseDto.getMonnoInstanceFromData(l, "loyalty", "Ok"))
    .onErrorResume(e ->  ResponseDto.getMonnoInstanceFromData(null, "loyalty", e.getMessage()));
  }
}

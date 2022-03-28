package com.tipee.crm.controllers;

import com.tipee.crm.Route;
import com.tipee.crm.controllers.dtos.ResponseDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(Route.app + "sys/")
public class AppController {
    @GetMapping("health-check")
    public Mono<ResponseDto> healthCheck() {
        return ResponseDto.getMonnoInstanceFromData("System running well", null, null);
    }
}

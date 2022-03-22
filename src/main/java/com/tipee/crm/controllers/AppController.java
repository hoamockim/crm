package com.tipee.crm.controllers;

import com.tipee.crm.Route;
import com.tipee.crm.controllers.dtos.ResponseDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Route.app + "sys/")
public class AppController {
    @GetMapping("health-check")
    public ResponseEntity healthCheck() {
        return new ResponseEntity<>(ResponseDto.heathCheckSuccess(),  HttpStatus.OK);
    }
}

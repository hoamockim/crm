package com.tipee.crm.controllers.advice;

import java.util.LinkedHashMap;
import java.util.Map;

import com.tipee.crm.services.loyalty.LoyaltyException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(LoyaltyException.class)
    public ResponseEntity<Object> loyaltyNotFoundException(LoyaltyException loyaltyNotFound){ 
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", loyaltyNotFound.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}

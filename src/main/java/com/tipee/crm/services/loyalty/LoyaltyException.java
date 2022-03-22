package com.tipee.crm.services.loyalty;

public class LoyaltyException extends RuntimeException {
    public LoyaltyException(String code){
        super("Loyalty error: " + code);
    }
}

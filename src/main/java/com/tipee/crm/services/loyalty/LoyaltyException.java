package com.tipee.crm.services.loyalty;

public class LoyaltyException extends RuntimeException {
    Long id ;
    public LoyaltyException(Long id){
        super("Loyalty error: " + id);
        this.id = id;
    }

    @Override
    public String getMessage(){
        return String.format("loyalty %s not valid", id);
    }
}

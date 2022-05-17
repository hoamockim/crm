package com.tipee.crm.services.campaign;

public class CampaignException extends RuntimeException {
    String code;
    
    public CampaignException(String code) {
        super("loyalty code: " + code);
        this.code = code;
    }

    @Override
    public String getMessage(){ 
        return "";
    }
}
